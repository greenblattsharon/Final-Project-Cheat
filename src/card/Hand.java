package card;

import java.util.ArrayList;

public class Hand extends GroupOfCards {

    public void printCards(){
        ArrayList<Card> cards = getCards();
        for(int i = 0; i < cards.size(); i++){
            System.out.println("Index: " + i + " Number: " + cards.get(i).getNumber() + " Suit: " + cards.get(i).getSuit());
        }
    }
}
