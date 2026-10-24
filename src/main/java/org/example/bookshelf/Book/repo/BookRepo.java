package org.example.bookshelf.Book.repo;


import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.projection.BookSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
     Book  findByTitle(String title);
     List<Book> findByPublishedYearGreaterThan(int publishedYear);
     @Query("SELECT b FROM Book b WHERE b.publishedYear = :year")
     List<Book> findByPublishedYear(@Param("year") int year);
     // Page<Book> findAll(Pageable pageable);


     List<BookSummary> findByTitleAndPublishedYear (String title, int publishedYear);
}


