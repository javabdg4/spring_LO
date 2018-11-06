package com.sda.spring.demo.controller;


import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String hello(){
        return "Hello world";
    }

    @RequestMapping(value = "/api/author", method = RequestMethod.POST)
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author author){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.add(author));
    }


    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        return book;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books(){
        return bookService.getBooks();
    }

    /*
        /api/category/{id}
        CategoryNotFoundException
        + jedna metoda ExceptionHandlerAdvice
        + orElseThrow
     */

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> book(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findById(id));
    }

}
