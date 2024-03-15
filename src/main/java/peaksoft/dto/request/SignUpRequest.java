package peaksoft.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import peaksoft.enums.Gender;
import peaksoft.validations.email.EmailValidation;
import peaksoft.validations.password.PasswordValidation;

import java.time.LocalDate;

public record SignUpRequest(
        String firstName,
        String lastName,

        @Email @EmailValidation
        String email,

        @PasswordValidation
        String password,
        LocalDate dateOfBirth,
        String phoneNumber,
        @Enumerated(EnumType.STRING)
        Gender gender
) {
}
