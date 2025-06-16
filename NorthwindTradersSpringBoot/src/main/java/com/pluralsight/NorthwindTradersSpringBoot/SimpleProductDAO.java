package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO {

    private final List<Product> productList = new ArrayList<>();

    public SimpleProductDAO() {
        productList.add(new Product(1, "Pen", "Stationery", 1.99));
        productList.add(new Product(2, "Notebook", "Stationery", 3.49));
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }
}
