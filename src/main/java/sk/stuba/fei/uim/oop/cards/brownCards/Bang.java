package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Random;

public class Bang extends IdentifiedCard {

    public Bang() {

        super.cardName = "Bang";
        super.cardColour = false; // brown colour
        super.cardCode = 3;

    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        int choosedPlayer;
        Random random = new Random();
        boolean haveMissedCard = false;
        boolean haveBarrelCard = false;


        do {
            players.get(actualPlayer).printLine(players.get(actualPlayer));
            System.out.println(TextColours.ANSI_RED + "Whitch Player do you want Attack with Bang ?" + TextColours.ANSI_RESET);
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

       /* System.out.println(players.get(choosedPlayer-1).getName());
        for(int j = 0;j < players.get(choosedPlayer-1).getCardsInHandCount();j++) {
            System.out.print(" "+players.get(choosedPlayer-1).getCardInHand(j).getCardName());
        }
        System.out.print("\n");*/

        for(int findBarrelCard = 0; findBarrelCard < players.get(choosedPlayer-1).getCardsPlayerDeckCount() ; findBarrelCard++) {
            if(players.get(choosedPlayer-1).getCardInPlayerDeck(findBarrelCard).getCardCode() == 0){
                haveBarrelCard = true;
                break;
            }
        }

        for(int findMissedCard = 0;findMissedCard < players.get(choosedPlayer-1).getCardsInHandCount();findMissedCard++) {

            if(players.get(choosedPlayer-1).getCardInHand(findMissedCard).getCardCode() == 4){

                int x = random.nextInt(4);
                if(x == 0) {
                    players.get(choosedPlayer - 1).removeCardInHand(playDeck, players.get(choosedPlayer - 1).getCardInHand(findMissedCard));
                    haveMissedCard = true;
                    break;
                }
            }
        }
/*
        for(int j = 0;j < players.get(choosedPlayer-1).getCardsInHandCount();j++) {
            System.out.print(" " + players.get(choosedPlayer-1).getCardInHand(j).getCardName());
        }
        System.out.print("\n");*/

        if(haveMissedCard){

            System.out.print(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " automatically used " + TextColours.ANSI_YELLOW + "Missed" + TextColours.ANSI_CYAN + " card. He still have "+ TextColours.ANSI_RED + players.get(choosedPlayer - 1).getLivesNumber()+  TextColours.ANSI_CYAN + " lives.\n" + TextColours.ANSI_RESET);

        }else if(haveBarrelCard){
            System.out.print(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " automatically used " + TextColours.ANSI_BLUE + "Barrel" + TextColours.ANSI_CYAN + " card. He still have "+ TextColours.ANSI_RED + players.get(choosedPlayer - 1).getLivesNumber()+  TextColours.ANSI_CYAN + " lives.\n" + TextColours.ANSI_RESET);

        }
        else {
            players.get(choosedPlayer - 1).minusLive();

            if(players.get(choosedPlayer - 1).getLivesNumber() == 0){
                System.out.print(TextColours.ANSI_RED + "                    Player " + players.get(choosedPlayer - 1).getName() + " is dead. \n" + TextColours.ANSI_RESET);
            }else {
                System.out.print(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " have now " + TextColours.ANSI_RED + players.get(choosedPlayer - 1).getLivesNumber() + TextColours.ANSI_CYAN + " lives.\n" + TextColours.ANSI_RESET);
            }
        }
        return true;
        }







}
