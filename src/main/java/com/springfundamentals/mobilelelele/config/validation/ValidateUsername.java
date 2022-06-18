package com.springfundamentals.mobilelelele.config.validation;

import com.springfundamentals.mobilelelele.dao.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateUsername implements ConstraintValidator<UsernameAvailable, String> {
    private final UserRepository userRepository;

    public ValidateUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        boolean isUsernamePresent = this.userRepository.findByUsername(username).isPresent();

        if (isUsernamePresent) {
            context.disableDefaultConstraintViolation();
            String usernameViolationMessage = "This username already exists!";
            context.buildConstraintViolationWithTemplate(usernameViolationMessage)
                    .addConstraintViolation();
        }

        return !isUsernamePresent;
    }
}