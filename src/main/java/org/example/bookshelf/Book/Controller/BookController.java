package org.example.bookshelf.Book.Controller;

import jakarta.validation.Valid;
import org.example.bookshelf.Book.Entity.Book;
import org.example.bookshelf.Book.DTO.CreateBookRequest;
import org.example.bookshelf.Book.projection.BookSummary;
import org.example.bookshelf.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/allbook")
    public List<Book> getAllBook(
    )
    {
        return bookService.getAllBook();
    }
    @PostMapping("/addbook")
    public Book addBook(@Valid @RequestBody CreateBookRequest book){
        return bookService.createBook(book);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.getBookById(id) ;
    }
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year) {

        return bookService.searchBooks(title, year);
    }
    @PutMapping("/updateBook")
    public Book updateBook( @RequestBody Book book){
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