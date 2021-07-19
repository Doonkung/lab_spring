package com.thaicom.backend.helper;

import org.springframework.stereotype.Component;

// กรณี ไม่ใช้ annotation ไม่จำเป็นต้องใส่ @Component
@Component
public class subTest {

    public String hello;

    public String getHello(){
        return "hello Sub";
    }
}
