package org.example.bookshelf.Common.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class PublishedYearValidator implements ConstraintValidator<ValidPublishedYear, Integer> {
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
       if (integer == null) {
           return true;
       }
        return integer <= Year.now().getValue();}

}
