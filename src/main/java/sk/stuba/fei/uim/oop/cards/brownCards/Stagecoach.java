package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;

public class Stagecoach extends IdentifiedCard {

    public Stagecoach() {
        super.cardName = "Stagecoach";
        super.cardColour = false; // brown colour
        super.cardCode = 7;


    }
    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        System.out.print(TextColours.CYAN + "Player "+TextColours.RESET + players.get(actualPlayer).getName() + TextColours.CYAN +" used "+ TextColours.YELLOW +"Stagecoach" +TextColours.CYAN+ " card.\n" + TextColours.RESET);

        players.get(actualPlayer).addCardInHand(playDeck);
        players.get(actualPlayer).addCardInHand(playDeck);
        return true;
    }


}
