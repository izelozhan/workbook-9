package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ICategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    ICategoryDao categoryDao;

    public CategoriesController(ICategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
       Category category =  categoryDao.getById(id);
       return  category;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryDao.delete(id);
    }

}
