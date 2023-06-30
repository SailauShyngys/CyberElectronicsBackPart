package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.controller.dto.ProductCreateDto;
import com.example.cyberelectronicsback.model.Category;
import com.example.cyberelectronicsback.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
@DisplayName("Асаламалейкум Уа Рахматулахи Уа Баракатух")
public class CyberElectronicsBackServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private ProductRepository productRepository;

    @Test
//    @DisplayName("корректно возвращать товар")
    void createSportPitTest() throws Exception {
        Category category = new Category();
        category.setId(1L);
        category.setName("Protein");

        ProductCreateDto createDto = new ProductCreateDto();
        createDto.setName("WheyProtein");
        createDto.setPrice(3);
        createDto.setQuantity(700);
        createDto.setCategoryId(category.getId());
//
//        SportPit sportPit = new SportPit();
//        sportPit.setCategory(category);
//        sportPit.setQuantity(700);
//        sportPit.setManufacture("OptimumOn");
//        sportPit.setName("WheyProtein");
//        sportPit.setId(1L);
//
//        Mockito.when(categoryService.getById().thenReturn(category);
//        Mockito.when(sportPitRepository.save(Mockito.any(SportPit.class))).thenReturn(sportPit);
//
        var res = productService.createProduct(createDto);
//
        Assertions.assertEquals(res.getName(), "WheyProtein");
//        Assertions.assertEquals(res.getDescription(), "OptimumOn");
//        Assertions.assertEquals(res.getPrice(), 45000);
//        Assertions.assertEquals(res.getCategory().getName(), "Protein");
        Assertions.assertEquals(res.getQuantity(), 700);
    }
}