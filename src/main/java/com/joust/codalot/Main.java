package com.joust.codalot;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int KNIGHT_COUNT = 6;

    private Main() {
    }

    private static void simulate() {
        Codalot codalot = new Codalot();

        ArrayList<Knight> knights = new ArrayList<Knight>();
        for (int i = 0; i < KNIGHT_COUNT; ++i) {
            knights.add(new Knight());
        }

        Random random = new Random(1);
        for (int i = 0; i < 24; ++i) {
            codalot.clearKnights();
            for (Knight knight : knights) {
                int randomVal = random.nextInt(2);
                if (randomVal == 0) {
                    codalot.addKnightToTrainingYard(knight);
                } else if (randomVal == 1) {
                    codalot.addKnightToTavern(knight);
                }
            }
            codalot.hour();
        }
        codalot.grantBonusXp();

        int totalXp = 0;
        for (Knight knight : knights) {
            totalXp += knight.getXp();
        }
        System.out.println(String.format("Total XP earned by all %d knights: %d", knights.size(), totalXp));
    }

    public static void main(String[] args) {
        simulate();
    }

}
