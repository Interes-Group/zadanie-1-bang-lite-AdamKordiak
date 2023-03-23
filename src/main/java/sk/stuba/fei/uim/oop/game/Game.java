package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.cards.brownCards.Bang;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final  ArrayList<Player> players;
    private int numberOfPlayers;
    private PlayDeck playDeck;
    private int choosedCard;
    private int choosedDeletedCard;


    public Game() {
        this.players = new ArrayList<>();

        System.out.println(TextColours.ANSI_YELLOW + "\n\n                Welcome to Bang game.\n\n" + TextColours.ANSI_RESET);

        do {
            numberOfPlayers = ZKlavesnice.readInt("Enter number of players (2,4):");
        } while (!checkInputRange(2, 4, numberOfPlayers,false));

        for (int i = 0; i < numberOfPlayers; i++) {
            this.players.add(new Player(ZKlavesnice.readString( (i + 1) + ".PLAYER " + " name:")));
        }


        this.startGame();

    }
    private void startGame() {

        playDeck = new PlayDeck();
        playDeck.fillDeck();

        for (int i = 0; i < players.size();i++){
           for(int j = 0; j < getPlayer(i).getLivesNumber();j++) {
               getPlayer(i).addCardInHand(playDeck);
           }

        }

        while(true){
            for (int i = 0; i < players.size();i++) {

                getPlayer(i).addCardInHand(playDeck);
                getPlayer(i).addCardInHand(playDeck);


                while (true) {
                //    System.out.print(playDeck.getCardsCount());

                    getPlayer(i).printPlayerPackage(getPlayer(i));
                    do {
                        if(getPlayer(i).getCardsInHandCount() == 0) {
                            choosedCard = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Write '0' to exit your turn." + TextColours.ANSI_RESET);
                        }else{
                            choosedCard = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Whitch Card do you want play? Write from (1," + players.get(i).getCardsInHandCount() + ") or '0' to exit your turn." + TextColours.ANSI_RESET);
                        }
                        } while (!checkInputRange(1, getPlayer(i).getCardsInHandCount(), choosedCard, true));

                    if (choosedCard == 0) {
                        while (removeCardFromHand(i)) {
                        }
                        break;
                    }
                    if(getPlayer(i).getCardsInHandCount() == 0){
                        break;
                    }
                    getPlayer(i).getCardInHand(choosedCard - 1).useCard(playDeck,players, i);
                    getPlayer(i).removeCardInHand(playDeck, getPlayer(i).getCardInHand(choosedCard - 1));
                    for(int j = 0; j < players.size();j++) {
                        if(players.get(j).getLivesNumber() == 0 ) {
                            players.get(i).returnPlayerCards(playDeck, players.get(j));
                            players.remove(players.get(j));
                            if( j < i){
                                i--;
                            }
                        }
                    }
                }
            }
        }


    }
    public int getNumberOfPlayers(){return players.size();}
    public Player getPlayer(int i){return players.get(i);}

    private void printPlayersHealth() {
        System.out.println("\n\n-----------------------------Health");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(TextColours.ANSI_RED + getPlayer(i).getName() + TextColours.ANSI_RESET + " have " + TextColours.ANSI_RED + players.get(i).getLivesNumber() + TextColours.ANSI_RESET + " lives.");
        }
        System.out.println("-----------------------------Health\n");
    }
    private boolean checkInputRange ( int rangeStart, int rangeEnd, int number,boolean troll){
        if(troll) {
            if (number == 0) {
                return true;
            }
        }
        if (number >= rangeStart && number <= rangeEnd) {
            return true;
        }

        System.out.println(TextColours.ANSI_RED + "             Wrong input" + TextColours.ANSI_RESET);
        return false;
    }
    private boolean removeCardFromHand(int i){

            do {
                if(players.get(i).getCardsInHandCount() == 0){
                    return false;
                }
                if(players.get(i).getCardsInHandCount() <= players.get(i).getLivesNumber()){
                    return false;
                }
                players.get(i).printline(players.get(i));

                System.out.println("     Cards in " +players.get(i).getName() + " hands ");
                System.out.print("  ");
                players.get(i).cardsInPlayerHands(players.get(i));

                System.out.println(TextColours.ANSI_RED + "You have more cards than lives." + TextColours.ANSI_RESET);
                choosedDeletedCard = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Whitch card do you want to remove ? Write from (1," + players.get(i).getCardsInHandCount() + ")." + TextColours.ANSI_RESET);

            }while(!checkInputRange(1, players.get(i).getCardsInHandCount(), choosedDeletedCard, false));

            if(players.get(i).getCardInHand(choosedDeletedCard-1).getCardColour()) {
                System.out.println(TextColours.ANSI_CYAN + "You remove " +TextColours.ANSI_BLUE + players.get(i).getCardInHand(choosedDeletedCard - 1).getCardName() +TextColours.ANSI_CYAN + " card." + TextColours.ANSI_RESET);
            }else {
                System.out.println(TextColours.ANSI_CYAN + "You remove " +TextColours.ANSI_YELLOW + players.get(i).getCardInHand(choosedDeletedCard - 1).getCardName() +TextColours.ANSI_CYAN + " card." + TextColours.ANSI_RESET);

            }

        players.get(i).removeCardInHand(playDeck,players.get(i).getCardInHand(choosedDeletedCard-1));


        if (players.get(i).getCardsInHandCount() <= players.get(i).getLivesNumber()) {
            return false;
        }

        return true;
    }

    }

