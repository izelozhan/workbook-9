package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();
    Category getById(int id);
}
