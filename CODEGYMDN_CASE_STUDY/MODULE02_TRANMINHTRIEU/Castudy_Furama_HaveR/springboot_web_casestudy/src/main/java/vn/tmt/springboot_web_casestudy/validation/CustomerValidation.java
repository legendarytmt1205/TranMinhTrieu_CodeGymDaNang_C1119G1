package vn.tmt.springboot_web_casestudy.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.tmt.springboot_web_casestudy.entity.Customer;


public class CustomerValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
