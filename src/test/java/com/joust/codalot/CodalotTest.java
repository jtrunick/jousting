package com.joust.codalot;

public class CodalotTest {

    public void testEarnedXp() {
        Codalot codalot = new Codalot(6);

        codalot.setKnight(0, Knight.Position.TAVERN);
        codalot.setKnight(1, Knight.Position.TAVERN);
        codalot.setKnight(2, Knight.Position.TRAINING_YARD);
        codalot.setKnight(3, Knight.Position.TRAINING_YARD);
        codalot.setKnight(4, Knight.Position.TRAINING_YARD);
        codalot.setKnight(5, Knight.Position.TRAINING_YARD);
        codalot.hour();

        assert(codalot.calculateEarnedXp() == 0);
    }


    //JST-2
    public void testNoXpWhileTraining() {
        Codalot codalot = new Codalot(2);

        codalot.setKnight(0, Knight.Position.TRAINING_YARD);
        codalot.setKnight(1, Knight.Position.TAVERN);
        codalot.hour();

        // Knight 0 shouldn't have XP, because no stamina
        // Knight 1 should have earned stamina because tavern
        assert(codalot.getKnights().get(0).getXp() == 0);
        assert(codalot.getKnights().get(1).getStamina() == 1);

        codalot.setKnight(1, Knight.Position.TRAINING_YARD);
        codalot.hour();

        // Knight 0 shouldn't have XP, because no stamina
        // Knight 1 should have earned XP, because he earned stamina on day 1
        assert(codalot.getKnights().get(0).getXp() == 0);
        assert(codalot.getKnights().get(1).getXp() == 1);
    }


    public int XpGroupNBonus(int knightCount, int initialXp) {
        Codalot codalot = new Codalot(6);

        for (int i = 0; i < knightCount; i++) {
            codalot.getKnights().get(i).setXp(initialXp);
        }
        codalot.grantBonusXp();

        int earned = codalot.getKnights().get(0).getXp();
        return earned;
    }

    //JST-3
    public void testXpGroupNBonus() {
        assert(XpGroupNBonus(3, 3) == 8);
        assert(XpGroupNBonus(3, 4) == 9);   // at least 3
        assert(XpGroupNBonus(5, 3) == 13);
        assert(XpGroupNBonus(6, 3) == 23);
        assert(XpGroupNBonus(3, 2) == 2);   // Earned no bonus -- not enough xp earned
        assert(XpGroupNBonus(4, 3) == 3);   // Earned no bonus -- not right size group
    }


    public static void main(String args[]) {
        CodalotTest test = new CodalotTest();
        test.testXpGroupNBonus();
    }

}
