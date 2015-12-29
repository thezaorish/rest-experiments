package com.zaorish.stm.web.exception;

import java.util.Objects;

public class ApiError {

    private int status;
    private String message;
    private String detailedMessage;

    public ApiError(final int status, final String message, final String detailedMessage) {
        this.status = status;
        this.message = message;
        this.detailedMessage = detailedMessage;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(final int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }
    public void setDetailedMessage(final String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return status == apiError.status && Objects.equals(message, apiError.message) && Objects.equals(detailedMessage, apiError.detailedMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, detailedMessage);
    }

    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [status=").append(status).append(", message=").append(message).append(", detailedMessage=").append(detailedMessage).append("]");
        return builder.toString();
    }

}
