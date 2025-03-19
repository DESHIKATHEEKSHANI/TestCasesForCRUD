package edu.icet.Service;

import edu.icet.dto.Product;

public interface ProductService {
    void saveProduct(Product product);
    int evauluateProductRating(int noOfLikes);
}
