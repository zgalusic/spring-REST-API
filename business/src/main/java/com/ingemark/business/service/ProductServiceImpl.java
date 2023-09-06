package com.ingemark.business.service;

import com.ingemark.business.data.entity.Product;
import com.ingemark.business.data.repository.ProductRepository;
import com.ingemark.dto.ProductDto;
import org.springframework.stereotype.Service;

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

        return null;
    }

    @Override
    public List<ProductDto> fetchAll() {

        Iterable<Product> productList = productRepository.findAll();

        return null;
    }

    @Override
    public List<ProductDto> filterBy(ProductDto productDto) {
        return null;
    }

    @Override
    public long create(ProductDto productDto) {
        return 0;
    }

    @Override
    public void update(ProductDto productDto) {

        Optional<Product> productOptional = productRepository.findById(productDto.getId());
        productOptional.ifPresent(p -> {}); // TODO
    }

    @Override
    public void delete(long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productRepository::delete);
    }
}
