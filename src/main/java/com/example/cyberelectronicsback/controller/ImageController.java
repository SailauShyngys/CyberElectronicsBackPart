package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.ImageCreateDto;
import com.example.cyberelectronicsback.model.Image;
import com.example.cyberelectronicsback.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/api/images/{id}")
    public Image getById(@PathVariable Long id) throws Exception {
        return imageService.getById(id);
    }

    @PostMapping("/api/images")
    public Long createImage(@RequestBody ImageCreateDto createDto) {
        return imageService.createImage(createDto.getFilename(), createDto.getFilepath());
    }

    @PutMapping("/api/images/{id}")
    public Image updateImage(@PathVariable Long id, @RequestBody ImageCreateDto createDto) throws Exception {
        return imageService.updateImage(id, createDto.getFilename(), createDto.getFilepath());
    }

    @DeleteMapping("/api/images/{id}")
    public void deleteImage(@PathVariable Long id) throws Exception {
        imageService.deleteImage(id);
    }
}
