package br.com.bruno_botter.gamble.config.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError{


    private List<ValidationMessage> erros = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String nome, String mensagem) {
        erros.add(new ValidationMessage(nome, mensagem));
    }

    public List<ValidationMessage> getErros() {
        return erros;
    }

    public void setErros(List<ValidationMessage> erros) {
        this.erros = erros;
    }
}
