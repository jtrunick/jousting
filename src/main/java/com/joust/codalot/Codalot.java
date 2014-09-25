package com.joust.codalot;

import java.util.ArrayList;
import java.util.List;

public class Codalot {

    public static interface Callback {
        void beforeHour(int count);
        void updateAfterDay(int count);
        void done();
    }

    private static final int XP_EARN_FOR_BONUS = 3;

    ArrayList<Knight> knights = new ArrayList<Knight>();

    public Codalot() {
    }

    Codalot(int numberOfKnights) {
        for (int i = 0; i < numberOfKnights; ++i) {
            knights.add(new Knight());
        }
    }

    public List<Knight> getKnights() {
        return knights;
    }

    public void setKnight(int id, com.joust.codalot.Knight.Position position) {
        Knight knight = knights.get(id);
        knight.setPosition(position);
    }

    public void runHours(Callback callback, int hours) {

        for (int i = 0; i < hours; i++) {
            callback.beforeHour(i);
            updateKnightForHour();
            if (i % 24 == 0) {
                updateKnightForDay();
                callback.updateAfterDay(i % 24);
            }
        }
        callback.done();
    }

    public void updateKnightForHour() {
        for (Knight knight : knights) {

            boolean xp = knight.isInTrainingYard()
                    && knight.getStamina() > 0;
            knight.incrementXp(xp ? 1 : 0);

            knight.incrementStamina(
                    knight.isInTavern() ? 1 : -1);

        }
    }

    public int calculateEarnedXp() {
        int total = 0;
        for (Knight knight : knights) {
            total += knight.getXp();
        }
        return total;
    }

    public void clearKnights() {
        knights.clear();
    }

    public void addKnightToTrainingYard(Knight knight) {
        knight.setPosition(Knight.Position.TRAINING_YARD);
        knights.add(knight);
    }

    public void addKnightToTavern(Knight knight) {
        knight.setPosition(Knight.Position.TAVERN);
        knights.add(knight);
    }

    // Called for the "day"
    public void updateKnightForDay() {
        List<Knight> earners = findKnightsWithIncreasedXp(knights, XP_EARN_FOR_BONUS);

        int group = earners.size();
        if (group == 3) {
            increaseXp(earners, 5);
        }
        else if (group == 5) {
            increaseXp(earners, 10);
        }
        else if (group == 6) {
            increaseXp(earners, 20);
        }
        resetKnights(knights);
    }

    static void resetKnights(List<Knight> knights) {
        for (Knight knight : knights) {
            knight.reset();
        }
    }

    static void increaseXp(List<Knight> knights, int increaseXp) {
        for (Knight knight : knights) {
            if (!knight.getStaminaWentNegative()) {
                knight.incrementXp(increaseXp);
            }
        }
    }

    static List<Knight> findKnightsWithIncreasedXp(List<Knight> knights, int atLeast) {
        List<Knight> toCaller = new ArrayList<Knight>();
        for (Knight knight : knights) {
            if (knight.getXp() >= atLeast) {
                toCaller.add(knight);
            }
        }
        return toCaller;
    }


}
