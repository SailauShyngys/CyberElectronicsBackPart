package com.example.cyberelectronicsback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;


@Entity(name = "Products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    private List<Order> ProductOrders;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @CreationTimestamp
    private ZonedDateTime createdDate;
    @UpdateTimestamp
    private ZonedDateTime updatedDate;
}