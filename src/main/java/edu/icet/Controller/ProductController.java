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

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/get-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/search-product/{id}")
    public Product searchProduct(@PathVariable Long id) {
        return productService.searchProduct(id);
    }
}
