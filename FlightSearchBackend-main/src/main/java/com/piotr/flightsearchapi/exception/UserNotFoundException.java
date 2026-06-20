package com.piotr.flightsearchapi.exception;

public class UserNotFoundException extends RuntimeException {

    private final Integer id;

    public UserNotFoundException(Integer id) {
        super(String.format("User with id %d not found", id));
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
