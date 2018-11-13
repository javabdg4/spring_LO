package com.sda.spring.demo.controller;


import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value = "index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "category")
    public ModelAndView category(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", new Category());
        return modelAndView;

    }

    @PostMapping(value = "category")
    public void addCategory(@ModelAttribute("category") Category category){
        categoryRepository.save(category);
        System.out.println(category.toString());

    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user) {
       ModelAndView modelAndView = new ModelAndView();

       userService.saveUser(user);
       modelAndView.addObject("successMessage", "User has been registered successfully");
       modelAndView.addObject("user", new User());
       modelAndView.setViewName("registration");

       return modelAndView;
    }
}
