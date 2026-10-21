package org.example.bookshelf.Category.Controller;

import org.example.bookshelf.Book.Book;
import org.example.bookshelf.Book.service.BookService;
import org.example.bookshelf.Category.Category;
import org.example.bookshelf.Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories()
    {
    return categoryService.getAllCategories();
    }
    @PostMapping("/addcategory")
    public Category addBook(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
}
