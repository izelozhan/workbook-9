package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements IProductDAO {

    DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getProducts() {
        String sql = "SELECT ProductID, Name, Category, Price FROM Products";
        List<Product> list = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                list.add(new Product(result.getInt("ProductID"),
                        result.getString("Name"),
                        result.getString("Category"),
                        result.getDouble("Price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO Products (ProductID, Name, Category, Price) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
