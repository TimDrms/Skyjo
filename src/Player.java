import java.util.Scanner;

public class Player {
    private String player = new String();
    private int nbGamesPlayed, nbGamesWon, scoreGame;
    Player(){
        this.player = null;
        this.nbGamesPlayed = 0;
        this.nbGamesWon = 0;
        this.scoreGame = 0;
    }
    Player(String namePlayer){
        this.player = namePlayer;
        this.nbGamesPlayed = 0;
        this.nbGamesWon = 0;
        this.scoreGame = 0;
    }

    /**
     * Setter that will set the username of the player
     *
     * @param namePlayer the username of the player
     */
    public void setPlayer(String namePlayer){
        this.player = namePlayer;
    }

    /**
     * Getter that will return the username of the player
     *
     * @return the username of the player
     */
    public String getPlayer(){
        return this.player;
    }

    /**
     * Setter that will set the score of a player during a game
     *
     * @param scoreGame the score of a player
     */
    public void setScoreGame(int scoreGame) {
        this.scoreGame = scoreGame;
    }

    /**
     * Getter that will return the score of a player during a game
     *
     * @return the score of a player during a game
     */
    public int getScoreGame() {
        return this.scoreGame;
    }

    /**
     * Setter that will set the number of games that a player has already played
     *
     * @param nbGamesPlayed the number of games that a player has already played
     */
    public void setNbGamesPlayed(int nbGamesPlayed){
        this.nbGamesPlayed = nbGamesPlayed;
    }

    /**
     * Getter that will return the game of games that a player has already played
     *
     * @return the number of games that a player has already played
     */
    public int getNbGamesPlayed(){
        return this.nbGamesPlayed;
    }

    /**
     * Setter that will set the number of games that a player has won
     *
     * @param nbGamesWon the number of games that a player has won
     */
    public void setNbGamesWon(int nbGamesWon){
        this.nbGamesWon = nbGamesWon;
    }

    /**
     * Getter that will return the game of games that a player has won
     *
     * @return the number of games that a player has won
     */
    public int getNbGamesWon(){
        return this.nbGamesWon;
    }

    /**
     * Method that will ask the player which username he wants.
     * Then, the player will have a username attribute according to what he wrote.
     *
     * @return the username of the player
     */
    public String askName(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        this.player = myObj.nextLine();  // Read user input
        return("Username is: " + this.player);  // Output user input
    }

    /**
     * toString method that is used to print all the useful information about a player including his name and some stats.
     *
     * @return the username + the number of games played & won
     */
    public String toString(){
        return this.getPlayer() + " has played " + this.getNbGamesPlayed() + " games and won " + this.getNbGamesWon() + " games.";
    }
}
