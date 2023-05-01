import java.io.IOException;
import java.util.ArrayList;

public class Round {

    private ArrayList<Deck> decks = new ArrayList<>();

    private DrawPile drawpile;
    private DiscardPile discardpile;

    public Round(Game g) throws IOException {
        this.drawpile = new DrawPile();
        this.drawpile.generateDrawPile();
        for(int i = 0 ; i < g.getNbPlayers() ; i++){
            Deck deck = new Deck();
            deck.initializeDeck(this.drawpile);
            this.decks.add(deck);
        }
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public DrawPile getDrawpile() {
        return drawpile;
    }

    public DiscardPile getDiscardpile() {
        return discardpile;
    }

    public void stateOfTheRound(){

    }

    public void chooseBetweenPileDiscard(){

    }

    public void chooseBetweenDropReplace(){

    }

    public void replaceCard(){

    }
}
