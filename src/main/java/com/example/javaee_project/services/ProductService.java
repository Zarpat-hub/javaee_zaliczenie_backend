package com.example.javaee_project.services;

import com.example.javaee_project.models.DTO.ProductDTO;
import com.example.javaee_project.models.Product;
import com.example.javaee_project.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        try {
            product.setImage(productDTO.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Invalid file format or something.");
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, int id) {
        Product productToUpdate = getProductById(id);
        if(productDTO.getName() != null) {
            productToUpdate.setName(productDTO.getName());
        }
        if(productDTO.getPrice() != null) {
            productToUpdate.setPrice(productDTO.getPrice());
        }
        if(productDTO.getImage() != null) {
            try {
                productToUpdate.setImage(productDTO.getImage().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        productRepository.save(productToUpdate);
        return productDTO;
    }

    @Override
    public Boolean deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return Boolean.TRUE;
    }

    @Override
    public List<Product> findByLikeName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }
}
