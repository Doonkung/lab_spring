package com.thaicom.backend.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestAutowire {

    // METHOD - 1 กรณี ไม่ใช้ annotation
//        private final subTest subtest = new subTest();

    // METHOD - 2 กรณีใช้ annotation เข้ามาช่วย
    @Autowired
    private subTest subtest;

    // METHOD - 3 ใช้ constructor
//    private final subTest subtest;
//
//    public TestAutowire(subTest subtest) {
//        this.subtest = subtest;
//    }

    public String getID(){
        return subtest.getHello();
    }
}
