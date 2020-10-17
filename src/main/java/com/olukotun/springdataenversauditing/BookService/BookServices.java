package com.olukotun.springdataenversauditing.BookService;

import com.olukotun.springdataenversauditing.BookDA0.BookDAO;
import com.olukotun.springdataenversauditing.BookDTO.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServices {
    private BookDAO bookDAO;

    public Book saveBook(Book book) {
        return bookDAO.saveBook(book);
    }

    public String updateBook(int id, int pages) {
        return bookDAO.updateBook(id, pages);
    }


    public String deleteBook(int id) {
        return bookDAO.deleteBook(id);

    }


    public Set<Book> getAuditedBook(Integer id) {
        return bookDAO.getAuditedBook(id);
    }


}
