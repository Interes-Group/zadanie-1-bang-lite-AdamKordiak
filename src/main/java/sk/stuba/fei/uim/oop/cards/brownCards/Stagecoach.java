package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Player;

public class Stagecoach extends IdentifiedCard {

    private Player[] players;
    private int playerNumber;

    public Stagecoach() {
        super.cardName = "Stagecoach";
        super.cardColour = false; // brown colour
        super.cardCode = 7;


    }

    public void useCard(){
    }


}
