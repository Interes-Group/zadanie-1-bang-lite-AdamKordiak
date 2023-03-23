package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Prison extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public Prison() {
        super.cardName = "Prison";
        super.cardColour = true; // blue colour
        super.cardCode = 2;



    }

    public void useCard(){
    }


}
