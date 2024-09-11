package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Product;

public interface ProductServiceInterface {
    public Product createProduct(Product product);
    public Product updatePrduct(Product product);
    public void deleteProduct(String productId);
    public Product getProduct(String productId);
    public List<Product> getAllProduct(); 

}
