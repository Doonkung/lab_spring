package com.thaicom.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class testBean {

    // DOC - Bean annotation คล้ายๆกับ การ set configuration สำหรับ ส่วนต่างๆ
    // เช่น สำหรับ APIs service หมายถึงการกำหนดให้ ทุกๆ Service นั้นมี header หรือ การป้องกันอะไรบ้าง คล้ายๆ กับ middleware
    // สำหรับส่วนต่อ database หมายถึงการกำหนดการใข้งาน database ต่างๆเช่น setUsernamePassword หรือ connection string ต่างๆ
    @Bean
    public String getCompile(){
        System.out.println("compiling");
        return "compiling";
    }
}
