import java.util.ArrayList;

public class DiscardPile extends CardPile{
    ArrayList<Card> discardPile = new ArrayList<>(150); // The discard pile that will be used during the game.

    /**
     * Setter that will set the discard pile. (this is an array list).
     *
     * @param discardPile : array list that is the discard pile.
     */
    public void setDiscardPile(ArrayList discardPile){
        this.discardPile = discardPile;
    }

    /**
     * Getter that will return the content of the discard pile.
     *
     * @return the discard pile.
     */
    public ArrayList getDiscardPile(){
        return this.discardPile;
    }

    /**
     * Method that will add a card inside the discard pile.
     * It can be called when a player pick a card and don't want it, or when he want to get rid of one of the cards of his deck.
     *
     * @param card the card that we want to add inside the discard pile.
     */
    public void addDiscardPile(Card card){
        discardPile.add(card);
    }

    /**
     * This method will pick the card that is in top of the discard pile.
     * It should be called when a player decide to pick a card inside the discard pile instead of the draw pile.
     *
     * @return the card that has been drawn.
     */
    public Card pickDiscardCard(){
        Card cardPicked = new Card();
        if(this.discardPile.isEmpty() == false){
            cardPicked = this.discardPile.get(this.discardPile.size() - 1); // Get the last value of the ArrayList, which corresponds to the top of the discard pile.
            this.discardPile.remove(this.discardPile.size() - 1); // Remove the card from the discard pile.
        }
        else{
            System.out.println("The discard pile is empty, so you can't pick a card from it.");
        }
        return cardPicked;
    }

    /**
     * This method will return the card that is on top of the discard pile.
     * It can be useful when we want to see what card is on top because we can pick it.
     *
     * @return the Card that is on top of the discard pile
     */
    public Card showTheTopCard(){
        return this.discardPile.get(this.discardPile.size() - 1);
    }

    @Override
    public String toString() {
        String value = "";
        for(Card card : discardPile){
            value += "This card has the value " + card.getValue() + ".\n";
        }
        return value;
    }
}
