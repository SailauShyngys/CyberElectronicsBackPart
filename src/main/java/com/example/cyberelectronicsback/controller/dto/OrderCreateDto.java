package com.example.cyberelectronicsback.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDto {
    private List<Long> ProductId;
}
