package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateUserEmailRequestDto(
        @NotBlank(message = ERORR_MESSAGE_EMAIL_LENGTH)
        @Length(max = 100, message = ERORR_MESSAGE_EMAIL_LENGTH)
        @Email(message = ERORR_MESSAGE_EMAIL_VALIDITY)
        String Email

) {
    private static final String ERORR_MESSAGE_EMAIL_LENGTH = "Email length must be between 1 and 100 characters";

    private static final String ERORR_MESSAGE_EMAIL_VALIDITY = "Please provide a valid email address";
}
