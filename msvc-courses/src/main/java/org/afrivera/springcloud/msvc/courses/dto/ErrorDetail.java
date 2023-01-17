package org.afrivera.springcloud.msvc.courses.dto;

import java.util.Date;

public class ErrorDetail {

    private Date date_time;
    private String message;
    private int status;
    private Object data;

    public ErrorDetail(String message, int status) {
        this.date_time = new Date();
        this.message = message;
        this.status = status;
    }

    public ErrorDetail(String message, int status, Object data) {
        this(message, status);
        this.data = data;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
