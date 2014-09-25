package com.joust.codalot;

import java.util.ArrayList;
import java.util.List;

public class Codalot {

    ArrayList<Knight> knights = new ArrayList<Knight>();

    public Codalot() {
    }

    Codalot(int numberOfKnights) {
        for (int i = 0; i < 6; ++i) {
            knights.add(new Knight());
        }
    }

    //TODO Make this immutable?
    public List<Knight> getKnights() {
        return knights;
    }

    public void setKnight(int id, com.joust.codalot.Knight.Position position) {
        Knight knight = knights.get(id);
        knight.setPosition(position);
    }

    public void hour() {
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

    public void grantBonusXp() {
        int bonusKnights = 0;
        for (Knight knight : knights) {
            if (knight.getXp() >= 3) {
                bonusKnights++;
            }
        }
        if (bonusKnights == 3) {
            for (Knight knight : knights) {
                if (knight.getXp() >= 3) {
                    knight.setXp(knight.getXp() + 5);
                }
            }
        }
        if (bonusKnights == 5) {
            for (Knight knight : knights) {
                if (knight.getXp() >= 3) {
                    knight.setXp(knight.getXp() + 10);
                }
            }
        }
        if (bonusKnights == 6) {
            for (Knight knight : knights) {
                if (knight.getXp() >= 3) {
                    knight.setXp(knight.getXp() + 20);
                }
            }
        }
    }


}
