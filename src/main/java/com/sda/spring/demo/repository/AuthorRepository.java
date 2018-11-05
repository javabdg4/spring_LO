package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends
        JpaRepository<Author,Long> {
}
