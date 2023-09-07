package com.ingemark.business.service;

import com.ingemark.dto.ProductDto;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class ProductBusinessValidator {

    public static void validate(ProductDto productDto) {

        String validationErrors = "";

        if(productDto.getPriceEur() != null && productDto.getPriceEur().compareTo(BigDecimal.ZERO) != 1) {
            validationErrors += "Price must be larger than 0;";
        }

        if(StringUtils.isNotBlank(productDto.getCode()) && productDto.getCode().length() != 10) {
            validationErrors += "Product's code length must be exactly 10;";
        }

        if(StringUtils.isNotBlank(validationErrors)) {

            throw new ServiceGeneralException(validationErrors);
        }
    }
}
