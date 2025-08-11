package xyz.dlulalne.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {

    private int status;
    private String message;
    private LocalDate timestamp;

    public ErrorDetails() {
    }

    public ErrorDetails(int status, String message, LocalDate timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
