package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;

public class Barrel extends IdentifiedCard {

    public Barrel() {
        super.cardName = "Barrel";
        super.cardColour = true; // blue colour
        super.cardCode = 0;

    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        for(int i = 0;i < players.get(actualPlayer).getCardsPlayerDeckCount();i++) {
            if (players.get(actualPlayer).getCardInPlayerDeck(i).getCardCode() == 0) {
                System.out.print(TextColours.RED + "You already have this card.\n" + TextColours.RESET);
                return false;
            }
        }

        players.get(actualPlayer).addBlueCardInPlayerDeck(players.get(actualPlayer),players.get(actualPlayer).getCardInHand(choosedCard-1));
        System.out.print(TextColours.CYAN + "Player " + TextColours.RESET + players.get(actualPlayer).getName() + TextColours.CYAN + " put a card ");
        System.out.println(TextColours.BLUE + "Barrel" + TextColours.CYAN + " in front of him on Deck. " + TextColours.RESET);
        return false;

    }
}



