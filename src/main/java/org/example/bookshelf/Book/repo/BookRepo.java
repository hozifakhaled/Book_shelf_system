package org.example.bookshelf.Book.repo;


import org.example.bookshelf.Book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
     Book  findByTitle(String title);
    // Page<Book> findAll(Pageable pageable);
}
