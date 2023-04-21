import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Create two cards.");
        Card card1 = new Card(8, false);
        Card card2 = new Card(12, true);
        System.out.println(card1);
        System.out.println(card2);

        /*System.out.println("--------------------------\nCreate a draw pile of 150 cards.");
        DrawPile drawPile1 = new DrawPile();
        drawPile1.generateDrawPile();
        System.out.println(drawPile1);

        System.out.println("\n Take 3 random cards from the draw pile.");
        for(int i = 0 ; i<=2 ; i++){
            drawPile1.pickDrawCard();
        }*/

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

        modifyPlayer = players.get(2);
        modifyPlayer.setScoreGame(38);
        players.set(2, modifyPlayer);

        for(Player player : players){
            System.out.println(player.getPlayer() + " has " + player.getScoreGame() + " points."); // Show the score of every player.
        }

        game1.stateOfTheGame();

    }
}