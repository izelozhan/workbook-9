package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements IProductDao {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                products.add(new Product(
                        result.getInt("productId"),
                        result.getString("productName"),
                        result.getInt("categoryId"),
                        result.getDouble("unitPrice")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT * FROM products WHERE productId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Product(
                        result.getInt("productId"),
                        result.getString("productName"),
                        result.getInt("categoryId"),
                        result.getDouble("unitPrice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
