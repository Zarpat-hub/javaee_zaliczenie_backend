package com.example.javaee_project.services;

import com.example.javaee_project.models.DTO.ProductDTO;
import com.example.javaee_project.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product saveProduct(ProductDTO productDTO);
    List<Product> getAllProducts();
    Product getProductById(Integer productId);
    ProductDTO updateProduct(ProductDTO productDTO, int id);
    Boolean deleteProduct(Integer productId);

    List<Product> findByLikeName(String name);
}
