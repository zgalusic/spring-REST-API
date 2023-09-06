package com.ingemark.business.service;

import com.ingemark.business.data.entity.Product;
import com.ingemark.business.data.repository.ProductRepository;
import com.ingemark.business.service.mapper.ProductMapper;
import com.ingemark.dto.ProductDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto fetch(long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        ProductDto productDto = null;
        if(productOptional.isPresent()){
            productDto = ProductMapper.map(productOptional.get());
        }

        return productDto;
    }

    @Override
    public List<ProductDto> fetchAll() {

        Iterator<Product> productIterator = productRepository.findAll().iterator();
        List<ProductDto> productDtoList = new ArrayList<>();

        while(productIterator.hasNext()) {
            Product product = productIterator.next();
            ProductDto productDto = ProductMapper.map(product);
            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    @Override
    public List<ProductDto> filterBy(ProductDto productDto) {

        // TODO

        return null;
    }

    @Override
    public long create(ProductDto productDto) {
        Product product = ProductMapper.map(productDto);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    public void update(ProductDto productDto) {

        Optional<Product> productOptional = productRepository.findById(productDto.getId());
        productOptional.ifPresent(p -> {

            if(productDto.getPriceUsd() != null) {
                p.setPriceUsd(productDto.getPriceUsd());
            }

            if(StringUtils.isNotBlank(productDto.getDescription())) {
                p.setDescription(productDto.getDescription());
            }

            if(productDto.getPriceEur() != null) {
                p.setPriceEur(productDto.getPriceEur());
            }

            if(productDto.getAvailable() != null) {
                p.setAvailable(productDto.getAvailable());
            }

            if(StringUtils.isNotBlank(productDto.getName())) {
                p.setName(productDto.getName());
            }

            if(StringUtils.isNotBlank(productDto.getCode())) {
                p.setCode(productDto.getCode());
            }
        });
    }

    @Override
    public void delete(long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productRepository::delete);
    }
}
