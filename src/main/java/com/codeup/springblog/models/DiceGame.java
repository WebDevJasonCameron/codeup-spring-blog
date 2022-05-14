package com.codeup.springblog.models;

public class DiceGame {

    // ATT
    private String userNum;
    private String throwNum;
    private String gameOutcome;

    // CON
    public DiceGame() {
    }
    public DiceGame(String userNum) {
        this.userNum = userNum;
    }
    public DiceGame(String userNum, String throwNum) {
        this.userNum = userNum;
        this.throwNum = throwNum;
    }

    // GETS
    public String getUserNum() {
        return userNum;
    }
    public String getThrowNum() {
        return throwNum;
    }
    public String getGameOutcome() {
        return gameOutcome;
    }

    // SETS
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }
    public void setThrowNum(String throwNum) {
        this.throwNum = throwNum;
    }
    public void setGameOutcome(String gameOutcome) {
        this.gameOutcome = gameOutcome;
    }

}  //<--END
