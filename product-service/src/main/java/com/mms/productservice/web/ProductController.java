package com.mms.productservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.productservice.entity.Product;
import com.mms.productservice.service.ProductService;

@RestController
@RequestMapping("productservice/api")
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	
	/**
	 * This method is used to add product into database
	 * @param product
	 * @param result
	 * @return Response Entity with new added Product
	 */
	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product,BindingResult result){
		
		Product addUpProduct = productService.addProduct(product);
		return new ResponseEntity<Product>(addUpProduct, HttpStatus.CREATED);
		
	}
	
	
	/**
	 * This method is used to update product into database if exist
	 * @param product
	 * @param result
	 * @return Response Entity with updated Product
	 */
	@PatchMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product,BindingResult result){
		
		Product updateProduct = productService.updateProduct(product);
		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
		
	}
	
	
	/**
	 * This method is used to view product details from database
	 * @param productName
	 * @return Response Entity with Product
	 */
	@GetMapping("/viewproduct/{productName}")
	public ResponseEntity<?> viewProductByName(@PathVariable String productName){
		Product viewProductByName = productService.viewProduct(productName);
		return new ResponseEntity<Product>(viewProductByName,HttpStatus.OK);
		
	}
	
	
	
	/**
	 * This method is used to view all products details from database
	 * @return Response Entity with list of Product
	 */
	@GetMapping("/viewallproducts")
	public ResponseEntity<?> viewAllProduct(){
		List<Product> viewAllProduct = productService.viewAllProduct();
		return new ResponseEntity<List<Product>>(viewAllProduct,HttpStatus.OK);
	}
	
	
	
	/**
	 * This method is used to delete product from database when required
	 * @param productIdentifier
	 * @return Response Entity with message Product deleted successfully
	 */ 
	@DeleteMapping("delete/{productIdentifier}")
	public ResponseEntity<?> deleteProduct(@PathVariable String productIdentifier){
		
        productService.deleteProductByProductIdentifier(productIdentifier);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}
	


}
