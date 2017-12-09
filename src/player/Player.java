package player;

import card.Card;
import card.Hand;

import java.util.ArrayList;

public abstract class Player {

    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public boolean callCheat(){
        return true;
    }

    public Card[] playCards(int[] index){

        return null;
    }

    public abstract int[] getCardsToPlay(int card_number);

    public int[] getCardIndicies(int card_number, int count){
        int[] cards_indicies = new int[count];
        int counter = 0;
        ArrayList<Card> cards = hand.getCards();

        for (int i = 0; i < hand.getSize(); i++) {
            if (cards.get(i).getNumber() == card_number) {
                cards_indicies[counter] = i;
                counter++;
            }
        }
        return cards_indicies;
    }

}
