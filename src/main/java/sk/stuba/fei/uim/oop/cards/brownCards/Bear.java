package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;

public class Bear extends IdentifiedCard {

    public Bear() {

        super.cardName = "Bear";
        super.cardColour = false; // brown colour
        super.cardCode = 5;


    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        players.get(actualPlayer).plusLive();
        System.out.print(TextColours.CYAN + "Player "+ TextColours.RESET + players.get(actualPlayer).getName()+ TextColours.CYAN + " drink a ");
        System.out.print(TextColours.YELLOW+"Bear"+TextColours.CYAN +". He have now "+ TextColours.RED + players.get(actualPlayer).getLivesNumber()+ TextColours.CYAN + " lives.\n" + TextColours.RESET);
        return true;
    }


}
