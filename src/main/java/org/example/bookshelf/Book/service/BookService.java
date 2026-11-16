package org.example.bookshelf.Book.service;

import org.example.bookshelf.Book.Entity.Book;
import org.example.bookshelf.Book.DTO.CreateBookRequest;
import org.example.bookshelf.Book.Specification.BookSpecification;
import org.example.bookshelf.Book.projection.BookSummary;
import org.example.bookshelf.Book.repo.BookRepo;
import org.example.bookshelf.Category.Category;
import org.example.bookshelf.Category.service.CategoryService;
import org.example.bookshelf.Exception.BadRequestException;
import org.example.bookshelf.Exception.DuplicateRecordException;
import org.example.bookshelf.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final BookRepo bookRepo;

    private final CategoryService categoryService;

    public BookService(CategoryService categoryService , BookRepo bookRepo) {
        this.categoryService = categoryService;
        this.bookRepo = bookRepo;
    }

    public Page<Book> getAllBooks(int page, int size, String sortField, String sortDir) {

        Sort sort =  Sort.by(Sort.Direction.valueOf(sortDir), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);

        return bookRepo.findAll(pageable);
    }
    public List<Book> getAllBook() {

       return bookRepo.findAll();
    }

    public Book getBookById(Long id)   {
            return bookRepo.findById(id).orElseThrow(()-> new NotFoundException("Book not found with id:"+id));
    }

    public Book createBook(CreateBookRequest book) {
        if (bookRepo.findByTitle(book.getTitle()) != null) {
            throw new DuplicateRecordException("Book already exists");
        }
// Continue creating the book
        Book bookEntity = new Book();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setPublishedYear(book.getPublishedYear());
        Category category = categoryService.getByIdCategory(book.getCategoryId());
        bookEntity.setCategory(category);
       return bookRepo.save(bookEntity);}

    public Book updateBook(Book book) {
        Book existingBook=  bookRepo.findById(book.getId()).orElseThrow(
                ()-> new NotFoundException("Book not found with id:"+book.getId())
        );
        if (existingBook.getPublishedYear() != book.getPublishedYear()) {
            throw new BadRequestException(
                    "Published year cannot be changed after book creation"
            );        }else {
    return bookRepo.save(book);}
    }
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }
    public List<Book> findBooksPublishedAfter(int year) {
        return bookRepo.findByPublishedYearGreaterThan(year);
    }
    public List<Book> findBooksPublished(int year) {
        return bookRepo.findByPublishedYear(year);
    }
    public  List<BookSummary> findBooksByTitleAndPublished(String title, int publishedYear) {
        return bookRepo.findByTitleAndPublishedYear(title,publishedYear);
    }
    public List<Book> searchBooks(String title, Integer year) {

        Specification<Book> spec = null;
        if (title != null&& !title.isBlank()) {
            spec = BookSpecification.hasTitleContaining(title);
        }

        if (year != null && year!=0) {
          if (spec == null) {
                spec = BookSpecification.hasPublishedYear(year);
            }else {
              spec = spec.or(BookSpecification.hasPublishedYear(year));
          }
        }

        return bookRepo.findAll(spec);
    }

}