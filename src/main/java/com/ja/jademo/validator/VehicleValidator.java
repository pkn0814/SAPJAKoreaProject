package com.ja.jademo.validator;

import com.ja.jademo.model.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class VehicleValidator implements Validator {

    /**
     * This Validator validates *just* Person instances
     */
    @Override
    public boolean supports(Class clazz) {
        return Vehicle.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors e) {
        Vehicle v = (Vehicle) obj;
        if(StringUtils.isEmpty(v.getName())){
            e.rejectValue("name", "key", "이름을 입력하세요");
        }
        if(StringUtils.isEmpty(v.getDriver())){
            e.rejectValue("driver", "key", "운전자를 입력하세요");
        }

    }
}
