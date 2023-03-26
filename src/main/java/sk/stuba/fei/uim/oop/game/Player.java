package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.cards.blueCards.Dynamite;

import java.util.ArrayList;

public class Player {

    private final String name;
    private int livesNumber;
    private final ArrayList<IdentifiedCard> blueCardsInPlayerDeck;
    private final ArrayList<IdentifiedCard> cardsInHand;



    public Player(String name) {

        this.name = name;
        this.livesNumber = 1;
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
    public int getCardsPlayerDeckCount() { return blueCardsInPlayerDeck.size(); }

    public void addCardInHand(PlayDeck playDeck){
        cardsInHand.add(playDeck.getCard(0));
        playDeck.removeCard(0);
    }

    public void removeCardInHand(PlayDeck playDeck,IdentifiedCard card){
        playDeck.addCard(card);
        cardsInHand.remove(card);

    }
    public void addBlueCardInPlayerDeck(Player player1,IdentifiedCard card){
        player1.blueCardsInPlayerDeck.add(card);
        player1.cardsInHand.remove(card);
    }
    public void addBlueCardInPlayerDeck2(Player player1,Player player2,IdentifiedCard card){
        player2.blueCardsInPlayerDeck.add(card);
        player1.cardsInHand.remove(card);

    }
    public void addDynamitToBefourPlayer( Player player1){
        player1.blueCardsInPlayerDeck.add(new Dynamite());
    }

    public void removeDynamitToBefourPlayer( Player player1,IdentifiedCard card){
        player1.blueCardsInPlayerDeck.remove(card);

    }

    public void removeBlueCardInPlayerDeck(PlayDeck playDeck,IdentifiedCard card){
        playDeck.addCard(card);
        blueCardsInPlayerDeck.remove(card);
    }
    public void printPlayerPackage(Player player){

        System.out.println( TextColours.CYAN + "----------------------It is "+ TextColours.RESET + getName() + TextColours.CYAN + " turn.---------------------- " + TextColours.RESET);
        for (int i = 0; i< getName().length()/2;i++){
            System.out.print(" ");
        }
        System.out.println(TextColours.CYAN + "                    You have "+ TextColours.RED + getLivesNumber() + TextColours.CYAN + " lives. " + TextColours.RESET);


        //Cards in front of Player on Deck
        cardsInPlayerDeck(player);

        //Cards in Player hands
        cardsInPlayerHands(player);


    }    public void cardsInPlayerDeck(Player player) {
        System.out.println("     Cards in front of Player on Deck");

        if(player.blueCardsInPlayerDeck.size() == 0) {
            System.out.println(TextColours.WHITE + "     (Empty jet) " + TextColours.RESET);
        }else {
            System.out.print("  ");
            for (int i = 0; i < player.blueCardsInPlayerDeck.size(); i++) {

                System.out.print(TextColours.BLUE + "   " + player.getCardInPlayerDeck(i).getCardName() + TextColours.RESET);

            }
            System.out.print("\n");
        }
    }
        public void cardsInPlayerHands(Player player){

            System.out.println("     Cards in Player hands ");
            if(player.getCardsInHandCount() == 0) {
                System.out.println(TextColours.WHITE + "     (Empty jet) " + TextColours.RESET);
            }else {
                System.out.print("  ");
                for (int i = 0; i < player.cardsInHand.size(); i++) {

                    if (!player.getCardInHand(i).getCardColour()) {
                        System.out.print(TextColours.YELLOW + "   " + player.getCardInHand(i).getCardName() + TextColours.RESET);
                    } else
                        System.out.print(TextColours.BLUE + "   " + player.getCardInHand(i).getCardName() + TextColours.RESET);

                }
                System.out.print("\n");
            }

            printLine(player);

    }

    public void printLine(Player player){
        System.out.print(TextColours.CYAN + "--------------------------------------------------------" + TextColours.RESET);
        for (int j = 0; j< player.getName().length();j++){
            System.out.print(TextColours.CYAN + "-" + TextColours.RESET);
        }
        System.out.print("\n");
    }
    public void returnPlayerCards(PlayDeck playDeck,Player player){
        int countHand = player.getCardsInHandCount();
        int countDeck = player.getCardsPlayerDeckCount();
        for(int j = 0;j < countHand;j++) {
            player.removeCardInHand(playDeck, player.getCardInHand(0));
        }
        for(int j = 0;j < countDeck;j++) {
            player.removeCardInHand(playDeck, player.getCardInPlayerDeck(0));
        }

    }
    public boolean checkInputRange ( int rangeStart, int rangeEnd, int number, int playerNumber,boolean troll){
        if(troll) {
            if (number == 0) {
                return true;
            }
        }
        if (number >= rangeStart && number <= rangeEnd && playerNumber != number-1) {
            return true;
        }
        System.out.println(TextColours.RED + "             Wrong input" + TextColours.RESET);
        return false;
    }

    }







