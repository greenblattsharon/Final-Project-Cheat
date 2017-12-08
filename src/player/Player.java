package player;

import card.Card;
import card.Hand;

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

    public abstract int[] getCardsToPlay();

}
