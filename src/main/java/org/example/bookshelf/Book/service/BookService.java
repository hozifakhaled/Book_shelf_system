package org.example.bookshelf.Book.service;

import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;


    public Page<Book> getAllBooks(int page, int size, String sortField, String sortDir) {
        Sort sort =  Sort.by(Sort.Direction.valueOf(sortDir), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);

        return bookRepo.findAll(pageable);
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