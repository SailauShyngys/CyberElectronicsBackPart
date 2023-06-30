package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.RaitingCreateDto;
import com.example.cyberelectronicsback.model.Raiting;
import com.example.cyberelectronicsback.repository.RaitingRepository;
import com.example.cyberelectronicsback.service.RaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RaitingController {
    private final RaitingRepository raitingRepository;
    private final RaitingService raitingService;

    @GetMapping("/api/raiting/getavgrate/{productId}")
    public Double calculateAverageRaiting(@PathVariable Long productId) throws Exception {
        return raitingService.calculateAverageRaiting(productId);
    }

    @PostMapping("/api/raiting/addrate")
    public ResponseEntity<?> addRating(@RequestBody RaitingCreateDto raitingDto) throws Exception {
        Double value = raitingService.addRaiting(raitingDto).getRaitingValue();
        return ResponseEntity.ok().body("Raiting is add - " + value);
    }

    @DeleteMapping("api/raiting/delrate/{id}")
    public ResponseEntity<?> delete(Long id) {
        raitingService.delete(id);
        return ResponseEntity.ok().body("Raiting del");
    }

    @GetMapping("api/raiting/getraiting/{productId}")
    public List<Raiting> getRaitingsForEntity(@PathVariable Long productId) throws Exception {
        return raitingService.getRaitingsForEntity(productId);
    }
}
