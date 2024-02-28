package com.nikhil.project.response;

public class VerificationMessage {

    String message;
    Boolean status;
    public VerificationMessage() {
    }
    public VerificationMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
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

    @Override
    public String toString() {
        return "VerificationMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
