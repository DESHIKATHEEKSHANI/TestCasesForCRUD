package edu.icet.service.impl;


import edu.icet.Service.ProductService;
import edu.icet.dto.Product;
import edu.icet.repository.ProductRepository;
import jdk.jfr.internal.jfc.model.Constraint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @Before
    public void setUp() {
        product = new Product(1, "Laptop", 1000.00);
    }

    @Test
    public void testCreateProduct() {
        // Arrange: Define the behavior of the mocked repository
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act: Call the method to test
        Product createdProduct = productService.createProduct(product);

        // Assert: Verify that the created product is correct
        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getName());

        // Verify that the save method was called once
        verify(productRepository, times(1)).save(any(Product.class));
    }


}
