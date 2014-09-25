package com.joust.codalot;

import java.util.ArrayList;

public class CodalotTest {

    public void testMain() {
        Codalot codalot = new Codalot(6);

        codalot.setKnight(0, Knight.Position.TAVERN);
        codalot.setKnight(1, Knight.Position.TAVERN);
        codalot.setKnight(2, Knight.Position.TRAINING_YARD);
        codalot.setKnight(3, Knight.Position.TRAINING_YARD);
        codalot.setKnight(4, Knight.Position.TRAINING_YARD);
        codalot.setKnight(5, Knight.Position.TRAINING_YARD);
        codalot.day();

        assert(codalot.calculateEarnedXp() == 4);

    }

}
