package com.olukotun.springdataenversauditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.history.Revisions;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;


@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
// This enable revision auditing in our database

public class SpringDataEnversAuditingApplication {


    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataEnversAuditingApplication.class, args);
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/update/{id}/{pages}")
    public String updateBook(@PathVariable int id, @PathVariable int pages) {
        Book book = repository.findById(id).get();

        book.setPages(pages);

        repository.save(book);


        return "Book updated";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Book deleted";
    }

    @GetMapping("/revision/{id}")
    public Set<Book> getAuditedBook(@PathVariable Integer id) {


        Revisions<Integer, Book> revisions = repository.findRevisions(id);


        // do something like github
        // model or dto or anything

        Set<Book> books = revisions.getContent()
                .stream()
                .filter(revision -> revision.getEntity().getId() == id)
                .map(revision -> revision.getEntity())
                .collect(Collectors.toSet());


        return books;


    }

}
