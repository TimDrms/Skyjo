import java.util.ArrayList;
import java.util.Scanner;

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
     * This method check if there are three cards with the same value in a column
     */
    public void checkIdenticalCardsColumn(){
        for(int i=0; i<4;i++) {
            if (this.getCardPile().get(0 + i).getValue() == this.getCardPile().get(4 + i).getValue()
            && this.getCardPile().get(4 + i).getValue() == this.getCardPile().get(8 + i).getValue()
            && this.getCardPile().get(0 + i).getIsReturned() && this.getCardPile().get(4 + i).getIsReturned()
            && this.getCardPile().get(8 + i).getIsReturned()){
                this.getCardPile().get(0 + i).setIsColumn(true);
                this.getCardPile().get(0 + i).setValue(0);
                this.getCardPile().get(4 + i).setIsColumn(true);
                this.getCardPile().get(4 + i).setValue(0);
                this.getCardPile().get(8 + i).setIsColumn(true);
                this.getCardPile().get(8 + i).setValue(0);
            }
        }
    }

    /**
     * This method calc the score of the deck by adding up the values of every cards that are returned (score in real time for players)
     * @return int, score of the deck
     */
    public int getScoreFromDeck(){
        int score=0;
        for(int i=0;i<12;i++){
            if(this.getCardPile().get(i).getIsReturned()) {
                score += this.getCardPile().get(i).getValue();
            }
        }
        return score;
    }

    /**
     * This method return all the cards and call getScoreFromDeck, then it print the deck
     * @return int, score of the deck
     */
    public int getFinalScoreFromDeck(){
        int score=0;
        for(int i=0;i<12;i++){
            if(!this.getCardPile().get(i).getIsReturned()) {
                this.getCardPile().get(i).setIsReturned(true);
            }
        }
        score = this.getScoreFromDeck();
        System.out.println(this);
        return score;
    }


    /**
     * This method will simply return a card.
     * So, when a card isn't returned yet (which means that we don't know the value of the card), this method will return it.
     * If the card has already been returned, it will say that the card has already been returned and will ask to return another card. Then, we will call back this method, with the new card chose.
     * Otherwise, it will return the card and say the value of it.
     *
     * @param card the card that we want to return
     */
    public void returnCard(Card card){
        if(!card.getIsReturned()){
            card.setIsReturned(true);
            System.out.println("The card is " + card.getName() + " (value = "+ card.getValue() + " )");
            System.out.println(this);
        }
        else{
            System.out.println("Error: this card has already been returned. Please select another one.");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            int choice = 0;
            choice = myObj.nextInt();  // Read user input
            returnCard(getCardPile().get(choice-1));
        }
    }

    /**
     * The toString method in this class will return the entire deck of a player.
     * If a card is returned, we will print the value of the card.
     * If a card isn't returned, because the player shouldn't see the value of the card, we will print instead a X.
     * If there is a column with identical cards, we will print a "Y" instead of the value of the card, to show that the column has cards with the same value.
     * We have tried to print the deck in a fancy way, so it would be pleasant for the player to read his deck.
     *
     * @return the complete deck of a player.
     */
    public String toString(){
        System.out.println("");
        System.out.println("The score of the deck is : " + this.getScoreFromDeck());
        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < 4; i++) { // Doing 2 separate for because we want the cards to be printed as a grid.
                if(this.getCardPile().get((4*j)+i).getIsReturned() && !this.getCardPile().get((4*j)+i).getIsColumn()){ // Verification that the card is returned and that this isn't a column.
                    System.out.print(" | " + this.getCardPile().get((4 * j) + i).getName() + " ");
                }else if (!this.getCardPile().get((4*j)+i).getIsReturned()){ // Check if the card is hidden (in that case, we'll simply show an "X", because the player shouldn't see the value of the card.
                    System.out.print(" |   X  ");
                }
                else if(this.getCardPile().get((4*j)+i).getIsColumn()){ // If a card is in a column with identical cards values and that the cards are returned, we will print a "Y" to show that all the cards have been returned. No need to check if the card is returned, because we check that when we give "True" to the variable "isColumn".
                    System.out.print(" |   Y  ");
                }
            }
            System.out.println(" |");
        }
        return "";
    }
}