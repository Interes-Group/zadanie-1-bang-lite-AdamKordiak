package sk.stuba.fei.uim.oop.cards.brownCards;

import sk.stuba.fei.uim.oop.cards.IdentifiedCard;
import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.game.TextColours;

import java.util.ArrayList;

public class Indians extends IdentifiedCard {

    public Indians() {

        super.cardName = "Indians";
        super.cardColour = false; // brown colour
        super.cardCode = 8;


    }

    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        players.get(actualPlayer).printLine(players.get(actualPlayer));

        for (int checkOtherPlayers = 0;checkOtherPlayers < players.size();checkOtherPlayers++){
            boolean statement = true;
            if(players.get(actualPlayer) == players.get(checkOtherPlayers)){
                continue;
            }else {
                for(int findBangCard = 0;findBangCard < players.get(checkOtherPlayers).getCardsInHandCount();findBangCard++) {

                    if(players.get(checkOtherPlayers).getCardInHand(findBangCard).getCardCode() == 3){
                        System.out.println(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(checkOtherPlayers).getName() + TextColours.ANSI_CYAN + " automatically used " + TextColours.ANSI_YELLOW + "Bang" + TextColours.ANSI_CYAN + " card. He still have "+ TextColours.ANSI_RED + players.get(checkOtherPlayers).getLivesNumber()+  TextColours.ANSI_CYAN + " lives." + TextColours.ANSI_RESET);
                        players.get(checkOtherPlayers).removeCardInHand(playDeck, players.get(checkOtherPlayers).getCardInHand( findBangCard));
                        statement = false;
                        break;
                    }
                }

                if(statement){
                    players.get(checkOtherPlayers).minusLive();
                    if(players.get(checkOtherPlayers).getLivesNumber() == 0){
                        System.out.print(TextColours.ANSI_RED + "                    Player " + players.get(checkOtherPlayers).getName() + " is dead. \n" + TextColours.ANSI_RESET);

                    }else{
                        System.out.println(TextColours.ANSI_CYAN + "Player " + TextColours.ANSI_RESET + players.get(checkOtherPlayers).getName() + TextColours.ANSI_CYAN + " have now " + TextColours.ANSI_RED + players.get(checkOtherPlayers).getLivesNumber() + TextColours.ANSI_CYAN + " lives." + TextColours.ANSI_RESET);

                    }
                }
            }
        }
        return true;
  }


}
