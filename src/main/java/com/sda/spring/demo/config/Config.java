package com.sda.spring.demo.config;

import com.sda.spring.demo.component.CustomRunner;
import com.sda.spring.demo.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Person personBean(){
        return new Person();
    }

    @Bean
    public CustomRunner customRunner(){
        return new CustomRunner();
    }

}
