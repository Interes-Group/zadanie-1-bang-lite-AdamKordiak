package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Bang extends IdentifiedCard {


    public Bang() {

        super.cardName = "Bang";
        super.cardColour = false; // brown colour
        super.cardCode = 3;


    }

    public void useCard(PlayDeck playDeck,ArrayList<Player> players, int i){
        int choosedPlayer;
        do {
            printline(players.get(i));
            System.out.println(TextColours.ANSI_RED + "Whitch Player do you want Attack with Bang ?" + TextColours.ANSI_RESET);
            System.out.print("  ");
            for(int j = 0;j < players.size();j++){
                if(players.get(i).equals(players.get(j))) {
                    System.out.print(TextColours.ANSI_WHITE +" " + players.get(j).getName()+ TextColours.ANSI_RESET);
                }
                else{
                System.out.print(" " + players.get(j).getName());
            }
            }
            System.out.print("\n");
            printline(players.get(i));

            choosedPlayer = ZKlavesnice.readInt(TextColours.ANSI_CYAN + "Choose player from (1," + players.size() + ")." + TextColours.ANSI_RESET);

        }while(!checkInputRange(1, players.size(), choosedPlayer,i));
        players.get(choosedPlayer-1).minusLive();
        if(players.get(choosedPlayer - 1).getLivesNumber() == 0) {
            System.out.print(TextColours.ANSI_RED + "                    Player " + players.get(choosedPlayer - 1).getName() + " is dead. " + TextColours.ANSI_RESET);

        }else{
            System.out.print(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(choosedPlayer - 1).getName() + TextColours.ANSI_CYAN + " have now " + TextColours.ANSI_RED + players.get(choosedPlayer - 1).getLivesNumber() + TextColours.ANSI_CYAN + " lives." + TextColours.ANSI_RESET);

        }
        }

    public boolean checkInputRange ( int rangeStart, int rangeEnd, int number, int playerNumber){

        if (number >= rangeStart && number <= rangeEnd && playerNumber != number-1) {
            return true;
        }
        System.out.println(TextColours.ANSI_RED + "             Wrong input" + TextColours.ANSI_RESET);
        return false;
    }


    public void printline(Player player){
        System.out.print(TextColours.ANSI_CYAN + "--------------------------------------------------------" + TextColours.ANSI_RESET);
        for (int j = 0; j< player.getName().length();j++){
            System.out.print(TextColours.ANSI_CYAN + "-" + TextColours.ANSI_RESET);
        }
        System.out.print("\n");
    }


}
