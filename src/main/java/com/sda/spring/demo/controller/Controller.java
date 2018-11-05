package com.sda.spring.demo.controller;


import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String hello(){
        return "Hello world";
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        return book;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books(){
        return bookRepository.findAll();
    }

}
