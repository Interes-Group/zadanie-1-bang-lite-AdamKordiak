package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;
import java.util.Random;

public class Dynamite extends IdentifiedCard {

    public Dynamite() {
        super.cardName = "Dynamit";
        super.cardColour = true; // blue colour
        super.cardCode = 1;



    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        Random random = new Random();

        for(int i = 0;i < players.get(actualPlayer).getCardsPlayerDeckCount();i++) {
            if (players.get(actualPlayer).getCardInPlayerDeck(i).getCardCode() == 1) {
                int x = random.nextInt(8);


                if (x == 1) {
                    players.get(actualPlayer).minusLive();
                    players.get(actualPlayer).minusLive();
                    players.get(actualPlayer).minusLive();

                    players.get(actualPlayer).removeBlueCardInPlayerDeck(playDeck, players.get(actualPlayer).getCardInPlayerDeck(i));

                    if(players.get(actualPlayer).getLivesNumber() > 0) {
                        System.out.println(TextColours.RED + "Dynamit explode to " + players.get(actualPlayer).getName() + ". He have now " + players.get(i).getLivesNumber() + " lives. " + TextColours.RESET);
                    }else {
                        System.out.println(TextColours.RED + "                  Dynamit explode to " + players.get(actualPlayer).getName() + ". " + TextColours.RESET);
                        System.out.print(TextColours.RED + "                    Player " + players.get(actualPlayer).getName() + " is dead. \n" + TextColours.RESET);

                    }
                    return true;

                } else {
                    System.out.print(TextColours.CYAN + "Dynamit don't explode to " +TextColours.RESET + players.get(actualPlayer).getName() +TextColours.CYAN + ". Player "+TextColours.RESET);

                    if (actualPlayer == 0) {
                        players.get(actualPlayer).removeDynamitToBefourPlayer(players.get(actualPlayer), players.get(actualPlayer).getCardInPlayerDeck(i));
                        actualPlayer = players.size() - 1;
                        players.get(actualPlayer).addDynamitToBefourPlayer(players.get(actualPlayer));
                        System.out.print(players.get(actualPlayer).getName() +TextColours.CYAN + " have now "+TextColours.BLUE +"Dynamite. \n"+TextColours.RESET);
                        return false;


                    } else {
                        players.get(actualPlayer).addDynamitToBefourPlayer(players.get(actualPlayer - 1));
                        System.out.print(players.get(actualPlayer - 1 ).getName() +TextColours.CYAN + " have now "+TextColours.BLUE +"Dynamite. \n"+TextColours.RESET);

                        players.get(actualPlayer).removeDynamitToBefourPlayer(players.get(actualPlayer), players.get(actualPlayer).getCardInPlayerDeck(i));
                        return false;
                    }
                }

            }


        }
        players.get(actualPlayer).addBlueCardInPlayerDeck(players.get(actualPlayer),players.get(actualPlayer).getCardInHand(choosedCard-1));

        return false;
    }


}



