package com.olukotun.springdataenversauditing.BookController;

import com.olukotun.springdataenversauditing.BookDTO.Book;
import com.olukotun.springdataenversauditing.BookService.BookServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
public class Controller {
    private BookServices bookServices;

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return bookServices.saveBook(book);
    }

    @PutMapping("/update/{id}/{pages}")
    public String updateBook(@PathVariable int id, @PathVariable int pages) {

        return bookServices.updateBook(id, pages);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookServices.deleteBook(id);

    }

    @GetMapping("/revision/{id}")
    public Set<Book> getAuditedBook(@PathVariable Integer id) {

        return bookServices.getAuditedBook(id);
    }
}
