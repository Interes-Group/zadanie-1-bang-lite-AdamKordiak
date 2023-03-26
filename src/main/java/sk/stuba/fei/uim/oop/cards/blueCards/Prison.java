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
        int playersInPrison = 0;

        for(int i = 0;i < players.get(actualPlayer).getCardsPlayerDeckCount();i++) {

            if (players.get(actualPlayer).getCardInPlayerDeck(i).getCardCode() == 2) {
                int x = random.nextInt(4);

                players.get(actualPlayer).removeBlueCardInPlayerDeck(playDeck,players.get(actualPlayer).getCardInPlayerDeck(i));

                if (x == 1) {
                    System.out.println(TextColours.RED +"Player "+TextColours.RESET + players.get(actualPlayer).getName() + TextColours.RED + " stay in Prison." + TextColours.RESET);
                    return true;
                }else{
                    System.out.println(TextColours.RED +"Player "+TextColours.RESET + players.get(actualPlayer).getName() + TextColours.RED + " run from Prison." + TextColours.RESET);

                    return false;
                }
            }
        }

        for(int i = 0;i <players.size(); i++) {
            for (int j = 0; j < players.get(i).getCardsPlayerDeckCount(); j++) {
                if (players.get(i).getCardInPlayerDeck(j).getCardCode() == 2) {
                    playersInPrison++;
                    break;

                }
            }
        }
        if(playersInPrison == players.size()-1 ){
            System.out.print(TextColours.RED + "You can't use this card.\n" + TextColours.RESET);
            System.out.print(TextColours.RED + "All players are in Prison right now.\n" + TextColours.RESET);
            return false;

        }
        do {
            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.print(TextColours.RED + "Whitch Player do you want put in Prison ?\n   " + TextColours.RESET);


            for(int j = 0;j < players.size();j++){
                if(players.get(actualPlayer).equals(players.get(j))) {
                    System.out.print(TextColours.WHITE +"  " + players.get(j).getName()+ TextColours.RESET);
                }
                else{
                    System.out.print("  " + players.get(j).getName());
                }
            }
            System.out.print("\n");
            players.get(actualPlayer).printLine(players.get(actualPlayer));

            choosedPlayer = ZKlavesnice.readInt(TextColours.CYAN + "Choose player from (1," + players.size() + ")." + TextColours.RESET);

        }while(!checkInputRange(1, players.size(), choosedPlayer,actualPlayer,players));


        players.get(actualPlayer).addBlueCardInPlayerDeck2(players.get(actualPlayer),players.get(choosedPlayer-1),players.get(actualPlayer).getCardInHand(choosedCard-1));
        System.out.println(TextColours.RED + "Player " + TextColours.RESET +players.get(actualPlayer).getName() + TextColours.RED +" put Player " + TextColours.RESET + players.get(choosedPlayer-1).getName() + TextColours.RED + " in Prison." + TextColours.RESET );

        return false;

    }
    public boolean checkInputRange ( int rangeStart, int rangeEnd, int choosedPlayer, int actualPlayer, ArrayList<Player> players){

        if (choosedPlayer >= rangeStart && choosedPlayer <= rangeEnd && actualPlayer != choosedPlayer-1) {
            for (int i = 0; i < players.get(choosedPlayer - 1).getCardsPlayerDeckCount(); i++) {
                if (players.get(choosedPlayer - 1).getCardInPlayerDeck(i).getCardCode() == 2) {
                    System.out.println(TextColours.RED + "Player " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.RED + " is actually in Prison.");
                    return false;
                }
            }
            return true;
        }
        System.out.println(TextColours.RED + "             Wrong input" + TextColours.RESET);
        return false;
    }


}
