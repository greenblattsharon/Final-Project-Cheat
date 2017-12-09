package player;

import card.Card;
import java.util.Random;

public class Opponent extends Player {

    private static double intelligence;

    private static final double TOTAL_CHANCE = 1.0;
    private static final double HIGH_CHANCE = .75;
    private static final double MEDIUM_CHANCE = .50;
    private static final double LOW_CHANCE = .25;


    public Opponent(double intelligence) {
        this.intelligence = intelligence;
    }

    public static double getIntelligence() {
        return intelligence;
    }

    public double calculateOdds(int card_number, int multiple) throws IllegalMoveException {
        int count = haveCardInHand(card_number);

        int combination = count + multiple;

        if (combination > 4) {
            return TOTAL_CHANCE;
        }

        switch (combination) {
            case 4:
                return HIGH_CHANCE;
            case 3:
                return MEDIUM_CHANCE;
            case 2:
                return LOW_CHANCE;
            case 1:
                return LOW_CHANCE;
            default:
                throw new IllegalMoveException("There were no cards put down.");
        }

    }

    private int haveCardInHand(int card_number) {
        if(card_number == 0){
            card_number = 13;
        }

        if (card_number == 14){
            card_number = 1;
        }

        int count = 0;
        for (Card card : getHand().getCards()) {
            if (card.getNumber() == card_number) {
                count++;
            }
        }
        return count;
    }

    public double calculateCheat(double odds) {
        return odds * intelligence;
    }

    @Override
    public int[] getCardsToPlay(int card_number) {
        int[] cards_indicies;

        // The card_number will be -1 if any card can be played
        if (card_number != -1) {
            int count = haveCardInHand(card_number);
            int count_below = haveCardInHand(card_number - 1);
            int count_above = haveCardInHand(card_number + 1);

            if (count != 0) {
                cards_indicies = getCardIndicies(card_number, count);
                return cards_indicies;
            }
            else if (count_below != 0){
                cards_indicies = getCardIndicies(card_number - 1, count_below);
                return cards_indicies;
            }
            else if(count_above != 0){
                cards_indicies = getCardIndicies(card_number + 1, count_above);
                return cards_indicies;
            }
            else{
                //Will need something here to validate lie
                return getLieCardsToPlay();
            }

        }
        //What happens if any card can be played
        else{
             return getLieCardsToPlay();
        }
    }

    private int[] getLieCardsToPlay(){

        Random rn = new Random();
        int card_number = rn.nextInt(13) + 1;

        int count = haveCardInHand(card_number);

        if (count != 0){
            return getCardIndicies(card_number, count);
        }

        else{
            if(getHand().getSize() > 4) {
                count = rn.nextInt(4) + 1;
            }
            else{
                count = rn.nextInt(getHand().getSize()) + 1;
            }
            int[] card_indicies = new int[count];
            for (int i = 0; i < count; i++){
                card_indicies[i] = i;
            }
            return card_indicies;
        }
    }

}
