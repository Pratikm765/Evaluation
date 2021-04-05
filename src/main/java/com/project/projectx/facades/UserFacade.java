package com.project.pavani.facades;

import com.project.pavani.facades.data.UserData;
import com.project.pavani.models.UserModel;

public interface UserFacade {
	public Boolean registerUser(UserData userData);

	public Boolean activateUser(String userEmail, String otp);
}
