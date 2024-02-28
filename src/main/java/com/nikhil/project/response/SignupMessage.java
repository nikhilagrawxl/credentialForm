package com.nikhil.project.response;

public class SignupMessage {
    String message;
    Boolean status;

    int otp;

    public SignupMessage() {
    }

    public SignupMessage(String message, Boolean status, int otp) {
        this.message = message;
        this.status = status;
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "SignupMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", otp=" + otp +
                '}';
    }
}
