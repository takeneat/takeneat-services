package com.takeneat.services.api.exceptions;

/**
 * Class used to parse error response from Spring RestController.
 *
 * @author paoesco
 */
public class ExceptionDTO {

    private int status;
    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
