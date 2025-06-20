package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.IProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    IProductDao productDao;

    public ProductsController (IProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.getById(id);
    }

}
