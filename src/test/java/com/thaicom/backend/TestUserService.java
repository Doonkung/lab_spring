package com.thaicom.backend;

import com.thaicom.backend.entity.Address;
import com.thaicom.backend.entity.Social;
import com.thaicom.backend.entity.User;
import com.thaicom.backend.exception.BaseException;
import com.thaicom.backend.exception.UserException;
import com.thaicom.backend.service.AddressService;
import com.thaicom.backend.service.SocialService;
import com.thaicom.backend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private SocialService socialService;

    @Autowired
    private AddressService addressService;

    @Test
    @DisplayName("สร้าง User")
    void testCreate() throws BaseException{
        User user = userService.create(
                TestData.email,
                TestData.password,
                TestData.name
        );

        // check not null
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());

        // check equals
        Assertions.assertEquals(TestData.email, user.getEmail());

//        boolean isMatched =

    }

    @Test
    @DisplayName("สร้าง social user")
    void testCreateSocial() {
        Optional<User> opt = userService.findByEmail(TestData.email);
        Assertions.assertTrue(opt.isPresent());

        User user = opt.get();
        Social social = user.getSocial();
        Assertions.assertNull(social);

        Social createSocial = socialService.create(
                user,
                TestData_social.facebook,
                TestData_social.line,
                TestData_social.instagram
        );

        Assertions.assertEquals(TestData_social.facebook, createSocial.getFacebook());
    }

    @Test
    @DisplayName("สร้าง Address user")
    void TestCreateAddress() {
        Optional<User> opt = userService.findByEmail(TestData.email);
        Assertions.assertTrue(opt.isPresent());

        User user = opt.get();
        List<Address> address = user.getAddress();
        Assertions.assertTrue(address.isEmpty());

        Address CreateAddress = addressService.create(
                user,
                addressTestData.line1,
                addressTestData.line2,
                addressTestData.zipcode
        );

        Assertions.assertEquals(addressTestData.line1, CreateAddress.getLine1());
    }

    @Test
    @DisplayName("Delete user")
    void TestDeleteUser(){
        Optional<User> opt = userService.findByEmail(TestData.email);
        Assertions.assertTrue(opt.isPresent());

        User user = opt.get();
        userService.deleteById(user.getId());
        Optional<User> optDelete  = userService.findByEmail(TestData.email);
        Assertions.assertFalse(optDelete.isPresent());

    }
    interface TestData{
        String email = "test@test.com";
        String password = "test12345";
        String name = "testF testL";

    }

    interface addressTestData{
        String line1 = "12345";
        String line2 = "67890";
        String zipcode = "112334";
    }
    interface TestData_social{
        String facebook = "facebook";
        String line = "line";
        String instagram = "instagram";
    }
}
