package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;

public class Missed extends IdentifiedCard {

    public Missed() {

        super.cardName = "Missed";
        super.cardColour = false; // brown colour
        super.cardCode = 4;

    }

    //Usage of Missed card works automatically.
    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        System.out.print(TextColours.RED + "You can't use this card.\n" + TextColours.RESET);
        return false;
    }


}
