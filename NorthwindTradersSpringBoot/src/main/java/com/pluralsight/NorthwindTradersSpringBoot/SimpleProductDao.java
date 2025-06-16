package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao extends ProductDao {

    private List<Product> productList = new ArrayList<>();

    public SimpleProductDao() {
        productList.add(new Product(1, "product1", "category", 12.90));
        productList.add(new Product(2, "product2", "category", 14.90));
        productList.add(new Product(3, "product3", "category", 19.90));
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productList);
    }
}
