package com.example.cyberelectronicsback.service.impl;

import com.example.cyberelectronicsback.controller.dto.RaitingCreateDto;
import com.example.cyberelectronicsback.model.Raiting;
import com.example.cyberelectronicsback.repository.RaitingRepository;
import com.example.cyberelectronicsback.service.ProductService;
import com.example.cyberelectronicsback.service.RaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaitingServiceImpl implements RaitingService {
    private final RaitingRepository raitingRepository;
    private final ProductService productService;

    @Override
    public Raiting addRaiting(RaitingCreateDto raitingDto) throws Exception {
        Raiting raiting = new Raiting();
        raiting.setRaitingValue(raitingDto.getRaitingValue());
        raiting.setProduct(productService.getById(raitingDto.getProductId()));
        return raitingRepository.save(raiting);
    }

    @Override
    public List<Raiting> getRaitingsForEntity(Long productId) throws Exception {
        return raitingRepository.findAllByProduct_Id(productId);
    }

    @Override
    public Double calculateAverageRaiting(Long productId) throws Exception {
        List<Raiting> raitings = getRaitingsForEntity(productId);
        if (raitings.isEmpty()) {
            return 0.0;
        }
        double sum = raitings.stream().mapToDouble(Raiting::getRaitingValue).sum();
        return sum / raitings.size();
    }

    @Override
    public void delete(Long id) {
        raitingRepository.deleteById(id);
    }
}

