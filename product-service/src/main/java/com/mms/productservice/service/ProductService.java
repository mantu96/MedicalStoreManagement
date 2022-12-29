package com.mms.productservice.service;

import java.util.List;

import com.mms.productservice.entity.Product;

/**
 * This is the Service layer which consists of all the business logic
 */
public interface ProductService {
    
    /**
     * This method is used to add the new Product to the System
     * @param product to be added
     * @return
     */
    public Product addProduct(Product product);

    /**
     * This method is used to update the Product to the System
     * @param product to be updated
     * @return
     */
    public Product updateProduct(Product product);

    /**
     * This method is used to view the Product
     * @param productName of the product
     * @return
     */
    public Product viewProduct(String productName);

    /**
     * This method is used to view all Product present in the System
     * @return
     */
    public List<Product> viewAllProduct();

    /**
     * This method is used to delete the Product by Product Identiier
     * @param productIdentifier of the product
     */
    public void deleteProductByProductIdentifier(String productIdentifier);
    
}
