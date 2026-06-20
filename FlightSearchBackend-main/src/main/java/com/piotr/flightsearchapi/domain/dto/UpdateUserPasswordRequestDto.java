package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateUserPasswordRequestDto(

        @NotBlank(message = ERORR_MESSAGE_PASSWORD_LENGTH)
        @Length(max = 255, message = ERORR_MESSAGE_PASSWORD_LENGTH)
        String PasswordHash
) {
    private static final String ERORR_MESSAGE_PASSWORD_LENGTH = "Email length must be between 1 and 255 characters";
}
