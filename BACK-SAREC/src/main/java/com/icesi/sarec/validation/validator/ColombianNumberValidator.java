package com.icesi.sarec.validation.validator;


import com.icesi.sarec.validation.annotation.ColombianNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ColombianNumberValidator implements ConstraintValidator<ColombianNumber, String> {
    @Override
    public void initialize(ColombianNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("\\+573[0-9]{9}");
    }
}