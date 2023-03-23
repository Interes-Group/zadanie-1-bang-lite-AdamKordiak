package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Missed extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public Missed() {

        super.cardName = "Missed";
        super.cardColour = false; // brown colour
        super.cardCode = 4;

    }

    public void useCard(){
    }


}
