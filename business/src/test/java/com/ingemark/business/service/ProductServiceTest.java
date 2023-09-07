package com.ingemark.business.service;

import com.ingemark.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void saveAndFetchAll() {

        ProductDto productDto = new ProductDto();
        productDto.setPriceEur(BigDecimal.TEN);
        productDto.setAvailable(true);
        productDto.setDescription("desc");
        productDto.setName("name");
        productDto.setCode("1234567890");

        long id = productService.create(productDto);

        List<ProductDto> productDtoList = productService.fetchAll();

        assertNotNull(productDtoList);
        assertEquals(1, productDtoList.size());
    }
}
