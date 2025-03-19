package edu.icet.controller;

import edu.icet.dto.Product;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Endpoint to save a product
    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.addProduct(product);  // Calls the service to add the product
    }

    // Endpoint to get all products
    @GetMapping("/get-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();  // Calls the service to get all products
    }

    // Endpoint to update a product
    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);  // Calls the service to update the product
    }

    // Endpoint to delete a product
    @DeleteMapping("/delete-product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);  // Calls the service to delete the product by ID
    }

    // Endpoint to search for a product by ID
    @GetMapping("/search-product/{id}")
    public Product searchProduct(@PathVariable Long id) {
        return productService.searchProduct(id);  // Calls the service to search for the product by ID
    }
}
