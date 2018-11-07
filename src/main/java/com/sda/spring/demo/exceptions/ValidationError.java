package com.sda.spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationError {

    private HttpStatus httpStatus;
    private List<ObjectError> objectErrors;

    public ValidationError(HttpStatus httpStatus, List<ObjectError> objectErrors) {
        this.httpStatus = httpStatus;
        this.objectErrors = objectErrors;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<ObjectError> getObjectErrors() {
        return objectErrors;
    }

    public void setObjectErrors(List<ObjectError> objectErrors) {
        this.objectErrors = objectErrors;
    }
}
