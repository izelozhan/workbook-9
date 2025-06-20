package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements ICategoryDao {
    private final DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Category> getAll() {

        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                categories.add(new Category(
                        result.getInt("categoryId"),
                        result.getString("categoryName")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category getById(int id) {
        String sql = "SELECT * FROM categories WHERE categoryId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Category(
                        result.getInt("categoryId"),
                        result.getString("categoryName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

