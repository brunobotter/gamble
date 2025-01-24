package br.com.bruno_botter.gamble.model;

import br.com.bruno_botter.gamble.dto.BoardResponse;
import br.com.bruno_botter.gamble.dto.GambleRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Gamble {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gambleId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private BigDecimal amountBet;
    private BigDecimal prizeValue;

    @Embedded
    private BoardResponse result;
    private boolean win;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Gamble() {
    }

    public Gamble(Client client, BigDecimal amountBet, BigDecimal prizeValue, BoardResponse result, boolean win, LocalDateTime createAt) {
        this.client = client;
        this.amountBet = amountBet;
        this.prizeValue = prizeValue;
        this.result = result;
        this.win = win;
        this.createAt = createAt;
    }

    public static Gamble fromDto(Client client, GambleRequest gambleRequest) {
        Gamble gamble = new Gamble();
        gamble.setAmountBet(gambleRequest.getAmount());
        gamble.setClient(client);
        gamble.setCreateAt(LocalDateTime.now());
        return gamble;
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getAmountBet() {
        return amountBet;
    }

    public BigDecimal getPrizeValue() {
        return prizeValue;
    }

    public BoardResponse getResult() {
        return result;
    }

    public void setResult(BoardResponse result) {
        this.result = result;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmountBet(BigDecimal amountBet) {
        this.amountBet = amountBet;
    }

    public void setPrizeValue(BigDecimal prizeValue) {
        this.prizeValue = prizeValue;
    }



    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}
