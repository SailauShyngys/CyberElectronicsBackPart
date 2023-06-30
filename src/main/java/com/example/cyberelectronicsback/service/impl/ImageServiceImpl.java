package com.example.cyberelectronicsback.service.impl;

import com.example.cyberelectronicsback.model.Image;
import com.example.cyberelectronicsback.repository.ImageRepository;
import com.example.cyberelectronicsback.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createImage(String filename, String filepath) {
        Image image = new Image();
        image.setFileName(filename);
        image.setFilePath(filepath);
        return imageRepository.save(image).getId();
    }

    @Override
    public Image updateImage(Long id, String filename, String filepath) {
        Image image = imageRepository.findById(id).orElseThrow();
        image.setFileName(filename);
        image.setFilePath(filepath);
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

}
