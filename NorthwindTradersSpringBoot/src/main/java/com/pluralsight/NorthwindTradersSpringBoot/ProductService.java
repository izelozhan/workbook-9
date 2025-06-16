package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductService {
    private final SimpleProductDAO productDao;

    @Autowired
    public ProductService(SimpleProductDAO productDao){
        this.productDao = productDao;
    }

   public void addProduct(Product product){
        Product newProduct = new Product(product);
        this.productDao.addProduct(newProduct);
   }

}
