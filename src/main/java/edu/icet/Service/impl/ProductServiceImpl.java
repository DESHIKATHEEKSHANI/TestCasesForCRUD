package edu.icet.Service.impl;

import edu.icet.Service.ProductService;
import edu.icet.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public void saveProduct(Product product) {
        evauluateProductRating(product.getNoOfLikes());
    }

    @Override
    public int evauluateProductRating(int noOfLikes){
        if(noOfLikes > 90){
            return 5;
        }
        if(noOfLikes > 70){
            return 4;
        }
        if(noOfLikes > 50){
            return 3;
        }
        if(noOfLikes > 20){
            return 2;
        }
        if(noOfLikes > 10){
            return 1;
        }
        return 0;
    }
}
