package player;

import card.Card;

public class Opponent extends Player {

    private static double intelligence;

    private static final double TOTAL_CHANCE = 1.0;
    private static final double HIGH_CHANCE = .75;
    private static final double MEDIUM_CHANCE = .50;
    private static final double LOW_CHANCE = .25;


    public Opponent(double intelligence){
        this.intelligence = intelligence;
    }

    public static double getIntelligence() {
        return intelligence;
    }

    public double calculateOdds(int card_number, int multiple) throws IllegalMoveException{
        int count = haveCardInHand(card_number);

        int combination = count + multiple;

        if(combination > 4){
            return TOTAL_CHANCE;
        }

        switch (combination){
            case 4: return HIGH_CHANCE;
            case 3: return MEDIUM_CHANCE;
            case 2: return LOW_CHANCE;
            case 1: return LOW_CHANCE;
            default: throw new IllegalMoveException("There were no cards put down.");
        }

    }

    private int haveCardInHand(int number){
        int count = 0;
        for (Card card: getHand().getCards()){
            if(card.getNumber() == number){
                count++;
            }
        }
        return count;
    }

    public double calculateCheat(double odds){
        return odds * intelligence;
    }

    @Override
    public int[] getCardsToPlay() {
        return new int[0];
    }
}
