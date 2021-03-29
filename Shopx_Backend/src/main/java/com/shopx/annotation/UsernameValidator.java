package com.shopx.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopx.service.UserService;

@Component
public class UsernameValidator implements ConstraintValidator<NotExistingUsername, String> {
 
    @Autowired 
    private UserService userService;
 
    public void initialize(NotExistingUsername notExistingUsername) {
    }
 
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.isUsernameExist(username);
    }
}
