package br.com.bruno_botter.gamble.config.exception;

import java.io.Serializable;

public class ValidationMessage implements Serializable {

    private String name;
    private String message;

    public ValidationMessage() {
    }

    public ValidationMessage(String nome, String message) {
        super();
        this.name = nome;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
