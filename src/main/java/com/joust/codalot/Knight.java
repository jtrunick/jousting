package com.joust.codalot;


public class Knight {

    public static enum Position {
        TAVERN,
        TRAINING_YARD,
        ROUND_TABLE
    }

    private boolean king;
    private int xp;
    private int stamina;
    private int hoursAtRoundTable;
    private boolean staminaWentNegative;
    private Position position = Position.TAVERN;

    Knight() {
        resetDay();
        xp = 0;
        stamina = 0;
    }

    Knight(Position p) {
        this.position = p;
    }

    public boolean isKing() {
        return this.king;
    }

    void kingMe() {
        this.king = true;
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

    int getHoursAtRoundTable() {
        return this.hoursAtRoundTable;
    }

    void incrementHoursAtRoundTable() {
        if (isAtRoundTable()) {
            this.hoursAtRoundTable += 1;
        }
    }

    public int getStamina() {
        return stamina;
    }

    void setStaminaWentNegative(boolean value) {
        this.staminaWentNegative = value;
    }

    boolean getStaminaWentNegative() {
        return staminaWentNegative;
    }

    void resetDay() {
        staminaWentNegative = false;
        hoursAtRoundTable = 0;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
        if (this.stamina < 0) {
            staminaWentNegative = true;
        }
    }

    void incrementStamina(int stamina) {
        setStamina(this.stamina + stamina);
    }

    void setPosition(Position p) {
        this.position = p;
    }

    public boolean isAtRoundTable() {
        return position == Position.ROUND_TABLE;
    }

    public boolean isInTavern() {
        return position == Position.TAVERN;
    }

    public boolean isInTrainingYard() {
        return this.position == Position.TRAINING_YARD;
    }
}