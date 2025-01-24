package br.com.bruno_botter.gamble.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaResponse {

    // Dados da tabela Client
    private String name;
    private String username;
    private BigDecimal saldo;

    // Dados da tabela Gamble
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAposta;
    private BigDecimal amountBet;
    private BigDecimal prizeValue;
    private Boolean win;
    private String boardA;
    private String boardB;
    private String boardC;

    public ConsultaResponse() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(LocalDateTime dataAposta) {
        this.dataAposta = dataAposta;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public String getBoardA() {
        return boardA;
    }

    public void setBoardA(String boardA) {
        this.boardA = boardA;
    }

    public String getBoardB() {
        return boardB;
    }

    public void setBoardB(String boardB) {
        this.boardB = boardB;
    }

    public String getBoardC() {
        return boardC;
    }

    public void setBoardC(String boardC) {
        this.boardC = boardC;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getAmountBet() {
        return amountBet;
    }

    public void setAmountBet(BigDecimal amountBet) {
        this.amountBet = amountBet;
    }

    public BigDecimal getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(BigDecimal prizeValue) {
        this.prizeValue = prizeValue;
    }

    public ConsultaResponse(BigDecimal saldo, String name, String username,
                             BigDecimal amountBet, LocalDateTime dataAposta, BigDecimal prizeValue,
                            boolean win, String boardA, String boardB, String boardC) {

        this.saldo = saldo;
        this.name = name;
        this.username = username;
        this.amountBet = amountBet;
        this.dataAposta = dataAposta;
        this.prizeValue = prizeValue;
        this.win = win;
        this.boardA = boardA;
        this.boardB = boardB;
        this.boardC = boardC;
    }
}
