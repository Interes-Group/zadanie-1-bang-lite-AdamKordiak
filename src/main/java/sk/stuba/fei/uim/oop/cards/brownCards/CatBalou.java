package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Random;

public class CatBalou extends IdentifiedCard {

    public CatBalou() {
        super.cardName = "CatBalou";
        super.cardColour = false; // brown colour
        super.cardCode = 6;

    }
    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        int choosedPlayer;
        int choosedPackage;
        Random random = new Random();

        do {
            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.println(TextColours.ANSI_RED + "Whitch Player do you want take a card ?" + TextColours.ANSI_RESET);
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


        if(players.get(choosedPlayer-1).getCardsInHandCount() == 0 && players.get(choosedPlayer-1).getCardsPlayerDeckCount() == 0 ){
            System.out.print(TextColours.ANSI_RED + "You can't use this card.\n" + TextColours.ANSI_RESET);
            System.out.print(TextColours.ANSI_RED + "Player " + players.get(choosedPlayer-1).getName() +" don't have any card.\n" + TextColours.ANSI_RESET);
            return false;
        }
        do {

            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.println(TextColours.ANSI_RED + "From Whitch package do you want take a card ?" + TextColours.ANSI_RESET);

            if(players.get(choosedPlayer-1).getCardsPlayerDeckCount() > 0) {
                System.out.println("1: "+players.get(choosedPlayer - 1).getName() + "'s cards on deck.");
            }else{
                System.out.println(TextColours.ANSI_WHITE + "1: ("+players.get(choosedPlayer - 1).getName() + "'s cards on deck is empty)" + TextColours.ANSI_RESET);
            }
            if(players.get(choosedPlayer-1).getCardsInHandCount() > 0) {
                System.out.println("2: "+players.get(choosedPlayer-1).getName() +"'s cards on hand.");
            }else {
                System.out.println(TextColours.ANSI_WHITE + "2: ("+players.get(choosedPlayer - 1).getName() + "'s cards on hand is empty)" + TextColours.ANSI_RESET);
            }

            players.get(actualPlayer).printLine(players.get(actualPlayer));

            choosedPackage = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Choose package from (1,2)." + TextColours.ANSI_RESET);

        }while(!checkInputRange(1, 2, choosedPackage,players.get(choosedPlayer-1)));


        if(choosedPackage == 1){
            int x = random.nextInt(players.get(choosedPlayer-1).getCardsPlayerDeckCount());

            System.out.println(TextColours.ANSI_CYAN + "Player " +TextColours.ANSI_RESET + players.get(actualPlayer).getName() + TextColours.ANSI_CYAN +" remove " + TextColours.ANSI_BLUE + players.get(choosedPlayer-1).getCardInPlayerDeck(x).getCardName() + TextColours.ANSI_CYAN +" card from " + TextColours.ANSI_RESET + players.get(choosedPlayer-1).getName()+ TextColours.ANSI_CYAN +" deck. " + TextColours.ANSI_RESET );
            players.get(choosedPlayer-1).removeBlueCardInPlayerDeck(playDeck,players.get(choosedPlayer-1).getCardInPlayerDeck(x));
        }
        if(choosedPackage == 2){
            int x = random.nextInt(players.get(choosedPlayer-1).getCardsInHandCount());

            if(!players.get(choosedPlayer-1).getCardInHand(x).getCardColour()) {
                System.out.println(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(actualPlayer).getName() + TextColours.ANSI_CYAN + " remove " + TextColours.ANSI_YELLOW + players.get(choosedPlayer - 1).getCardInHand(x).getCardName() + TextColours.ANSI_CYAN + " card from " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " hands. " + TextColours.ANSI_RESET);
            }else {
                System.out.println(TextColours.ANSI_CYAN + "Player " +TextColours.ANSI_RESET + players.get(actualPlayer).getName() + TextColours.ANSI_CYAN + " remove " + TextColours.ANSI_BLUE + players.get(choosedPlayer - 1).getCardInHand(x).getCardName() + TextColours.ANSI_CYAN + " card from " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " hands. " + TextColours.ANSI_RESET);
            }
            players.get(choosedPlayer-1).removeCardInHand(playDeck,players.get(choosedPlayer-1).getCardInHand(x));
        }




        return true;
    }
    public boolean checkInputRange ( int rangeStart, int rangeEnd, int playerNumber, Player player){

        if (playerNumber == rangeStart && player.getCardsPlayerDeckCount() > 0) {
            return true;
        }else if(playerNumber == rangeEnd && player.getCardsInHandCount() > 0){
            return true;
        }
        System.out.println(TextColours.ANSI_RED + "             Wrong input" + TextColours.ANSI_RESET);
        return false;
    }




}
