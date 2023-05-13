import java.util.ArrayList;

public class DiscardPile extends CardPile{

    /**
     * Method that will add a card inside the discard pile.
     * It can be called when a player pick a card and don't want it, or when he want to get rid of one of the cards of his deck.
     *
     * @param card the card that we want to add inside the discard pile.
     */
    public void addDiscardPile(Card card){
        getCardPile().add(card);
    }

    /**
     * This method will pick the card that is on top of the discard pile.
     * It should be called when a player decide to pick a card inside the discard pile instead of the draw pile.
     *
     * @return the card that has been drawn.
     */
    public Card pickDiscardCard(){
        Card cardPicked = new Card();
        if(!this.getCardPile().isEmpty()){
            cardPicked = this.getCardPile().get(this.getCardPile().size() - 1); // Get the last value of the ArrayList, which corresponds to the top of the discard pile.
            this.getCardPile().remove(this.getCardPile().size() - 1); // Remove the card from the discard pile.
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
        if(this.getCardPile().size()>0){
            return this.getCardPile().get(this.getCardPile().size() - 1);
        }
        else{
            return null;
        }
    }
}
