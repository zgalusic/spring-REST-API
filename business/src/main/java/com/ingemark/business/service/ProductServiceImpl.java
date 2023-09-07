package com.ingemark.business.service;

import com.ingemark.business.api.rest.client.hnb.TecajnaListaRestClientService;
import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;
import com.ingemark.business.data.entity.Product;
import com.ingemark.business.data.repository.ProductRepository;
import com.ingemark.business.service.mapper.ProductMapper;
import com.ingemark.dto.ProductDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TecajnaListaRestClientService tecajnaListaRestClientService;

    public ProductServiceImpl(ProductRepository productRepository, TecajnaListaRestClientService tecajnaListaRestClientService) {
        this.productRepository = productRepository;
        this.tecajnaListaRestClientService = tecajnaListaRestClientService;
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
    @Transactional
    public long create(ProductDto productDto) {

        try {

            ProductBusinessValidator.validate(productDto);

            Product product = ProductMapper.map(productDto);
            TecajnaListaItem[] tecajnaListaItems = tecajnaListaRestClientService.fetch("USD");
            product.setPriceUsd(convertPrice(product.getPriceEur(), tecajnaListaItems));
            Product savedProduct = productRepository.save(product);

            return savedProduct.getId();

        } catch (Exception e) {

            throw new ServiceGeneralException(e);
        }
    }

    @Override
    @Transactional
    public void update(ProductDto productDto) {

        try {
            ProductBusinessValidator.validate(productDto);

            Optional<Product> productOptional = productRepository.findById(productDto.getId());
            productOptional.ifPresent(p -> {

                if (StringUtils.isNotBlank(productDto.getDescription())) {
                    p.setDescription(productDto.getDescription());
                }

                if (productDto.getPriceEur() != null) {
                    p.setPriceEur(productDto.getPriceEur());
                    TecajnaListaItem[] tecajnaListaItems = tecajnaListaRestClientService.fetch("USD");
                    p.setPriceUsd(convertPrice(p.getPriceEur(), tecajnaListaItems));
                }

                if (productDto.getAvailable() != null) {
                    p.setAvailable(productDto.getAvailable());
                }

                if (StringUtils.isNotBlank(productDto.getName())) {
                    p.setName(productDto.getName());
                }

                if (StringUtils.isNotBlank(productDto.getCode())) {
                    p.setCode(productDto.getCode());
                }
            });

        } catch (Exception e) {

            throw new ServiceGeneralException(e);
        }
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {

            Optional<Product> productOptional = productRepository.findById(id);
            productOptional.ifPresent(productRepository::delete);

        } catch (Exception e) {

            throw new ServiceGeneralException(e);
        }
    }

    private BigDecimal convertPrice(BigDecimal price, TecajnaListaItem[] tecajnaListaItems) {

        BigDecimal convertedPrice = BigDecimal.ZERO;

        if(tecajnaListaItems != null && tecajnaListaItems.length > 0) {

            String kupovniTecajString = tecajnaListaItems[0].getKupovniTecaj();
            kupovniTecajString = kupovniTecajString.replace(",", ".");
            BigDecimal kupovniTecaj = new BigDecimal(kupovniTecajString);
            convertedPrice = price.multiply(kupovniTecaj).setScale(2, RoundingMode.HALF_UP);
        }

        return convertedPrice;
    }
}
