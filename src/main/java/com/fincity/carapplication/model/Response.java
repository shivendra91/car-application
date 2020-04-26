package com.fincity.carapplication.model;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class Response {

    private Integer id;
    private String message;
    private HttpStatus httpStatus;

    public Response(String message) {
        this.message = message;
    }

    public Response(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(HttpStatus httpStatus, String message, Integer id) {
        this.id = id;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
