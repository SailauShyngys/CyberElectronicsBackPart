package com.example.cyberelectronicsback.repository;

import com.example.cyberelectronicsback.model.Raiting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaitingRepository extends JpaRepository<Raiting, Long> {
    List<Raiting> findAllByProduct_Id(Long productId);
}
