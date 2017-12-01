package card;

public class Deck extends GroupOfCards {

    public void initializeDeck() throws IllegalCardException {
        for(Suit suit: Suit.values()){
            for(int i = 1; i < 14; i++){
                addCard(new Card(i, suit));
            }
        }

    }
}
