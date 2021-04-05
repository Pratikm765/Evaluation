package com.project.pavani.service.impl;
/**
 * @author ayush.pandey
 */
import com.project.pavani.exceptions.EmailAlreadyUsedException;
import com.project.pavani.facades.data.UserData;
import com.project.pavani.models.Authority;
import com.project.pavani.models.EmailTemplates;
import com.project.pavani.models.UserModel;
import com.project.pavani.repository.AuthorityRepository;
import com.project.pavani.repository.EmailTemplatesRepository;
import com.project.pavani.repository.UserRepository;
import com.project.pavani.security.AuthoritiesConstants;
import com.project.pavani.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.pavani.security.opt.Otp;
import com.project.pavani.utility.Email;
import org.jsoup.Jsoup;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final EmailTemplatesRepository emailTemplatesRepository;

    private final Email email;

    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, EmailTemplatesRepository emailTemplatesRepository, Email email) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.emailTemplatesRepository = emailTemplatesRepository;
        this.email = email;
    }

    public UserModel registerUser(UserData userData, String encryptedPassword) {

        userRepository.findOneByEmailIgnoreCase(userData.getEmail()).ifPresent(existingUser -> {
            boolean removed = removeNonActivatedUser(existingUser);
            if (!removed) {
                throw new EmailAlreadyUsedException();
            }
        });
        UserModel newUser = new UserModel();
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        if (userData.getEmail() != null) {
            newUser.setEmail(userData.getEmail().toLowerCase());
        }
        // new user is not active
        newUser.setActivated(false);

        //Right now setting USER Authority by default
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        newUser.setAuthorities(authorities);
        newUser.setUserId(userData.getEmail());
        //User otp generation
        newUser.setActivationKey(Otp.optGenerator());
        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);

        //Send email to the user
        sendActivationEmail(newUser);
        return newUser;
    }

    public Boolean activateUser(String userEmail, String otp){
        final Boolean activationSuccessfull = false;
        userRepository.findOneByEmailIgnoreCase(userEmail).ifPresent(existingUser -> {
          existingUser.setActivated(Boolean.TRUE);
          userRepository.save(existingUser);
        });
        return true;
    }
    private boolean removeNonActivatedUser(UserModel existingUser) {
        if (existingUser.isActivated()) {
            return false;
        }
        userRepository.delete(existingUser);
        userRepository.flush();
        return true;
    }

    private boolean sendActivationEmail(UserModel newUser) {
        try{
            EmailTemplates emailTemplates = emailTemplatesRepository.findOneByActionIgnoreCase("account_activation");
            File directory = new File("./");
            System.out.println(directory.getAbsolutePath());
            String content = Jsoup.parse(new File(emailTemplates.getHtmlPath()), "UTF-8").toString();
            content = content.replace("#otp", newUser.getActivationKey());
            email.sendmail(newUser.getEmail(),emailTemplates.getSubject(),content);
        }
        catch (IOException ex){
            return false;
        }
        catch (MessagingException ex){
            return false;
        }
        return true;
    }
}
