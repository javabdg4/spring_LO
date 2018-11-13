package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.Person;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("TEST");

	}

	@Override
	public void run(String... args) throws Exception {

//		Person person = applicationContext.getBean(Person.class);
//		person.setName("JAN");
//
//		Set<Author> authorSet = new HashSet<>();
//		authorSet.add(new Author("Jan", "Kowalski"));
//		authorSet.add(new Author("Jan", "Nowak"));
//
//		Book book = new Book("Tytul");
//		book.setAuthorSet(authorSet);
//
//		Category category = new Category("Fantastyka");
//
//		book.setCategory(category);
//
//		bookRepository.save(book);

	}
}
