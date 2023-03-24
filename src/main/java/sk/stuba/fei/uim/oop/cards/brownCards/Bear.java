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
        System.out.print(TextColours.ANSI_CYAN + "Player "+ TextColours.ANSI_RESET + players.get(actualPlayer).getName()+ TextColours.ANSI_CYAN+" drink a ");
        System.out.print(TextColours.ANSI_YELLOW+"Bear"+TextColours.ANSI_CYAN +". He have now "+ TextColours.ANSI_RED + players.get(actualPlayer).getLivesNumber()+ TextColours.ANSI_CYAN+" lives.\n" + TextColours.ANSI_RESET);
        return true;
    }


}
