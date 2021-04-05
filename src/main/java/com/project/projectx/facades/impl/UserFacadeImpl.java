package com.project.pavani.facades.impl;

import com.project.pavani.facades.UserFacade;
import com.project.pavani.facades.data.UserData;
import com.project.pavani.models.UserModel;
import com.project.pavani.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ayush.pandey
 */
@Component
public class UserFacadeImpl implements UserFacade {

	private final UserService userService;

	private final PasswordEncoder passwordEncoder;

	public UserFacadeImpl(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Boolean registerUser(UserData userData) {
		try {
			userService.registerUser(userData,passwordEncoder.encode(userData.getPassword()));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public Boolean activateUser(String userEmail, String otp)
	{
		 return userService.activateUser(userEmail, otp);
	}


	public UserService getUserService() {
		return userService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
}
