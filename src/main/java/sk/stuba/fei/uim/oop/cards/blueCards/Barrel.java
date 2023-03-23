package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Barrel extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;
    private boolean cardColour;

    public Barrel() {
        super.cardName = "Barrel";
        super.cardColour = true; // blue colour
        super.cardCode = 0;



    }

    public void useCard(){
    }


}
