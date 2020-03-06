package vn.tmt.springboot_web_casestudy.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.tmt.springboot_web_casestudy.entity.Contract;

@Component
public class ContractValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        if (contract.getContractDay()==null) {
            errors.rejectValue("contractDay","contract.valid");
        }
    }
}