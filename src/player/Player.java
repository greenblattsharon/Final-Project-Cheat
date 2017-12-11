package player;

import card.Card;
import card.Hand;
import card.IllegalCardException;

import java.util.ArrayList;

public abstract class Player {

    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public abstract boolean callCheat(int last_card, int multiple) throws IllegalMoveException;

    public Card[] playCards(int[] index) throws IllegalCardException {

        Card[] cards = new Card[index.length];

        for (int i = 0; i < index.length; i++) {
            cards[i] = hand.getCards().get(index[i]);
        }

        for (Card card : cards) {
            hand.removeCard(card);
        }

        return cards;
    }

    public int[] getCardIndices(int card_number, int count) {
        int[] cards_indices = new int[count];
        int counter = 0;
        ArrayList<Card> cards = hand.getCards();

        for (int i = 0; i < hand.getSize(); i++) {
            if (cards.get(i).getNumber() == card_number) {
                cards_indices[counter] = i;
                counter++;
            }
        }
        return cards_indices;
    }

    public abstract int[] getCardsToPlay(int last_card);

}
