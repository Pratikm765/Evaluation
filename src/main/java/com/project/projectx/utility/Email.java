package com.project.pavani.utility;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.project.pavani.config.ProjectPavaniProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Email {
    private ProjectPavaniProperties projectPavaniProperties;

    Email(ProjectPavaniProperties projectPavaniProperties){
        this.projectPavaniProperties = projectPavaniProperties;
    }

    public void sendmail(String toEmail, String subject, String content) throws IOException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", projectPavaniProperties.getSmtp().getHost());
        props.put("mail.smtp.port", projectPavaniProperties.getSmtp().getPort());
        Session session = null;
        try{
            session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(projectPavaniProperties.getSmtp().getUsername(), projectPavaniProperties.getSmtp().getPassword());
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(projectPavaniProperties.getSmtp().getUsername(), false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        msg.setSubject(subject);
        //String content = Jsoup.parse(new File(htmlPath), "UTF-8").toString();
        msg.setContent(content, "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }

}
