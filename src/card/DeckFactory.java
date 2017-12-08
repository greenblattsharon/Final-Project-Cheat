package card;

public class DeckFactory implements AbstractGroupOfCardsFactory {

    @Override
    public Deck createGroupOfCards(){
        Deck groupOfCards = new Deck();
        return groupOfCards;
    }
}
