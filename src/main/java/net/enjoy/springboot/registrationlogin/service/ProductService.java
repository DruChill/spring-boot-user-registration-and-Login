package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> findAllProducts();
    Product findProductById(Long id);
}