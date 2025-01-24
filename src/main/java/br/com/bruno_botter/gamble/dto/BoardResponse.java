package br.com.bruno_botter.gamble.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class BoardResponse {

    private String boardA;
    private String boardB;
    private String boardC;

    public BoardResponse() {
    }

    public BoardResponse(String boardA, String boardB, String boardC) {
        this.boardA = boardA;
        this.boardB = boardB;
        this.boardC = boardC;
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
