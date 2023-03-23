package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Dynamit extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public Dynamit() {
        super.cardName = "Dynamit";
        super.cardColour = true; // blue colour
        super.cardCode = 1;



    }

    public void useCard(){

    }


}
