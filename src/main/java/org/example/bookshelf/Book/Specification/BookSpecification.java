package org.example.bookshelf.Book.Specification;
import org.example.bookshelf.Book.Entity.Book;
import org.springframework.data.jpa.domain.Specification;


public class BookSpecification {

    public static Specification<Book> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("title"), title);
    }
    public static Specification<Book> hasTitleContaining(String title){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("title"), "%" + title + "%");

    }
    public static Specification<Book> hasPublishedYear(int year){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("publishedYear"), year);
    }


}
