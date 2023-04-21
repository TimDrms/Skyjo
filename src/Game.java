import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int nbPlayers;
    ArrayList<Player> players = new ArrayList<>();
    private Round actualRound;
    Game(){
        this.nbPlayers = 2;
        this.actualRound = null;
    }
    Game(int nbPlayers){
        this.nbPlayers = nbPlayers;
        this.actualRound = null;
    }

    /**
     * Setter for the number of players that will play
     *
     * @param nb the number of players that will play
     */
    public void setNbPlayers(int nb){
        this.nbPlayers = nb;
    }

    /**
     * Getter that return the number of players
     *
     * @return the number of players
     */
    public int getNbPlayers(){
        return this.nbPlayers;
    }

    /**
     * Setter in order to know in which round we are
     *
     * @param actualRound the round that we play
     */
    public void setActualRound(Round actualRound) {
        this.actualRound = actualRound;
    }

    /**
     * Getter that return the round that we are playing
     *
     * @return the round that we play
     */
    public Round getActualRound(){
        return this.actualRound;
    }

    /**
     * Setter that will set the ArrayList players, which contains every player in a game.
     *
     * @param players the ArrayList of players
     */
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    /**
     * Getter that will return the ArrayList containing all the players in a game.
     *
     * @return the ArrayList containing all the players in a game.
     */
    public ArrayList getPlayers(){
        return this.players;
    }

    /**
     * This method will initialize the game.
     * When we want to start a new game, this method will be called and initialize all the things that we need.
     * So we will create a new draw pile, new players, new decks, etc.
     * At the end, we need to return a new round, so we can play a game.
     *
     * @return new round, so we can do the first round of the game
     */
    public Round initializeGame() throws IOException {
        /*
        Hasn't been correctly tested yet.
         */
        DrawPile drawPile = new DrawPile();
        drawPile.generateDrawPile();
        howMuchPlayers();
        for(int i = 0 ; i < nbPlayers ; i++){
            Player player = new Player();
            player.askName();
            players.add(player);
            Deck deck = new Deck();
            deck.initializeDeck(drawPile);
        }
        return new Round();
    }

    /**
     * This method will simply ask how many people wants to play the game.
     * It should be called during the initialization of the game.
     *
     * @return int, the number of players
     */
    public int howMuchPlayers(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many people will play?"); // Asks how many people will play
        String nbPlayers = myObj.nextLine();  // Read user input
        this.setNbPlayers(Integer.valueOf(nbPlayers)); // Set the correct amount of players
        return Integer.valueOf(nbPlayers);
    }

    /**
     * This method should be called at the end of a round.
     * The goal is to see if a player has more than 100 points. If so, the game should end.
     * If there is no player with more than 100 points, we'll have to create a new round in this game.
     *
     * Variable isFinished : This boolean have to be defined to true if there is a winner.
     * Variable winner : Takes the username of the winner.
     * Variable draw : Takes the username of both players that are in a draw i guess.
     * Variable lowestScore : Save the score of the player that has the lowest score.
     */
    public void stateOfTheGame(){
        /*
        Il faut prendre en compte la situation où il y a égalité qui ne fonctionne pas.
         */
        boolean isFinished = false;
        String winner = new String();
        String draw = new String();
        int lowestScore = 99;

        for(Player player : players){
            if(player.getScoreGame() >= 100){
                isFinished = true;
            }
            else if(player.getScoreGame() <= lowestScore){
                winner = player.getPlayer();
                lowestScore = player.getScoreGame();
            }
            else if(player.getScoreGame() == lowestScore){
                draw = player.getPlayer();
            }
        }

        if(isFinished == true){
            System.out.println("Game ended! The winner is " + winner + "! Congratz!");
        }
        else{
            new Round();
        }
    }
}
