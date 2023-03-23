package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Player {

    private final String name;
    private int livesNumber;
    private ArrayList<IdentifiedCard> blueCardsInPlayerDeck;
    private ArrayList<IdentifiedCard> cardsInHand;



    public Player(String name) {

        this.name = name;
        this.livesNumber = 4;
        this.blueCardsInPlayerDeck = new ArrayList<>();
        this.cardsInHand = new ArrayList<>();

    }



    public String getName() { return name; }

    public int getLivesNumber() { return livesNumber; }

    public void minusLive() { this.livesNumber--; }

    public void plusLive() { this.livesNumber++; }

    public IdentifiedCard getCardInHand(int i) { return cardsInHand.get(i); }

    public IdentifiedCard getCardInPlayerDeck(int i) { return blueCardsInPlayerDeck.get(i); }

    public int getCardsInHandCount() { return cardsInHand.size(); }
    public int getCardsPlayerDeck() { return blueCardsInPlayerDeck.size(); }

    public void addCardInHand(PlayDeck playDeck){
        cardsInHand.add(playDeck.getCard(0));
        playDeck.removeCard(0);
    }

    public void removeCardInHand(PlayDeck playDeck,IdentifiedCard card){
        playDeck.addCard(card);
        cardsInHand.remove(card);

    }
    public void addBlueCardInPlayerDeck(Player player1,int i){
        player1.blueCardsInPlayerDeck.add(cardsInHand.get(i));
        cardsInHand.remove(i);
    }
    public void removeBlueCardInPlayerDeck(PlayDeck playDeck,IdentifiedCard card){
        playDeck.addCard(card);
        blueCardsInPlayerDeck.remove(card);
    }
    public void printPlayerPackage(Player player){

        System.out.println("\n" + TextColours.ANSI_CYAN + "----------------------It is "+ TextColours.ANSI_RESET + getName() + TextColours.ANSI_CYAN + " turn.---------------------- " + TextColours.ANSI_RESET);
        for (int i = 0; i< getName().length()/2;i++){
            System.out.print(" ");
        }
        System.out.println(TextColours.ANSI_CYAN + "                    You have "+ TextColours.ANSI_RED + getLivesNumber() + TextColours.ANSI_CYAN + " lives. " + TextColours.ANSI_RESET);


        //Cards in front of Player on Deck
        cardsInPlayerDeck(player);

        //Cards in Player hands
        System.out.println("     Cards in Player hands ");
        System.out.print("  ");
        cardsInPlayerHands(player);


    }    public void cardsInPlayerDeck(Player player) {
        System.out.println("     Cards in front of Player on Deck");

        if(player.blueCardsInPlayerDeck.size() == 0) {
            System.out.println(TextColours.ANSI_WHITE + "     (Empty jet) " + TextColours.ANSI_RESET);
        }else {
            for (int i = 0; i < player.blueCardsInPlayerDeck.size(); i++) {

                System.out.print(TextColours.ANSI_BLUE + "  " + player.getCardInHand(i).getCardName() + TextColours.ANSI_RESET);

            }
        }

    }
        public void cardsInPlayerHands(Player player){
            if(player.getCardsInHandCount() == 0) {
                System.out.println(TextColours.ANSI_WHITE + "   (Empty jet) " + TextColours.ANSI_RESET);
            }else {

                for (int i = 0; i < player.cardsInHand.size(); i++) {

                    if (!player.getCardInHand(i).getCardColour()) {
                        System.out.print(TextColours.ANSI_YELLOW + "   " + player.getCardInHand(i).getCardName() + TextColours.ANSI_RESET);
                    } else
                        System.out.print(TextColours.ANSI_BLUE + "   " + player.getCardInHand(i).getCardName() + TextColours.ANSI_RESET);

                }
                System.out.print("\n");
            }

            printline(player);

    }

    public void printline(Player player){
        System.out.print(TextColours.ANSI_CYAN + "--------------------------------------------------------" + TextColours.ANSI_RESET);
        for (int j = 0; j< player.getName().length();j++){
            System.out.print(TextColours.ANSI_CYAN + "-" + TextColours.ANSI_RESET);
        }
        System.out.print("\n");
    }
    public void returnPlayerCards(PlayDeck playDeck,Player player){
        int countHand = player.getCardsInHandCount();
        int countDeck = player.getCardsPlayerDeck();
        for(int j = 0;j < countHand;j++) {
            player.removeCardInHand(playDeck, player.getCardInHand(0));
        }
        for(int j = 0;j < countDeck;j++) {
            player.removeCardInHand(playDeck, player.getCardInPlayerDeck(0));
        }

    }
    }







