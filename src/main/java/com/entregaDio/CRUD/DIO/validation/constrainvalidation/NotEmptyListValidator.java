package com.entregaDio.CRUD.DIO.validation.constrainvalidation;

import com.entregaDio.CRUD.DIO.validation.NotEmpetyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class NotEmptyListValidator  implements ConstraintValidator<NotEmpetyList, List> {
    @Override
    public void initialize(NotEmpetyList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
