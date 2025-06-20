package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAll();
    Product getById(int id);
    void delete(int id);
}
