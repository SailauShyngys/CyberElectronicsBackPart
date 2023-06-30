package com.example.cyberelectronicsback.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateDto {
    private String name;
    private Integer price;
    private String description;
    private Integer quantity;
    private Long categoryId;
}