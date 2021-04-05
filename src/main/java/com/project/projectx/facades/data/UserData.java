package com.project.pavani.facades.data;

import com.project.pavani.config.Constants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author ayush
 */
public class UserData {

	private Long id;

	@NotBlank
	@Pattern(regexp = Constants.USER_ID_REGEX)
	@Size(min = 1, max = 50)
	private String userId;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	private String email;

	@Size(max = 256)
	private String imageUrl;

	private String password;

	private boolean activated = false;

	public UserData() {
	}

	public UserData(Long id, @NotBlank @Pattern(regexp = Constants.USER_ID_REGEX) @Size(min = 1, max = 50) String userId, @Size(max = 50) String firstName, @Size(max = 50) String lastName, @Email @Size(min = 5, max = 254) String email, @Size(max = 256) String imageUrl, String password, boolean activated) {
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imageUrl = imageUrl;
		this.password = password;
		this.activated = activated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
