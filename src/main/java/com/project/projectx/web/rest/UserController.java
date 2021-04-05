package com.project.pavani.web.rest;

import com.project.pavani.exceptions.InvalidPasswordException;
import com.project.pavani.facades.UserFacade;
import com.project.pavani.facades.data.UserData;
import com.project.pavani.web.dto.UserRegisterWsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ayush.pandey
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserFacade userFacade;

	public UserController(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean registerAccount(@Valid @RequestBody UserRegisterWsDTO userRegisterWsDTO) {
		if (!checkPasswordLength(userRegisterWsDTO.getPassword())) {
			throw new InvalidPasswordException();
		}
		UserData registerUserData = new UserData();
		registerUserData.setEmail(userRegisterWsDTO.getEmailId());
		registerUserData.setPassword(userRegisterWsDTO.getPassword());
		return userFacade.registerUser(registerUserData);

	}

	@PostMapping("/activateUser")
	@ResponseStatus(HttpStatus.OK)
	public Boolean activateUser(@RequestParam String emailId, @RequestParam String otp)
	{
		return userFacade.activateUser(emailId,otp);
	}

	private static boolean checkPasswordLength(String password) {
		return !StringUtils.isEmpty(password) &&
					   password.length() >= UserRegisterWsDTO.PASSWORD_MIN_LENGTH &&
					   password.length() <= UserRegisterWsDTO.PASSWORD_MAX_LENGTH;
	}
}
