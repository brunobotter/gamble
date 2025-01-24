package br.com.bruno_botter.gamble.dto;

import br.com.bruno_botter.gamble.model.Gamble;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GambleResponse {

    private BoardResponse board;
    private boolean win;
    private BigDecimal winAmount;


    public GambleResponse(Gamble gamble) {
        this.board = gamble.getResult();
        this.win = gamble.isWin();
        this.winAmount = gamble.getPrizeValue();
    }

    public GambleResponse() {
    }

    public BoardResponse getBoard() {
        return board;
    }

    public boolean isWin() {
        return win;
    }

    public BigDecimal getWinAmount() {
        return winAmount;
    }
}
