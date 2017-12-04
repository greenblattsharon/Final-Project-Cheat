package card;

import player.Player;

import java.util.ArrayList;

public class Deck extends GroupOfCards {

    private final static int SIZE_OF_DECK = 52;

    public void initializeDeck() throws IllegalCardException {
        for(Suit suit: Suit.values()){
            for(int i = 1; i < 14; i++){
                addCard(new Card(i, suit));
            }
        }
    }

    public void dealCards(Player[] players) throws IllegalCardException {
        shuffleCards();
        int counter = 0;
        Card card;
        ArrayList<Card> cards = getCards();

        while(getSize() != 0){
            card = cards.get(0);
            players[counter].getHand().addCard(card);
            removeCard(card);
            counter++;

            if (counter >= players.length){
                counter = 0;
            }
        }
    }
}
