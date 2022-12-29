package com.mms.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
    /**
     * This method is used to find the product by product name
     * @param productName of the product
     * @return
     */
    public Product findProductByProductName(String productName);

    /**
     * This method is used to find the product by product Identiifier
     * @param productIdentifier of the product
     * @return
     */
    public Product findProductByProductIdentifier(String productIdentifier);
}
