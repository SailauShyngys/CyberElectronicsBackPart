package com.example.cyberelectronicsback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FileName;
    private String FilePath;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}