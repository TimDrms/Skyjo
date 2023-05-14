import java.io.IOException;
public class Main {
    /**
     * Here is the game loop, one of the key component because it will make everything working together.
     * It will create a new game, new rounds when needed, and make every player plays.
     * When a player needs to play, he will have choices to do, and we will remind to him his deck, and show what card he drew.
     *
     * Variable gameOver: boolean that will tell if the game is over (true) or not (false).
     * Variable roundOver: boolean that will tell if the round is over (true) or not (false).
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.initializeGame(); // Creating a new game
        boolean gameOver = false; // Tells when the game is over
        boolean roundOver = false; // Tells when the round is over
        while(!gameOver){ // Game loop for the game
            game.setActualRound(new Round(game)); // Creating new round
            roundOver = false;
            while(!roundOver){ // Game loop for the round
                for(int i = 0; i < game.getNbPlayers() ; i++){ // This loop will make every player plays one turn.
                    System.out.println("\n------------------------------------------------------------------------");
                    System.out.println(game.players.get(i).getPlayer() + " it's your turn!"); // Show the username of the player that needs to play.
                    System.out.println("Here is a reminder of your deck.");
                    System.out.println(game.getActualRound().getDecks().get(i)); // Show the deck of the player that currently plays
                    game.getActualRound().chooseBetweenDrawDiscard(i); // Let him choose between picking a card from the draw pile or the discard pile.
                    game.getActualRound().getDecks().get(i).checkIdenticalCardsColumn(); // Checking at the end of his turn if there is a column with other identical cards.
                }
                if(game.getActualRound().checkEndOfRound() == true){ // Cheking if the round should end.
                    game.attributeScore();
                    roundOver = true;
                    if(game.stateOfTheGame() == true){ // Checking if the game should end.
                        gameOver = true;
                    }
                }
            }
        }
    }
}