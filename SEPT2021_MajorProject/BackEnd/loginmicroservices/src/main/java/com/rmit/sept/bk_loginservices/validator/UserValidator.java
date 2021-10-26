package com.rmit.sept.bk_loginservices.validator;

import com.rmit.sept.bk_loginservices.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        User user = (User) object;

        //passwords below 6 not accepted
        if(user.getPassword().length() <6){
            errors.rejectValue("password","Length", "Password must be at least 6 characters");
        }

        //passwords above 19 not accepted
        if(user.getPassword().length() > 19){
            errors.rejectValue("password","Length", "Password cannot be over 19 character");
        }


        //passwords needs to match confirmed password
        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword","Match", "Passwords must match");

        }

        //confirmPassword



    }
}
