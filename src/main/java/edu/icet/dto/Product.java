package edu.icet.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private double price;

    public Product(int i, String laptop, double v) {
    }
}
