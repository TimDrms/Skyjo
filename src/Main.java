import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void test() throws IOException{
        System.out.println("Create two cards.");
        Card card1 = new Card(8, false);
        Card card2 = new Card(12, true);
        System.out.println(card1);
        System.out.println(card2);

        System.out.println("--------------------------\nCreate a draw pile of 150 cards.");
        DrawPile drawPile1 = new DrawPile();
        drawPile1.generateDrawPile();
        System.out.println(drawPile1);

        System.out.println("--------------------------\nCreate a deck of 12 random cards.");
        Deck deck1 = new Deck();
        deck1.initializeDeck(drawPile1);
        System.out.println(deck1);

        System.out.println(drawPile1);

        System.out.println("\n Take 3 random cards from the draw pile.");
        for(int i = 0 ; i<=2 ; i++){
            drawPile1.pickDrawCard();
        }

        System.out.println("-----------------------------\nCreate & Add 5 cards in the discard pile, then print the cards");
        DiscardPile discardPile = new DiscardPile();
        for(int i = 0 ; i<5 ; i++){
            discardPile.addDiscardPile(drawPile1.pickDrawCard());
        }
        System.out.println(discardPile);

        System.out.println("\nPick the card that is in top of the discard pile, and print the discard pile.");
        discardPile.pickDiscardCard();
        System.out.println(discardPile);

        System.out.println("\n-------------------------------\nCreate a new player");
        Player player1 = new Player();
        player1.askName();
        System.out.println(player1);

        /*System.out.println("\nCreate a new deck");
        Deck deck1 = new Deck();
        deck1.initializeDeck(drawPile1);
        System.out.println(deck1);

        System.out.println("\n Return 3 cards from our deck");
        for(int i = 0 ; i <= 2 ; i++){
            System.out.println("hi");
        }*/

        System.out.println("\n-----------------------\nStart a new game with n players.");
        Game game1 = new Game();

        game1.initializeGame();

        System.out.println(game1.getNbPlayers()); // Get the number of players in the game

        ArrayList<Player> players = game1.getPlayers(); // Create an ArrayList with all the players inside of it

        Player modifyPlayer = players.get(1); // Copy one of the player of the Arraylist
        modifyPlayer.setScoreGame(103); // Set the score of that player to 103
        players.set(1, modifyPlayer); // Copy that player inside the ArrayList, so the changes will be applied

        modifyPlayer = players.get(0);
        modifyPlayer.setScoreGame(38);
        players.set(0, modifyPlayer);

        for(Player player : game1.getPlayers()){
            System.out.println(player.getPlayer() + " has " + player.getScoreGame() + " points."); // Show the score of every player.
        }

        for(Deck deck : game1.getActualRound().getDecks()){
            System.out.println(deck.getCardPile()); // Show the score of every player.
        }

        System.out.println(game1.getActualRound().getDrawpile());
        game1.stateOfTheGame();

        System.out.println("\n-------------------------------------\nCreating a new round");
        Round round1 = new Round(game1);
        System.out.println("\n-----------------------------------\nTest for the method chooseBetweenDrawDiscard");
        round1.chooseBetweenDrawDiscard(players.get(0));
    }
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.initializeGame();
        boolean gameOver = false;
        boolean roundOver = false;
        while(gameOver != true){
            while(roundOver != true){
                Round round = new Round(game);
                System.out.println("slt");
                for(int i = 0; i < game.getNbPlayers() ; i++){
                    System.out.println("slt");
                    round.chooseBetweenDrawDiscard(game.players.get(i));
                }
                //gameOver = true;
                //roundOver = true;

                /*if(round.stateOfTheRound() == true){
                    roundOver = true;
                }*/
            }
            if(game.stateOfTheGame() == true){
                gameOver = true;
            }
        }
        game.stateOfTheGame();
    }
}