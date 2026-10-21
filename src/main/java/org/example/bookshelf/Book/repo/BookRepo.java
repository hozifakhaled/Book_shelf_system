package org.example.bookshelf.Book.repo;


import org.example.bookshelf.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    public Book  findByTitle(String title);
}
