package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.entity.ProductEntity;
import edu.icet.repository.ProductRepository;
import edu.icet.service.ProductService;
import edu.icet.dto.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository; // Mocked Repository

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private ProductEntity productEntity;

    @Before
    public void setUp() {
        product = new Product(1L, "Laptop", 1000.00);
        productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("Laptop");
        productEntity.setPrice(1000.00);

        // Mock ObjectMapper behavior
        when(mapper.convertValue(any(), eq(ProductEntity.class))).thenReturn(productEntity);
        when(mapper.convertValue(any(), eq(Product.class))).thenReturn(product);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);

        // Act
        Product createdProduct = productService.addProduct(product);

        // Assert
        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getName());
        verify(productRepository, times(1)).save(any(ProductEntity.class));
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(List.of(productEntity));

        // Act
        List<Product> products = productService.getAllProducts();

        // Assert
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);

        // Act
        Product updatedProduct = productService.updateProduct(product);

        // Assert
        assertNotNull(updatedProduct);
        assertEquals("Laptop", updatedProduct.getName());
        verify(productRepository, times(1)).save(any(ProductEntity.class));
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        // Act
        boolean isDeleted = productService.deleteProduct(1L);

        // Assert
        assertTrue(isDeleted);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testSearchProduct() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(productEntity));

        // Act
        Product foundProduct = productService.searchProduct(1L);

        // Assert
        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
        verify(productRepository, times(1)).findById(1L);
    }
}