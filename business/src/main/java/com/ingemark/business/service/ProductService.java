package com.ingemark.business.service;

import com.ingemark.dto.ProductDto;
import com.ingemark.dto.ProductField;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    ProductDto fetch(long id);
    List<ProductDto> fetchAll(int page, int size, Sort.Direction sortDirection, ProductField sortField);
    List<ProductDto> filterBy(ProductDto productDto);
    long create(ProductDto productDto);
    void update(ProductDto productDto);
    void delete(long id);
}
