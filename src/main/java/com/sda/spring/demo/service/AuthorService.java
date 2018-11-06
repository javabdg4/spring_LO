package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository authorRepository;

    public Author add(Author author){
        return authorRepository.save(author);
    }

}
