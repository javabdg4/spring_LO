package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
