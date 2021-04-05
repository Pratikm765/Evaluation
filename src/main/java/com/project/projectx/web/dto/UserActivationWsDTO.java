package com.project.pavani.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ayush
 */
public class UserActivationWsDTO {

    @Email
    @Size(min = 5, max = 254)
    @NotNull
    private String emailId;

    @NotNull
    private String activationKey;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
}
