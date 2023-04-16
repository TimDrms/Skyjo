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
    public void setPlayer(String namePlayer){
        this.player = namePlayer;
    }
    public String getPlayer(){
        return this.player;
    }
    public void setScoreGame(int scoreGame) {
        this.scoreGame = scoreGame;
    }
    public int getScoreGame() {
        return this.scoreGame;
    }
    public void setNbGamesPlayed(int nbGamesPlayed){
        this.nbGamesPlayed = nbGamesPlayed;
    }
    public int getNbGamesPlayed(){
        return this.nbGamesPlayed;
    }
    public void setNbGamesWon(int nbGamesWon){
        this.nbGamesWon = nbGamesWon;
    }
    public int getNbGamesWon(){
        return this.nbGamesWon;
    }
    public String askName(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        this.player = myObj.nextLine();  // Read user input
        return("Username is: " + this.player);  // Output user input
    }
    public String toString(){
        return this.getPlayer() + " has played " + this.getNbGamesPlayed() + " games and won " + this.getNbGamesWon() + " games.";
    }
}
