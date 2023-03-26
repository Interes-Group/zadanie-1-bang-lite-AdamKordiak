package sk.stuba.fei.uim.oop.cards.blueCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Random;

public class Prison extends IdentifiedCard {

    public Prison() {
        super.cardName = "Prison";
        super.cardColour = true; // blue colour
        super.cardCode = 2;

    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer, int choosedCard ) {
        int choosedPlayer;
        Random random = new Random();

        for(int i = 0;i < players.get(actualPlayer).getCardsPlayerDeckCount();i++) {

            if (players.get(actualPlayer).getCardInPlayerDeck(i).getCardCode() == 2) {
                int x = random.nextInt(4);

                System.out.println(",," + x + ",,");

                players.get(actualPlayer).removeBlueCardInPlayerDeck(playDeck,players.get(actualPlayer).getCardInPlayerDeck(i));

                if (x == 1) {
                    System.out.println(TextColours.ANSI_RED +"Player "+TextColours.ANSI_RESET + players.get(actualPlayer).getName() + TextColours.ANSI_RED + " stay in Prison." + TextColours.ANSI_RESET);
                    return true;
                }else{
                    System.out.println(TextColours.ANSI_RED +"Player "+TextColours.ANSI_RESET + players.get(actualPlayer).getName() + TextColours.ANSI_RED + " run from Prison." + TextColours.ANSI_RESET);

                    return false;
                }
            }
        }
        do {
            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.println(TextColours.ANSI_RED + "Whitch Player do you want put in Prison ?" + TextColours.ANSI_RESET);
            System.out.print("  ");
            for(int j = 0;j < players.size();j++){
                if(players.get(actualPlayer).equals(players.get(j))) {
                    System.out.print(TextColours.ANSI_WHITE +" " + players.get(j).getName()+ TextColours.ANSI_RESET);
                }
                else{
                    System.out.print(" " + players.get(j).getName());
                }
            }
            System.out.print("\n");
            players.get(actualPlayer).printLine(players.get(actualPlayer));

            choosedPlayer = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Choose player from (1," + players.size() + ")." + TextColours.ANSI_RESET);

        }while(!players.get(actualPlayer).checkInputRange(1, players.size(), choosedPlayer,actualPlayer,false));


        players.get(actualPlayer).addBlueCardInPlayerDeck2(players.get(actualPlayer),players.get(choosedPlayer-1),players.get(actualPlayer).getCardInHand(choosedCard-1));
        System.out.println(TextColours.ANSI_RED + "Player " + TextColours.ANSI_RESET +players.get(actualPlayer).getName() + TextColours.ANSI_RED +" put Player " + TextColours.ANSI_RESET + players.get(choosedPlayer-1).getName() + TextColours.ANSI_RED + " in Prison." + TextColours.ANSI_RESET );

        return false;

    }


}
