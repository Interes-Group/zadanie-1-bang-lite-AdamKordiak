package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.cards.blueCards.*;
import sk.stuba.fei.uim.oop.cards.brownCards.*;

import java.util.ArrayList;
import java.util.Collections;

public class PlayDeck extends IdentifiedCard {
    private final ArrayList<IdentifiedCard> cardsInDeck;
    private final ArrayList<IdentifiedCard> discardPile;
    private final int[] countsCards;

    public PlayDeck() {
        this.discardPile = new ArrayList<>();
        this.cardsInDeck = new ArrayList<>();
        this.countsCards = new int[] {2,1,3,30,15, 8, 6, 4, 2};

    }
public void fillDeck() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < countsCards[i];j++ ) {
            switch (i) {
                case 0: cardsInDeck.add(new Bang()); break;
                case 1: cardsInDeck.add(new Dynamite());break;
                case 2: cardsInDeck.add(new Prison()); break;
                case 3: cardsInDeck.add(new Bang()); break;
                case 4: cardsInDeck.add(new Missed()); break;
                case 5: cardsInDeck.add(new Bear()); break;
                case 6: cardsInDeck.add(new CatBalou()); break;
                case 7: cardsInDeck.add(new Stagecoach()); break;
                case 8: cardsInDeck.add(new Indians()); break;
            }
        }

    }
    Collections.shuffle(cardsInDeck);

}
    public void fillEmptyDeck(PlayDeck cardsInDeck) {

        for(int j = 0;j < 100;j++) {
            for (int i = 0; i < cardsInDeck.getCardsInPileSize(); i++) {
                cardsInDeck.cardsInDeck.add(cardsInDeck.getPileCard(i));
                cardsInDeck.discardPile.remove(cardsInDeck.getPileCard(i));
            }
        }
        System.out.println(TextColours.RED + "           The cards in the pack have been shuffled." + TextColours.RESET);
        Collections.shuffle(cardsInDeck.cardsInDeck);
    }

    public IdentifiedCard getCard(int i) { return cardsInDeck.get(i); }
    public int getCardsInDeckSize() { return cardsInDeck.size(); }
    public int getCardsInPileSize() { return discardPile.size(); }

    public IdentifiedCard getPileCard(int i) { return discardPile.get(i); }

    public void removeCard(int i ) { cardsInDeck.remove(i); }

    public void addCard(IdentifiedCard card){
        discardPile.add(card);
    }







}
