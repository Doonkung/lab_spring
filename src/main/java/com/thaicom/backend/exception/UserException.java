package com.thaicom.backend.exception;

import org.apache.catalina.User;

public class UserException extends BaseException {

    public UserException(String code) {
        super("user."+ code);
    }

    // user .register.email.null

    public static  UserException emailNull() {
        return new UserException("register.email.null");
    }
    public static  UserException nameNull() {
        return new UserException("register.name.null");
    }
    public static  UserException passwordNull() {
        return new UserException("register.password.null");
    }
    public static  UserException requsetNull() {
        return new UserException("register.request.null");
    }
    public static  UserException emailExisting() {
        return new UserException("register.request.emailExisting");
    }

    public static BaseException loginFailEmailNotFound() {
        return new UserException("login.request.invalidLogin");
    }
}
