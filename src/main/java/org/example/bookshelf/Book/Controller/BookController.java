package org.example.bookshelf.Book.Controller;

import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.projection.BookSummary;
import org.example.bookshelf.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;


@RestController()
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/allbooks")
    public Page<Book> getAllBooks(
            @RequestParam int page, @RequestParam int size , @RequestParam String sortField , @RequestParam String sortDir
    )
    {
    return bookService.getAllBooks(page, size, sortField, sortDir);
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
    @GetMapping("/after-year/{year}")
    public List<Book> findBooksPublishedAfter(@PathVariable int year) {
        return bookService.findBooksPublishedAfter(year);
    }
    @GetMapping("/year/{year}")
    public List<Book> findBooksPublished(@PathVariable int year) {
        return bookService.findBooksPublished(year);
    }
    @GetMapping("/title-year")

    public  List<BookSummary> findBooksByTitleAndPublished(@RequestParam String title,@RequestParam int publishedYear) {
        return bookService.findBooksByTitleAndPublished(title,publishedYear);
    }

}//http://localhost:8080/api/book/allbooks?page=7&size=5&sortField=id