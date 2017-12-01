package card;

public class Card {

    public final static int ACE = 1,          // Codes for the non-numeric cards.
                            JACK = 11,        //   Cards 2 through 10 have their
                            QUEEN = 12,       //   numerical values for their codes.
                            KING = 13;

    private int number;
    private Suit suit;

    public Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }
}
