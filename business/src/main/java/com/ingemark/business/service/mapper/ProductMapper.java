package com.ingemark.business.service.mapper;

import com.ingemark.business.data.entity.Product;
import com.ingemark.dto.ProductDto;

public class ProductMapper {

    public static Product map(ProductDto productDto) {

        Product product = new Product();

        product.setAvailable(productDto.getAvailable());
        product.setCode(productDto.getCode());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPriceEur(productDto.getPriceEur());
        product.setPriceUsd(productDto.getPriceUsd());

        return product;
    }

    public static ProductDto map(Product product) {

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setAvailable(product.isAvailable());
        productDto.setCode(product.getCode());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPriceEur(product.getPriceEur());
        productDto.setPriceUsd(product.getPriceUsd());

        return productDto;
    }
}
