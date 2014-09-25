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


}
