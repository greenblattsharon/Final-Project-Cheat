package card;

import java.util.ArrayList;
import java.util.Collections;

public abstract class GroupOfCards {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private int size = 0;

    public void removeCard(Card card) throws IllegalCardException {
        int location = findCard(card);
        if (isItEmpty()) {
            throw new IllegalCardException("There are no cards in this deck");
        } else {
            if (location == -1) {
                throw new IllegalCardException("This card is not in this deck: " + card.getSuit() + " " + card.getNumber());
            } else {
                cards.remove(location);
                size--;
            }
        }
    }

    public void addCard(Card card) throws IllegalCardException {
        int location = findCard(card);
        if (location != -1) {
            throw new IllegalCardException("This card is already in the deck: " + card.getSuit() + " " + card.getNumber());
        }

        cards.add(card);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isItEmpty() {
        return getSize() == 0;
    }

    private int findCard(Card card) {
        Card test_card;
        int i = 0;
        int location = -1;
        while (i < size) {
            test_card = cards.get(i);
            if (test_card.getNumber() == card.getNumber() && test_card.getSuit().equals(card.getSuit())) {
                location = i;
            }
            i++;
        }

        return location;
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void removeAll(){
        cards.removeAll(cards);
        size = 0;
    }

}
