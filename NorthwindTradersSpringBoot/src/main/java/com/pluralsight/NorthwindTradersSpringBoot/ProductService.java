package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductService {
    private final IProductDAO productDao;

    @Autowired
    public ProductService(IProductDAO productDao){
        this.productDao = productDao;
    }

   public void addProduct(Product product){
        this.productDao.addProduct(product);
   }

}
