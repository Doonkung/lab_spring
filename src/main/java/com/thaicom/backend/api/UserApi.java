package com.thaicom.backend.api;

import com.thaicom.backend.business.UserBusiness;
import com.thaicom.backend.entity.User;
import com.thaicom.backend.exception.BaseException;
import com.thaicom.backend.helper.TestAutowire;
import com.thaicom.backend.model.MLoginRequest;
import com.thaicom.backend.model.MRegisterRequest;
import com.thaicom.backend.model.TestResponse;
import com.thaicom.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserApi {
    // METHOD: 1 => Field Injection
//    @Autowired
//    private TestBusiness business;

    @Autowired
    private TestAutowire testauto;

    @Autowired
    private UserBusiness business;
//    // METHOD: 2 => Constructor Injection
//    private final UserBusiness business;
//
//    public UserApi(UserBusiness business) {
//        this.business = business;
//    }
    @Autowired
    private UserService userService;

    @GetMapping
    public TestResponse getName(){
        TestResponse response = new TestResponse();
        response.setName("test");
        response.setFood("Food");

        return response;
    }

    @GetMapping
    @RequestMapping("/GET2")
    public TestResponse getName2(){
        TestResponse response = new TestResponse();
        response.setName("test2");
        response.setFood("Food2");

        return response;
    }

    @GetMapping
    @RequestMapping("/hello")
    public TestResponse getName3(){
        TestResponse response = new TestResponse();
        response.setName(testauto.getID());
        response.setFood("Food2");

        return response;
    }


    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MRegisterRequest request) throws BaseException {

        User response = business.register(request);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String> refreshToken() throws BaseException{
        String response = business.refreshToken();
        return ResponseEntity.ok(response);
    }



}
