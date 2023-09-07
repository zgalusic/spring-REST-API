package com.ingemark.business.api.rest.endpoint;

import com.ingemark.business.service.ProductService;
import com.ingemark.dto.ProductDto;
import com.ingemark.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rest/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseWrapper<ProductDto> create(@RequestBody ProductDto productDto) {

        LOGGER.info("Creating a new product");

        long productId = productService.create(productDto);

        ResponseWrapper<ProductDto> productResponseWrapper = new ResponseWrapper<>();
        ProductDto createdProductDto = new ProductDto();
        createdProductDto.setId(productId);
        productResponseWrapper.setData(createdProductDto);
        productResponseWrapper.setMessage("Product created successfully.");

        return productResponseWrapper;
    }

    @GetMapping("{id}")
    public ResponseWrapper<ProductDto> fetch(@PathVariable Long id) {

        LOGGER.info("Fetching product with id {}", id);

        ProductDto productDto = productService.fetch(id);

        ResponseWrapper<ProductDto> productResponseWrapper = new ResponseWrapper<>();
        productResponseWrapper.setData(productDto);

        return productResponseWrapper;
    }

    @GetMapping("/all")
    public ResponseWrapper<List<ProductDto>> fetchAll() {

        LOGGER.info("Fetching all products");
        List<ProductDto> productDtoList = productService.fetchAll();
        ResponseWrapper<List<ProductDto>> productListResponseWrapper = new ResponseWrapper<>();
        productListResponseWrapper.setData(productDtoList);

        return productListResponseWrapper;
    }

    @PutMapping("/update")
    public ResponseWrapper<ProductDto> update(@RequestBody ProductDto productDto) {

        LOGGER.info("Updating product");
        productService.update(productDto);

        ResponseWrapper<ProductDto> productResponseWrapper = new ResponseWrapper<>();
        productResponseWrapper.setMessage("Product successfully updated.");

        return productResponseWrapper;
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<ProductDto> delete(@PathVariable Long id) {

        LOGGER.info("Deleting product with id {}", id);

        productService.delete(id);
        ResponseWrapper<ProductDto> productResponseWrapper = new ResponseWrapper<>();
        productResponseWrapper.setMessage("Product successfully deleted.");

        return productResponseWrapper;
    }
}
