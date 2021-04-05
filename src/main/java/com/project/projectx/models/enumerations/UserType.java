package com.project.pavani.models.enumerations;

public enum UserType {
	JOB_SEEKER("JobSeeker"),
	INTERVIEWER("Interviewer"),
	RECRUITER("Recruiter");

	private final String value;


	UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
