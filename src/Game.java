import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


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
    public ArrayList<Player> getPlayers(){
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
    public void initializeGame() throws IOException {
        /*
        Hasn't been correctly tested yet.
         */
        howMuchPlayers();
        for(int i = 0 ; i < nbPlayers ; i++){
            Player player = new Player();
            player.askName();
            this.players.add(player);
        }
    }

    /**
     * This method will simply ask how many people wants to play the game.
     * It should be called during the initialization of the game.
     * We also check that the number of players is correct (between 2 and 8).
     *
     * @return int, the number of players
     */
    public int howMuchPlayers(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many people will play?"); // Asks how many people will play
        if(myObj.hasNextInt()){ // Check that the value is an integer
            int nbPlayers = myObj.nextInt();  // Read user input
            this.setNbPlayers(nbPlayers); // Set the correct amount of players
        }
        else{
            System.out.println("Please, just write a number.");
            howMuchPlayers();
        }
        if(nbPlayers <2 || nbPlayers>8){ // Check that the number of players is between 2 and 8.
            System.out.println("Please write a number between 2 and 8.");
            howMuchPlayers();
        }
        return nbPlayers;
    }

    /**
     * This method return the player that is losing by comparing the score of each of them using the variable max.
     * In case of equality, the loser is drawn as random.
     * @return Player, loser of the round
     */
    public Player isLosing(){
        Player loser = null;
        int max = -50;
        Random rd = new Random();
        for(int i=0; i<this.getNbPlayers(); i++){
            if(this.getPlayers().get(i).getScoreGame() > max) {
                loser = this.getPlayers().get(i);
            }else if(this.getPlayers().get(i).getScoreGame() == max){
                if(rd.nextBoolean()){
                    loser = this.getPlayers().get(i);
                }
            }
        }
        return loser;
    }

    /**
     * This method is calling at the end of each round to adding up the score of the actual round to the score of the game for each player
     */
    public void attributeScore(){
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("End of the round");
        for(int i=0;i<this.getNbPlayers();i++){
            System.out.println("For the player " + this.getPlayers().get(i).getPlayer() + " :");
            this.players.get(i).setScoreGame(this.players.get(i).getScoreGame() + this.getActualRound().getDecks().get(i).getFinalScoreFromDeck());
        }
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
     *
     * @return true if the game is finished, or false if the game is not finished.
     */
    public boolean stateOfTheGame(){
        Player loser=this.isLosing();
        if(loser.getScoreGame() >= 100){
            System.out.println("Game ended! " + loser.getPlayer() + " just reached " + loser.getScoreGame() +" points !");
            System.out.println("Here are everyone's scores : ");
            for (int i=0;i<this.getNbPlayers();i++){
                System.out.println(this.players.get(i).getPlayer() +" has " + this.players.get(i).getScoreGame() + " points !");
            }
            return true;
        }
        else{
            return false;
        }
    }
}
