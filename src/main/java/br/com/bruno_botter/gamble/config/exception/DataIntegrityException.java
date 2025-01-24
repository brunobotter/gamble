package br.com.bruno_botter.gamble.config.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DataIntegrityException extends DataIntegrityViolationException {

    public DataIntegrityException(String msg) {
        super(msg);
    }
}
