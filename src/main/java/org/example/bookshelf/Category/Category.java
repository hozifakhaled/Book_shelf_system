package org.example.bookshelf.Category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.bookshelf.Book.Book;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @OneToMany(mappedBy = "category")
    private List<Book> books;

}
