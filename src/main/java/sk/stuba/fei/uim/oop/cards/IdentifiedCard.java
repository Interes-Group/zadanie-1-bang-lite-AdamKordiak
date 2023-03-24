package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.game.PlayDeck;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;
import java.util.RandomAccess;

public abstract class IdentifiedCard {

    protected String cardName;
    protected int cardCode;
    protected boolean cardColour;



    public String getCardName() { return cardName; }
    public int getCardCode() { return cardCode; }
    public boolean getCardColour() { return cardColour; }


    public boolean useCard(PlayDeck playDeck, ArrayList<Player> players, int actualPlayer,int choosedCard ) {
        return true;}



}
