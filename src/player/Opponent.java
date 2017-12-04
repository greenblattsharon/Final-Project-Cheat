package player;

import card.Card;

public class Opponent extends Player {

    private static double intelligence;

    public Opponent(double intelligence){
        this.intelligence = intelligence;
    }

    public double calculateOdds(Card card){
        return 0;
    }

    public double calculateCheat(double odds){
        return 0;
    }
}
