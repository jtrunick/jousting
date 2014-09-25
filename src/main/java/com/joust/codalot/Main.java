package com.joust.codalot;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int KNIGHT_COUNT = 12;

    private Main() {
    }

    private static void simulate() {
        final Random random = new Random(1);
        final Codalot codalot = new Codalot(KNIGHT_COUNT);

        Codalot.Callback callback = new Codalot.Callback() {

            public void beforeHour(int count) {
                // This is called before each hour

                for (int i = 0; i < KNIGHT_COUNT; i++) {
                    int randomVal = random.nextInt(2);
                    if (randomVal == 0) {
                        codalot.setKnight(i, Knight.Position.TRAINING_YARD);
                    } else if (randomVal == 1) {
                        codalot.setKnight(i, Knight.Position.TAVERN);
                    }
                }
            }

            public void updateAfterDay(int count) {
                // This is called after the daily bonus rules are run.
                // Do somthing here... could do special checks for interesting points in time.
                // Or add more callbacks.
            }

            public void done() {
                int totalXp = 0;
                for (Knight knight : codalot.getKnights()) {
                    totalXp += knight.getXp();
                }
                System.out.println(String.format("Total XP earned by all %d knights: %d", codalot.getKnights().size(), totalXp));
            }
        };
        codalot.runHours(callback, 24 * 7 * 12);  // Run for 12 weeks.
    }

    public static void main(String[] args) {
        simulate();
    }

}
