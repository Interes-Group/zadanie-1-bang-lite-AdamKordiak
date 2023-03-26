package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import java.util.ArrayList;
import java.util.Random;


public class Game {
    private final  ArrayList<Player> players;
    private PlayDeck playDeck;


    public Game() {
        this.players = new ArrayList<>();
        int numberOfPlayers;

        System.out.println(TextColours.GREEN + "\n\n                Welcome to Bang game.\n\n" + TextColours.RESET);

        do {
            numberOfPlayers = ZKlavesnice.readInt(" Enter number of players (2,4):");
        } while (!checkInputRange(2, 4, numberOfPlayers,false));

        for (int i = 0; i < numberOfPlayers; i++) {
            this.players.add(new Player(ZKlavesnice.readString(  " " + (i + 1) + ".PLAYER " + " name:")));
        }


        this.startGame();

    }
    private void startGame() {
        Random random = new Random();

        playDeck = new PlayDeck();
        playDeck.fillDeck();
        for (Player player : players) {
            for (int j = 0; j < player.getLivesNumber(); j++) {
                player.addCardInHand(playDeck);
            }
        }

        while(true){
            if(players.size() == 1){
                players.get(0).returnPlayerCards(playDeck, players.get(0));
                System.out.println(TextColours.GREEN +"\n\n                 Player "+players.get(0).getName()+ " is a winner." + TextColours.RESET);
                break;
            }

            for (int i = 0; i < players.size();i++) {
                boolean prisonStatement = false;

                for(int j = 0;j < players.get(i).getCardsPlayerDeckCount();j++) {

                    if (players.get(i).getCardInPlayerDeck(j).getCardCode() == 1) {
                        players.get(i).getCardInPlayerDeck(j).useCard(playDeck, players, i, j);
                    }
                }
                if(players.get(i).getLivesNumber() > 0) {
                    for (int j = 0; j < players.get(i).getCardsPlayerDeckCount(); j++) {
                        if (players.get(i).getCardInPlayerDeck(j).getCardCode() == 2) {
                            if (players.get(i).getCardInPlayerDeck(j).useCard(playDeck, players, i, j)) {
                                prisonStatement = true;
                            }
                        }
                    }
                }
                for(int k = 0; k < 4;k++){ //This "for" is for most acurate info about dead players
                    for(int j = 0; j < players.size();j++) {
                        if (players.get(j).getLivesNumber() <= 0) {
                            players.get(i).returnPlayerCards(playDeck, players.get(j));
                            players.remove(players.get(j));
                            if (j < i) {
                                i--;
                            }
                            break;
                        }
                    }
                }
                if(prisonStatement){
                    continue;
                }
                if(players.size() == 1){
                    break;
                }

                players.get(i).addCardInHand(playDeck);
                players.get(i).addCardInHand(playDeck);


                while (true) {
                    int choosedCard;

                    if(players.size() == 1){
                        break;
                    }
                    players.get(i).printPlayerPackage(players.get(i));
                    do {
                        if(players.get(i).getCardsInHandCount() == 0) {
                            choosedCard = ZKlavesnice.readInt(TextColours.CYAN + "Write '0' to exit your turn." + TextColours.RESET);
                        }else{
                            choosedCard = ZKlavesnice.readInt(TextColours.CYAN + "Whitch Card do you want play? Write from (1," + players.get(i).getCardsInHandCount() + ") or '0' to exit your turn." + TextColours.RESET);
                        }
                        } while (!checkInputRange(1,players.get(i).getCardsInHandCount(), choosedCard,true));

                    if (choosedCard == 0) {
                        while (removeCardFromHand(i)) {}
                        break;
                    }
                    if(players.get(i).getCardsInHandCount() == 0){
                        break;
                    }
                    //System.out.println(playDeck.getCardsCount());

                    if(players.get(i).getCardInHand(choosedCard - 1).useCard(playDeck,players, i, choosedCard)) {
                        players.get(i).removeCardInHand(playDeck, players.get(i).getCardInHand(choosedCard - 1));
                    }
                   // System.out.println(playDeck.getCardsCount());


                    for(int k = 0; k < 4;k++){ //This "for" is for most acurate info about dead players
                        for(int j = 0; j < players.size();j++) {
                            if (players.get(j).getLivesNumber() <= 0) {
                                players.get(i).returnPlayerCards(playDeck, players.get(j));
                                players.remove(players.get(j));
                                if (j < i) {
                                    i--;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean removeCardFromHand(int i) {

        int choosedDeletedCard;
        do {
            if (players.get(i).getCardsInHandCount() == 0) {
                return false;
            }
            if (players.get(i).getCardsInHandCount() <= players.get(i).getLivesNumber()) {
                return false;
            }

            System.out.println(TextColours.RED + "             You have more cards than lives." + TextColours.RESET);
            players.get(i).printLine(players.get(i));

            players.get(i).cardsInPlayerHands(players.get(i));

            choosedDeletedCard = ZKlavesnice.readInt(TextColours.CYAN + "Whitch card do you want to remove ? Write from (1," + players.get(i).getCardsInHandCount() + ")." + TextColours.RESET);

        } while (!players.get(i).checkInputRange(1, players.get(i).getCardsInHandCount(), choosedDeletedCard, 100, false));

        if (players.get(i).getCardInHand(choosedDeletedCard - 1).getCardColour()) {
            System.out.print(TextColours.CYAN + "You remove " + TextColours.BLUE + players.get(i).getCardInHand(choosedDeletedCard - 1).getCardName() + TextColours.CYAN + " card.\n" + TextColours.RESET);
        } else {
            System.out.print(TextColours.CYAN + "You remove " + TextColours.YELLOW + players.get(i).getCardInHand(choosedDeletedCard - 1).getCardName() + TextColours.CYAN + " card.\n" + TextColours.RESET);

        }

        players.get(i).removeCardInHand(playDeck, players.get(i).getCardInHand(choosedDeletedCard - 1));


        return players.get(i).getCardsInHandCount() >= players.get(i).getLivesNumber();

    }
    public boolean checkInputRange ( int rangeStart, int rangeEnd, int number,boolean troll){
        if(troll) {
            if (number == 0) {
                return true;
            }
        }
        if (number >= rangeStart && number <= rangeEnd ) {
            return true;
        }
        System.out.println(TextColours.RED + "             Wrong input" + TextColours.RESET);
        return false;
    }
    }


