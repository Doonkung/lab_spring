package com.thaicom.backend.exception;

import io.swagger.models.properties.PropertyBuilder;

public class ProductException extends BaseException {
    public ProductException(String code){
        super("product."+code);
    }

    public static ProductException productNotFound(){
        return new ProductException("not found");
    }
}
