package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductDao {
    List<Product> db = new ArrayList<>();

    public ProductDao() {
        this.db.add(new Product(1, "product1", "category", 12.90));
        this.db.add(new Product(2, "product2", "category", 12.90));
    }

    public List<Product> getProducts() {
        return this.db;
    }

    public void addProduct(Product product) {
        this.db.add(product);
    }

    public abstract void add(Product product);

    public abstract List<Product> getAll();
}
