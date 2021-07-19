package com.thaicom.backend.business;

import com.thaicom.backend.entity.User;
import com.thaicom.backend.exception.BaseException;
import com.thaicom.backend.exception.UserException;
import com.thaicom.backend.model.MLoginRequest;
import com.thaicom.backend.model.MRegisterRequest;
import com.thaicom.backend.service.TokenService;
import com.thaicom.backend.service.UserService;
import com.thaicom.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusiness {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityUtil securityUtil;

    public String login(MLoginRequest request) throws BaseException {
        // validate request

        // verify database
        Optional<User> opt = userService.findByEmail(request.getEmail());
        // isEmpty specific use by JAVA 11
        if (!opt.isPresent()) {
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if (!userService.matchPassword(request.getPassword(), user.getPassword())){
            throw UserException.loginFailEmailNotFound();
        }

        // TODO - generate toekn
        String token = tokenService.Tokenize(user);


//        return tokenService.tokenize(user);
        return token;
    }

    public String refreshToken() throws BaseException {
        Optional<String> optId = securityUtil.getCurrentUserId();
        if (!optId.isPresent()){
            throw UserException.loginFailEmailNotFound();
        }


        String userId = optId.get();
        Optional<User> opt = userService.findByid(userId);

        if(!opt.isPresent()){
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        return tokenService.Tokenize(user);
    }

    public User register(MRegisterRequest request) throws BaseException {
            User user = userService.create(request.getEmail(), request.getPassword(), request.getName());

            // validate ...

            return user;
        }
}
