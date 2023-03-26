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
            System.out.println(TextColours.RED + "Whitch Player do you want take a card ?\n   " + TextColours.RESET);

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

        }while(!players.get(actualPlayer).checkInputRange(1, players.size(), choosedPlayer,actualPlayer,false));


        if(players.get(choosedPlayer-1).getCardsInHandCount() == 0 && players.get(choosedPlayer-1).getCardsPlayerDeckCount() == 0 ){
            System.out.print(TextColours.RED + "You can't use this card.\n" + TextColours.RESET);
            System.out.print(TextColours.RED + "Player " + players.get(choosedPlayer-1).getName() +" don't have any card.\n" + TextColours.RESET);
            return false;
        }
        do {

            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.println(TextColours.RED + "From Whitch package do you want take a card ?" + TextColours.RESET);

            if(players.get(choosedPlayer-1).getCardsPlayerDeckCount() > 0) {
                System.out.println("1: "+players.get(choosedPlayer - 1).getName() + "'s cards on deck.");
            }else{
                System.out.println(TextColours.WHITE + "1: ("+players.get(choosedPlayer - 1).getName() + "'s cards on deck is empty)" + TextColours.RESET);
            }
            if(players.get(choosedPlayer-1).getCardsInHandCount() > 0) {
                System.out.println("2: "+players.get(choosedPlayer-1).getName() +"'s cards on hand.");
            }else {
                System.out.println(TextColours.WHITE + "2: ("+players.get(choosedPlayer - 1).getName() + "'s cards on hand is empty)" + TextColours.RESET);
            }

            players.get(actualPlayer).printLine(players.get(actualPlayer));

            choosedPackage = ZKlavesnice.readInt(TextColours.CYAN + "Choose package from (1,2)." + TextColours.RESET);

        }while(!checkInputRange(1, 2, choosedPackage,players.get(choosedPlayer-1)));


        if(choosedPackage == 1){
            int x = random.nextInt(players.get(choosedPlayer-1).getCardsPlayerDeckCount());

            System.out.println(TextColours.CYAN + "Player " +TextColours.RESET + players.get(actualPlayer).getName() + TextColours.CYAN +" remove " + TextColours.BLUE + players.get(choosedPlayer-1).getCardInPlayerDeck(x).getCardName() + TextColours.CYAN +" card from " + TextColours.RESET + players.get(choosedPlayer-1).getName()+ TextColours.CYAN +" deck. " + TextColours.RESET );
            players.get(choosedPlayer-1).removeBlueCardInPlayerDeck(playDeck,players.get(choosedPlayer-1).getCardInPlayerDeck(x));
        }
        if(choosedPackage == 2){
            int x = random.nextInt(players.get(choosedPlayer-1).getCardsInHandCount());

            if(!players.get(choosedPlayer-1).getCardInHand(x).getCardColour()) {
                System.out.println(TextColours.CYAN + "Player " + TextColours.RESET + players.get(actualPlayer).getName() + TextColours.CYAN + " remove " + TextColours.YELLOW + players.get(choosedPlayer - 1).getCardInHand(x).getCardName() + TextColours.CYAN + " card from " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.CYAN + " hands. " + TextColours.RESET);
            }else {
                System.out.println(TextColours.CYAN + "Player " +TextColours.RESET + players.get(actualPlayer).getName() + TextColours.CYAN + " remove " + TextColours.BLUE + players.get(choosedPlayer - 1).getCardInHand(x).getCardName() + TextColours.CYAN + " card from " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.CYAN + " hands. " + TextColours.RESET);
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
        System.out.println(TextColours.RED + "             Wrong input" + TextColours.RESET);
        return false;
    }




}
