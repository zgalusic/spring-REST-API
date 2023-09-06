package com.ingemark.business.service;

import com.ingemark.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto fetch(long id);
    List<ProductDto> fetchAll();
    List<ProductDto> filterBy(ProductDto productDto);
    long create(ProductDto productDto);
    void update(ProductDto productDto);
    void delete(long id);
}
