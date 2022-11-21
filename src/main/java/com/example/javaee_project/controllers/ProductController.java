package com.example.javaee_project.controllers;

import com.example.javaee_project.models.DTO.ProductDTO;
import com.example.javaee_project.models.Product;
import com.example.javaee_project.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class ProductController {
    private final IProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/like/{name}")
    public ResponseEntity<List<Product>> getProductsWhereNameLike(@PathVariable("name")String name){
        return ResponseEntity.ok((productService.findByLikeName(name)));
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    public ResponseEntity<Product> addProduct(@ModelAttribute ProductDTO productDTO)
    {
        return ResponseEntity.ok(productService.saveProduct(productDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> updateProduct(@ModelAttribute ProductDTO productDTO, @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.updateProduct(productDTO, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
