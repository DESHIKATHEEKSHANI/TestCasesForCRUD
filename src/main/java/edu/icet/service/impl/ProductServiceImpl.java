package edu.icet.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Product;
import edu.icet.entity.ProductEntity;
import edu.icet.repository.ProductRepository;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Product addProduct(Product product) {
        return mapper.convertValue(repository.save(
                mapper.convertValue(product, ProductEntity.class)
        ), Product.class);
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> entities = repository.findAll();
        List<Product> productList = new ArrayList<>();
        entities.forEach(productEntity ->
                productList.add(mapper.convertValue(productEntity, Product.class))
        );
        return productList;
    }

    @Override
    public Product updateProduct(Product product) {
        return mapper.convertValue(repository.save(
                mapper.convertValue(product, ProductEntity.class)
        ), Product.class);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Product searchProduct(Long id) {
        return repository.findById(id)
                .map(entity -> mapper.convertValue(entity, Product.class))
                .orElse(null);
    }
}
