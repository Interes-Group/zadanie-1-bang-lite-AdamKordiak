package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class CatBalou extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public CatBalou() {
        super.cardName = "CatBalou";
        super.cardColour = false; // brown colour
        super.cardCode = 6;


    }

    public void useCard(){
    }


}
