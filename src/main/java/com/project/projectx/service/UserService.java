package com.project.pavani.service;

import com.project.pavani.facades.data.UserData;
import com.project.pavani.models.UserModel;

public interface UserService {
	public UserModel registerUser(UserData userData, String encryptedPassword);

	public Boolean activateUser(String userEmail, String otp);
}
