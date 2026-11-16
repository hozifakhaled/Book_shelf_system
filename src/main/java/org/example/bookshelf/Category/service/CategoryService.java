package org.example.bookshelf.Category.service;


import org.example.bookshelf.Category.Category;
import org.example.bookshelf.Category.repo.CategoryRepo;
import org.example.bookshelf.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }
    public Category getByIdCategory(Long id){
        return categoryRepo.findById(id).orElseThrow(
                () -> new NotFoundException("Category not found with id:"+id)
        );
    }

}
