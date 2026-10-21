package org.example.bookshelf.Category.repo;

import org.example.bookshelf.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
