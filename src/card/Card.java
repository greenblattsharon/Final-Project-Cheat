package card;

public class Card implements Comparable<Card>{

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

    // This method allows for an array to be sorted by number in ascending order
    public int compareTo(Card compareCard){
        int compareNumber = compareCard.getNumber();

        return this.number - compareNumber;
    }
}
