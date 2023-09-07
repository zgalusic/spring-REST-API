package com.ingemark.wrapper;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = -7128574589379591464L;
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
