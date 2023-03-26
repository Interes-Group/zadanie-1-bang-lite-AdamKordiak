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
                        System.out.println(TextColours.CYAN + "Player " + TextColours.RESET + players.get(checkOtherPlayers).getName() + TextColours.CYAN + " automatically used " + TextColours.YELLOW + "Bang" + TextColours.CYAN + " card. He still have "+ TextColours.RED + players.get(checkOtherPlayers).getLivesNumber()+  TextColours.CYAN + " lives." + TextColours.RESET);
                        players.get(checkOtherPlayers).removeCardInHand(playDeck, players.get(checkOtherPlayers).getCardInHand(findBangCard));
                        statement = false;
                        break;
                    }
                }

                if(statement){
                    players.get(checkOtherPlayers).minusLive();
                    if(players.get(checkOtherPlayers).getLivesNumber() == 0){
                        System.out.print(TextColours.RED + "                    Player " + players.get(checkOtherPlayers).getName() + " is dead. \n" + TextColours.RESET);

                    }else{
                        System.out.println(TextColours.CYAN + "Player " + TextColours.RESET + players.get(checkOtherPlayers).getName() + TextColours.CYAN + " have now " + TextColours.RED + players.get(checkOtherPlayers).getLivesNumber() + TextColours.CYAN + " lives." + TextColours.RESET);

                    }
                }
            }
        }
        return true;
  }


}
