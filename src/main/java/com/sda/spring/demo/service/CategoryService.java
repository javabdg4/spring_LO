package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.CategoryNotFoundException;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    public Category updateCategory(Long id, Category category){

        Category updatedCategory = categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(id)
        );
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(id)
        );
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
