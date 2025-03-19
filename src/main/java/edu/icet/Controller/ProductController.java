package edu.icet.Controller;

import edu.icet.Service.ProductService;
import edu.icet.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody  Product product){
        productService.saveProduct(product);
        return product;
    }

}
