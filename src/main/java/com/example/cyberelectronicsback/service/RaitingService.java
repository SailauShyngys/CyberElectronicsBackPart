package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.controller.dto.RaitingCreateDto;
import com.example.cyberelectronicsback.model.Raiting;

import java.util.List;

public interface RaitingService {
    Raiting addRaiting(RaitingCreateDto raitingDto) throws Exception;

    List<Raiting> getRaitingsForEntity(Long productId) throws Exception;

    Double calculateAverageRaiting(Long productId) throws Exception;

    void delete(Long id);
}
