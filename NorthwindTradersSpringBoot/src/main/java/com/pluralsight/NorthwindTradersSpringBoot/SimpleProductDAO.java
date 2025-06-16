package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO {

    private List<Product> productList = new ArrayList<>();

    public SimpleProductDAO() {
        productList.add(new Product(1, "product1", "category", 12.90));
        productList.add(new Product(2, "product2", "category", 14.90));
        productList.add(new Product(3, "product3", "category", 19.90));
    }


    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public void addProduct(Product product) {

    }
}
