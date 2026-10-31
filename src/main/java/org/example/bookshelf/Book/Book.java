package org.example.bookshelf.Book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.bookshelf.Category.Category;
import org.example.bookshelf.Common.BaseEntity;
import org.hibernate.annotations.Formula;

@Getter
@Setter

@Entity
@Table(name = "book")

public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id
;
    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;
    private int publishedYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Formula("EXTRACT(YEAR FROM CURRENT_DATE)::INTEGER - published_year")
       private int bookAge ;


    }

