package br.com.bruno_botter.gamble.config.exception;

import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
