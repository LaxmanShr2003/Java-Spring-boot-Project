package com.example.demo.service.impel;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductServiceInterface;


@Service
public class ProductServiceImpel implements ProductServiceInterface{

    private ProductRepository productRepository;
  

    public ProductServiceImpel(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    

    @Override
    public Product createProduct(Product product) {
       Product newProduct =this.productRepository.save(product);
        return newProduct;
    }

    @Override
    public Product updatePrduct(Product product) {
         Product updatedProduct = productRepository.save(product);

        return updatedProduct;
       
    }

    @Override
    public void deleteProduct(String productId) {
       productRepository.deleteById(productId);
       
        
        
    }
    @Override
    public Product getProduct(String productId) {

        Product getProduct = productRepository.findById(productId).get();
        
        return getProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = productRepository.findAll();
        return list;   
    }

}
