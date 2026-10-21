package org.example.bookshelf.Book.service;

import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.repo.BookRepo;
import org.example.bookshelf.Category.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;


    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    public Book getBookByTitle(String title){
        return bookRepo.findByTitle(title);
    }
    public Book createBook(Book book){
        return bookRepo.save(book);
    }
    public Book updateBook(Book book){
        if (bookRepo.findById(book.getId()).isPresent()){return bookRepo.save(book);}
        return book;
    }

}
