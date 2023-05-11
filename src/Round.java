import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    private ArrayList<Deck> decks = new ArrayList<>();
    private DrawPile drawPile;
    private DiscardPile discardPile;

    /**
     * The constructor of the round will do all the things needed to initialize a round.
     * So, it will create and generate a draw pile, it will also create a discard pile and put one card in it (this is useful for the game)
     * Then, we will create for each player a deck, initializing it and adding it to an array list of decks.
     * Once this is done, we will ask each player to return 2 cards from their deck.
     *
     * @param g : The game in which the round takes place
     * @throws IOException
     */
    public Round(Game g) throws IOException {
        // Initializing the draw pile and discard pile.
        this.drawPile = new DrawPile();
        this.drawPile.generateDrawPile();
        this.discardPile = new DiscardPile();
        this.discardPile.addDiscardPile(this.drawPile.pickDrawCard());
        // This for loop will create and initialize each deck for each player (and then adding it to an ArrayList of decks).
        for(int i = 0 ; i < g.getNbPlayers() ; i++){
            System.out.println("\n------------------------------------------------------------------------");
            Deck deck = new Deck();
            deck.initializeDeck(this.drawPile);
            this.decks.add(deck);
            // This for loop will ask each player to return 2 cards at the beginning of the round (and it will do it).
            for(int j = 0; j < 2; j++){
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("\n" + g.players.get(i).getPlayer() + " choose a card to return in your deck.");
                int choice = 0;
                choice = myObj.nextInt();  // Read user input
                decks.get(i).returnCard(decks.get(i).getCardPile().get(choice-1)); // Return the specified card from the correct deck
                //System.out.println(decks.get(i)); // Print back the deck to see what is the value of that card.
            }
        }
    }

    public ArrayList<Deck> getDecks() {
        return this.decks;
    }

    public DrawPile getDrawpile() {
        return this.drawPile;
    }

    public DiscardPile getDiscardpile() {
        return this.discardPile;
    }

    /**
     * This method will be called each time a player needs to play, so he can choose between picking a card from the card pile or the discard card.
     * If he chooses to pick a card from the card pile, we will show the card and call the method chooseBetweenDropReplace.
     * If he chooses to pick a card from the discard pile, we will directly call the method replaceCard.
     *
     * @param p The player that will pick a card
     */
    public void chooseBetweenDrawDiscard(int p){
        int choice = 0; // Local variable that will be used to determine if we want to pick a card from the draw pile or the discard pile
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to pick a random card from the pile card (say 1) \nOr the card that is on top of the discard pile, which is " + this.discardPile.showTheTopCard() + " (say 2)");
        choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            Card drawnCard = new Card();
            drawnCard = drawPile.pickDrawCard();
            System.out.println("The card you picked is " + drawnCard);
            chooseBetweenDropReplace(drawnCard, p);
        }
        else if(choice == 2){
            this.discardPile.showTheTopCard().setIsReturned(true);
            replaceCard(this.discardPile.pickDiscardCard(),p);

        }
        else{
            System.out.println("Error: invalid number. You should type 1 or 2 to choose. \nWhich action you want to do?");
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
    public void chooseBetweenDropReplace(Card c, int p){
        int choice = 0; // Local variable that will be used to determine if we want to pick a card from the draw pile or the discard pile
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to drop the card that you drew in the discard pile (say 1) \nOr do you want to replace it by a card of your deck ? (say 2)");
        choice = myObj.nextInt();  // Read user input

        if(choice == 1){
            discardPile.addDiscardPile(c);
            System.out.println("The card is now in the discard pile.");
            System.out.println("Now you have to return one of the cards in your deck. \nWhich one do you want to return?");
            choice = myObj.nextInt();
            // En fonction de la valeur choisi, retourner la carte numéro choice de son deck grâce à la méthode returnCard dans la class Deck.
            decks.get(p).returnCard(decks.get(p).getCardPile().get(choice-1)); // Return the specified card from the correct deck

        }
        else if(choice == 2){
            c.setIsReturned(true);
            replaceCard(c,p);
        }
        else{
            System.out.println("Error: invalid number. You should type 1 or 2 to choose \nWhich action you want to do?");
            chooseBetweenDropReplace(c, p);
        }
    }


    /**
     * This method will replace one of the card of your choice by another card.
     * It could even be a card from the draw pile, or the discard pile.
     * We will call this method in the methods chooseBetweenDropReplace and chooseBetweenDrawDiscard.
     * Once this is called, we ask the player which card of his deck he wants to swap, and we proceed it.
     *
     * @param c : the card that will replace of the card of the deck of the player.
     */
    public void replaceCard(Card c, int p){
        int choice = 0;
        System.out.println("Which card do you want to replace from your deck? location : [1;12]");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        choice = myObj.nextInt();
        discardPile.addDiscardPile(getDecks().get(p).getCardPile().get(choice-1));
        getDecks().get(p).getCardPile().set(choice-1, c);
        this.decks.get(p).checkIdenticalCardsColumn();
        System.out.println(decks.get(p));
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
        return decks.get(player).getCardPile().get(nb);
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