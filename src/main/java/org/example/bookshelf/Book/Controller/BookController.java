package org.example.bookshelf.Book.Controller;

import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks()
    {
    return bookService.getAllBooks();
    }
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping("/{title}")
    public Book getBooksByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title) ;
    }
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
}
