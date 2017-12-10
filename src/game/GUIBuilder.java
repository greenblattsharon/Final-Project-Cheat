package game;

import card.AbstractGroupOfCardsFactory;
import card.GroupOfCards;
import player.AbstractPlayerFactory;
import player.Player;

public class GUIBuilder {

    public Player buildPlayer(AbstractPlayerFactory playerFactory, double intelligence){
        Player player = playerFactory.createPlayer(intelligence);
        return player;
    }

    public GroupOfCards buildGroupOfCards(AbstractGroupOfCardsFactory groupOfCardsFactory){
        GroupOfCards groupOfCards = groupOfCardsFactory.createGroupOfCards();
        return groupOfCards;
    }
}
