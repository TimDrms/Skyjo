import java.util.ArrayList;

public class Deck extends CardPile{
    private int scoreRound; // Score of the round of the player who owns the deck.

    /**
     * Setter that will set the total score of the round.
     * The score is the sum of the value of all the cards that are in the deck.
     *
     * @param scoreRound the score of the round for the deck
     */
    public void setScoreRound(int scoreRound){
        this.scoreRound = scoreRound;
    }

    /**
     * Getter that will return the total score of the round.
     *
     * @return the total score of the round
     */
    public int getScoreRound(){
        return this.scoreRound;
    }

    /**
     * This method will give the 12 cards that a deck must have.
     * So, we will take 12 random cards from the draw pile, adding them into the deck, and removing them from the draw pile.
     *
     * @param drawPile the draw pile from which we will draw the 12 cards
     * @return an ArrayList with 12 cards. But we won't know the value of those 12 cards because there are still hidden at the beginning of the game
     */
    public ArrayList initializeDeck(DrawPile drawPile){
        for(int i = 0; i<12; i++){
            this.getCardPile().add(drawPile.pickDrawCard());
        }
        return this.getCardPile();
    }

    /**
     * This method will simply return a card.
     * So, when a card isn't returned yet (which means that we don't know the value of the card), this method will return it.
     * If the card has already been returned, it will simply say that the card has already been returned.
     * Otherwise, it will return the card and say the value of it.
     *
     * @param card the card that we want to return
     */
    public void returnCard(Card card){
        if(!card.getIsReturned()){
            card.setIsReturned(true);
            System.out.println("The value of the card is: " + card.getValue());
        }
        else{
            System.out.println("Error: this card has already been returned.");
        }
    }
}