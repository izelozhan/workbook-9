package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.List;

public interface IProductDAO {
    List<Product> getProducts();

    void addProduct(Product product);
}
