package com.sda.spring.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public void handleException(BookNotFoundException e){
        System.out.println("WYKONUJE WYJATEK");
    }

}
