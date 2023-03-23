package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Indians extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public Indians() {

        super.cardName = "Indians";
        super.cardColour = false; // brown colour
        super.cardCode = 8;


    }

    public void useCard(){
  }


}
