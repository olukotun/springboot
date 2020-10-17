package com.olukotun.springdataenversauditing.BookDA0;

import com.olukotun.springdataenversauditing.BookDTO.Book;
import com.olukotun.springdataenversauditing.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class BookDAO {


    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public String updateBook(int id, int pages) {
        Book book = bookRepository.findById(id).get();

        book.setPages(pages);

        bookRepository.save(book);


        return "Book updated";

    }


    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }

    public Set<Book> getAuditedBook(Integer id) {

        Revisions<Integer, Book> revisions = bookRepository.findRevisions(id);
        Set<Book> books = revisions.getContent()
                .stream()
                .filter(revision -> revision.getEntity().getId() == id)
                .map(revision -> revision.getEntity())
                .collect(Collectors.toSet());


        return books;


    }
}
