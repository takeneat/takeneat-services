package com.takeneat.services.api.v1.dto;

/**
 * @author paoesco
 */
public class LoginRequestDTO {

    private String email;
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
