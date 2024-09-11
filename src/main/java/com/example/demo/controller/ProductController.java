package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.impel.ProductServiceImpel;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController

public class ProductController {

    private ProductServiceImpel productservice;
    public ProductController(ProductServiceImpel productservice){
        this.productservice = productservice;
    }


    @GetMapping("/getAllProducts")
    public ResponseEntity<Object>  productList() {

        List<Product> list =  productservice.getAllProduct();
        if(list.isEmpty()){
        throw new ProductNotFoundException("There is no product found");
        }
        return  ResponseHandler.responseBuilder("Fetched Product", HttpStatus.OK, list);
        
    }
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Object> getPoProductById(@PathVariable("productId") String productId) {
        Product product = productservice.getProduct(productId);
        if(product== null){
             throw new ProductNotFoundException("Product is not found");
        };

         return ResponseHandler.responseBuilder("Fetched Product", HttpStatus.OK, product);


        

        
    }

    

    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
       
        Product addedProduct =productservice.createProduct(product);
        if(addedProduct != null){
           ResponseHandler.responseBuilder("Fetched Product", HttpStatus.OK, addedProduct);
        }
         throw new ProductNotFoundException( "Unable to add the new product");
       
        
        
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") String productId, @RequestBody Product updatedProduct) {
        Product existingProduct = productservice.getProduct(productId);
        if(existingProduct != null){
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice()); 
        }else{
            throw new ProductNotFoundException("product is not found to update!");
        }
        productservice.updatePrduct(existingProduct);

        
        return "Scuccessfully updated product details";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") String productId){
        productservice.deleteProduct(productId);
        return "Product deleted successfully";

    }



    
    

    
    

}
