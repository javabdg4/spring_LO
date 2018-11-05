package com.sda.spring.demo.model;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> bookSet;

    public Author(){}

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
