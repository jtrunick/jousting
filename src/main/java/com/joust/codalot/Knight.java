package com.joust.codalot;


public class Knight {

    public static enum Position {
        TAVERN,
        TRAINING_YARD
    }

    private int xp;
    private int stamina;
    private Position position = Position.TAVERN;

    Knight() {
        xp = 0;
        stamina = 0;
    }

    Knight(Position p) {
        this.position = p;
    }

    public int getXp() {
        return xp;
    }

    void setXp(int xp) {
        this.xp = xp;
    }

    void incrementXp(int xp) {
        this.xp += xp;
    }

    public int getStamina() {
        return stamina;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    void incrementStamina(int stamina) {
        this.stamina += stamina;
    }

    void setPosition(Position p) {
        this.position = p;
    }

    public boolean isInTavern() {
        return position == Position.TAVERN;
    }

    public boolean isInTrainingYard() {
        return this.position == Position.TRAINING_YARD;
    }
}