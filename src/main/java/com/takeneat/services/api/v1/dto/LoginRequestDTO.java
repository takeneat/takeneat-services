package com.takeneat.services.api.v1.dto;

import javax.validation.constraints.NotNull;

/**
 * @author paoesco
 */
public class LoginRequestDTO {

    @NotNull
    private String email;
    @NotNull
    private String password;
    private String mobileId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

}
