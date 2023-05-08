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
     * @return int, 0 if there is no column with three same cards or the number of the column if there is one
     */
    public int checkIdenticalCardsColumn(){
        for(int i=0; i<5;i++) {
            if(i==4){
                return 0;
            }
            if (this.getCardPile().get(0 + i).getValue() == this.getCardPile().get(4 + i).getValue()
            && this.getCardPile().get(4 + i).getValue() == this.getCardPile().get(8 + i).getValue()) {
                return i+1;
            }
        }
        return 0;
    }

    /**
     * This method calc the score of the deck by adding up the values of every cards
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
            System.out.println("The value of the card is: " + card.getValue());
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

    public String toString(){
        System.out.println("");
        System.out.println("The score of the deck is : " + this.getScoreFromDeck());
        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < 4; i++) {
                if(this.getCardPile().get((4*j)+i).getIsReturned()){
                    if(this.getCardPile().get((4*j)+i).getValue()>9 || this.getCardPile().get((4*j)+i).getValue()<0) {
                        System.out.print(" | " + this.getCardPile().get((4 * j) + i).getValue() + " ");
                    }else{
                        System.out.print(" |  " + this.getCardPile().get((4 * j) + i).getValue() + " ");
                    }
                }else{
                    System.out.print(" |  X ");
                }
            }
            System.out.println(" |");
        }
        return "";
    }
}