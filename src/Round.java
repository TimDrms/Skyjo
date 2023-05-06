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
     *
     * @param p The player that will pick a card
     */
    public void chooseBetweenDrawDiscard(Player p){
        int choice = 0; // Local variable that will be used to determine if we want to pick a card from the draw pile or the discard pile
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to pick a random card from the pile card (say 1) or the card that is on top of the discard pile, which is " + discardpile.showTheTopCard() + " (say 2)");
        choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            Card drawnCard = new Card();
            drawnCard = drawpile.pickDrawCard();
            System.out.println(drawnCard);
            chooseBetweenDropReplace(drawnCard, p);
        }
        else if(choice == 2){
            replaceCard();
        }
        else{
            System.out.println("Error: invalid number. You should type 1 or 2 to choose which action you want to do.");
            chooseBetweenDrawDiscard(p);
        }
    }

    /**
     * In this method, you will choose between dropping a card that you have drawn, or replacing a card by this card that you have drawn.
     * If you choose to drop it, then we will add this card to the discard pile and the player would have to return one of his card.
     * If you choose to replace it by one of the card of your deck, we will call the method replaceCard to do it.
     *
     * @param c : the card that has been drawn by the player and that could be replaced by one of the card of your deck.
     * @param p : the player that will make the choice
     */
    public void chooseBetweenDropReplace(Card c, Player p){
        int choice = 0; // Local variable that will be used to determine if we want to pick a card from the draw pile or the discard pile
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to drop the card that you drew in the discard pile (say 1) or do you want to replace it by a card of your deck ? (say 2)");
        choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            discardpile.addDiscardPile(c);
            System.out.println("The card is now in the discard pile.");
            System.out.println("Now you have to return one of the cards in your deck. Which one do you want to return?");
            choice = myObj.nextInt();
            // En fonction de la valeur choisi, retourner la carte numéro choice de son deck grâce à la méthode returnCard dans la class Deck.
            // getDecks().get(0).getCardPile().get(choice);
        }
        else if(choice == 2){
            replaceCard();
        }
        else{
            System.out.println("Error: invalid number. You should type 1 or 2 to choose which action you want to do.");
            chooseBetweenDropReplace(c, p);
        }
    }



    public void replaceCard(){

    }

    /**
     * This method allow to easily pick a specific card of a deck
     * We take the round in progress, then the deck of the player in parameter
     * and finally the number of the card we want to pick.
     * @param player int, number of the player (place in the ArrayList of players,
     *               in the same order as the ArrayList of Decks)
     * @param nb int, position of the card in the deck
     * @return Card, the card we wanted to pick
     */
    public Card getCardFromDeck(int player, int nb){
        return getDecks().get(player).getCardPile().get(nb);
    }

    /**
     * This method check if a round is finished, that means if all cards of a deck are returned
     * For all players, we count the number of cards return, if this number is equal 12, then finish is true
     * @return boolean, false if the game must continue, true if the game must end
     */
    public boolean checkEndOfRound(){
        boolean finish=false;
        for(int j=0; j<decks.size();j++){
            int nbReturn=0;
            for(int i=0; i<12; i++){
                if(getCardFromDeck(j,i).getIsReturned()){
                    nbReturn++;
                }
            }
            if(nbReturn==12){
                finish=true;
            }
        }
        return finish;
    }
}