package com.mms.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.productservice.entity.Product;
import com.mms.productservice.exception.ProductAlreadyExistsException;
import com.mms.productservice.exception.ProductNotFoundException;
import com.mms.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        //Checking if Product Exists
        Product fetchedProduct = productRepository.findProductByProductIdentifier(product.getProductIdentifier());
        if(fetchedProduct != null){

            //Throw ProductAlreadyexistsException
            throw new ProductAlreadyExistsException("Product with Identifier "+product.getProductIdentifier() + " Already exists");

        }

        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Product product) {
      
        Product oldProduct  = productRepository.findProductByProductIdentifier(product.getProductIdentifier());
		product.setProductId(oldProduct.getProductId());
		oldProduct = product;
		
		return productRepository.save(oldProduct);

    }

    @Override
    public Product viewProduct(String productName) {

        if(productRepository.findProductByProductName(productName) == null){
	
            //Throw ProductNotFoundException
			throw new ProductNotFoundException("Product with  "  +productName+  "  does not exists");
            
        }
		Product product = productRepository.findProductByProductName(productName);
		return product;
    }

    @Override
    public List<Product> viewAllProduct() {

        List<Product> products = productRepository.findAll();
		
		return products;
	}

    @Override
    public void deleteProductByProductIdentifier(String productIdentifier) {
       
        Product product = productRepository.findProductByProductIdentifier(productIdentifier);
		if(product == null){
            
			//Throw ProductNotFoundException
			throw new ProductNotFoundException("Product with   "+productIdentifier+"   does not exists");
		}
		
		productRepository.delete(product);
		
    }
    
}
