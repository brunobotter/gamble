package br.com.bruno_botter.gamble.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class BoardResponse {

    private String boardA;
    private String boardB;
    private String boardC;

    public BoardResponse() {
    }

    public String getBoardA() {
        return boardA;
    }

    public String getBoardB() {
        return boardB;
    }

    public String getBoardC() {
        return boardC;
    }

    public void setBoardA(String boardA) {
        this.boardA = boardA;
    }

    public void setBoardB(String boardB) {
        this.boardB = boardB;
    }

    public void setBoardC(String boardC) {
        this.boardC = boardC;
    }
}
