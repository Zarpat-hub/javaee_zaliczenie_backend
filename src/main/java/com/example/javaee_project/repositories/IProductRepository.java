package com.example.javaee_project.repositories;

import com.example.javaee_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainsIgnoreCase(String name);
}
