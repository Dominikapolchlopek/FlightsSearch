package com.piotr.flightsearchapi.controller;

import com.piotr.flightsearchapi.domain.dto.ErrorDto;
import com.piotr.flightsearchapi.exception.UserNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex){

        String errorMessage = ex.getBindingResult().getFieldErrors().stream().findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation error");

        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException ex) {
        Integer userNotFoundId = ex.getId();
        String errorMessage = String.format("User with Id %d not found", userNotFoundId);
        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
