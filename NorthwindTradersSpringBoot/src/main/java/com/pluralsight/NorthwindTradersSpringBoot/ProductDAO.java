package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.ArrayList;
import java.util.List;

public  class ProductDAO implements IProductDAO {
    List<Product> db = new ArrayList<>();

    public ProductDAO() {
        this.db.add(new Product(1, "product1", "category", 12.90));
        this.db.add(new Product(2, "product2", "category", 12.90));
    }

    @Override
    public List<Product> getProducts() {
        return this.db;
    }

    @Override
    public void addProduct(Product product) {
        this.db.add(product);
    }


}
