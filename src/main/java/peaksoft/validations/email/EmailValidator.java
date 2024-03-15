package peaksoft.validations.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import peaksoft.validations.email.EmailValidation;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.endsWith("@gmail.com") || value.endsWith("@icloud.com");
    }
}
