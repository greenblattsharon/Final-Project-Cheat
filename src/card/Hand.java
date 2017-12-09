package card;

import java.util.ArrayList;

public class Hand extends GroupOfCards {

    public void printCards(){
        ArrayList<Card> cards = getCards();
        for(Card card: cards){
            System.out.println("Number: " + card.getNumber() + "Suit: " + card.getSuit());
        }
    }
}
