package edu.icet.service;

import edu.icet.dto.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    Boolean deleteProduct(Long id);
    Product searchProduct(Long id);
}
