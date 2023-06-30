package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.model.Image;

public interface ImageService {
    Image getById(Long id) throws Exception;

    Long createImage(String filename, String filepath);

    Image updateImage(Long id, String filename, String filepath);

    void deleteImage(Long id) throws Exception;
}