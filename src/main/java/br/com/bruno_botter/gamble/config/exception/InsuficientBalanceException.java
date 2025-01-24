package br.com.bruno_botter.gamble.config.exception;

public class InsuficientBalanceException extends RuntimeException{

    public InsuficientBalanceException(String msg) {
        super(msg);
    }
}
