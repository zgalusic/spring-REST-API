package com.ingemark.business.service;

public class ServiceGeneralException extends RuntimeException {
    private static final long serialVersionUID = 2120044906679704503L;

    private final String customMessage;

    public ServiceGeneralException(String message) {
        super(message);
        this.customMessage = null;
    }

    public ServiceGeneralException(Throwable cause) {
        super(cause);
        this.customMessage = null;
    }

    public ServiceGeneralException(String message, String customMessage) {
        super(message);
        this.customMessage = customMessage;
    }

    public ServiceGeneralException(String message, Throwable cause, String customMessage) {
        super(message, cause);
        this.customMessage = customMessage;
    }

    public ServiceGeneralException(Throwable cause, String customMessage) {
        super(cause);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
