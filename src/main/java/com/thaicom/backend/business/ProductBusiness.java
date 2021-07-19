package com.thaicom.backend.business;

import com.thaicom.backend.exception.BaseException;
import com.thaicom.backend.exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBusiness {

    public String getProductById(String id) throws BaseException {
        if (Objects.equals("1234", id)) {
            throw ProductException.productNotFound();
        }


        return id;
    }

}
