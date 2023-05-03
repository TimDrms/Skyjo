import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    private ArrayList<Deck> decks = new ArrayList<>();

    private DrawPile drawpile;
    private DiscardPile discardpile;

    public Round(Game g) throws IOException {
        this.drawpile = new DrawPile();
        this.drawpile.generateDrawPile();
        this.discardpile = new DiscardPile();
        this.discardpile.addDiscardPile(this.drawpile.pickDrawCard());
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

    /**
     * This method will be called each time a player needs to play, so he can choose between picking a card from the card pile or the discard card.
     * If he chooses to pick a card from the card pile, we will show the card and call the method chooseBetweenDropReplace.
     * If he chooses to pick a card from the discard pile, we will directly call the method replaceCard.
     */
    public void chooseBetweenDrawDiscard(){
        int choice = 0; // Local variable that will be used to determine if we want to pick a card from the draw pile or the discard pile
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to pick a random card from the pile card (say 1) or the card that is on top of the discard pile, which is " + discardpile.showTheTopCard() + " (say 2)");
        choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            System.out.println(drawpile.pickDrawCard());
            chooseBetweenDropReplace();
        }
        else if(choice == 2){
            replaceCard();
        }
        else{
            System.out.println("Error: invalid number. You should type 1 or 2 to choose which action you want to do.");
            chooseBetweenDrawDiscard();
        }
    }

    public void chooseBetweenDropReplace(){

    }

    public void replaceCard(){

    }
}