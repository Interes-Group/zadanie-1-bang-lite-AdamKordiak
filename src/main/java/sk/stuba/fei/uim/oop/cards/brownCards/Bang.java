package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
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
            System.out.println(TextColours.RED + "Whitch Player do you want Attack with Bang ?\n   " + TextColours.RESET);


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


        for(int findBarrelCard = 0; findBarrelCard < players.get(choosedPlayer-1).getCardsPlayerDeckCount() ; findBarrelCard++) {
            if(players.get(choosedPlayer-1).getCardInPlayerDeck(findBarrelCard).getCardCode() == 0){
                int x = random.nextInt(4);

                if(x == 1) {
                haveBarrelCard = true;
                break;
                }
                System.out.println(TextColours.CYAN + "Player's " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.BLUE + " Barrel " + TextColours.CYAN + "don't work." + TextColours.RESET);

            }
        }

        for(int findMissedCard = 0;findMissedCard < players.get(choosedPlayer-1).getCardsInHandCount();findMissedCard++) {

            if(players.get(choosedPlayer-1).getCardInHand(findMissedCard).getCardCode() == 4) {

                players.get(choosedPlayer - 1).removeCardInHand(playDeck, players.get(choosedPlayer - 1).getCardInHand(findMissedCard));
                haveMissedCard = true;
                break;

            }
        }

        if(haveBarrelCard){
            System.out.print(TextColours.CYAN + "Player " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.CYAN + " automatically used " + TextColours.BLUE + "Barrel" + TextColours.CYAN + ". He still have "+ TextColours.RED + players.get(choosedPlayer - 1).getLivesNumber()+  TextColours.CYAN + " lives.\n" + TextColours.RESET);
            return true;

        }else if(haveMissedCard){
            System.out.print(TextColours.CYAN + "Player " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.CYAN + " automatically used " + TextColours.YELLOW + "Missed" + TextColours.CYAN + " card. He still have "+ TextColours.RED + players.get(choosedPlayer - 1).getLivesNumber()+  TextColours.CYAN + " lives.\n" + TextColours.RESET);
            return true;
        }
        else {
            players.get(choosedPlayer - 1).minusLive();

            if(players.get(choosedPlayer - 1).getLivesNumber() == 0){
                System.out.print(TextColours.RED + "                    Player " + players.get(choosedPlayer - 1).getName() + " is dead. \n" + TextColours.RESET);
            }else {
                System.out.print(TextColours.CYAN + "Player " + TextColours.RESET + players.get(choosedPlayer - 1).getName() + TextColours.CYAN + " have now " + TextColours.RED + players.get(choosedPlayer - 1).getLivesNumber() + TextColours.CYAN + " lives.\n" + TextColours.RESET);
            }
        }
        return true;
        }







}
