import java.io.IOException;
import java.util.ArrayList;

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
     * This method will initialize the game.
     * When we want to start a new game, this method will be called and initialize all the things that we need.
     * So we will create a new draw pile, new players, new decks, etc.
     * At the end, we need to return a new round, so we can play a game.
     *
     * @param nbPlayers the number of players that will play the game
     * @return new round, so we can do the first round of the game
     */
    public Round initializeGame(int nbPlayers) throws IOException {
        /*
        Hasn't been tested yet.
         */
        DrawPile drawPile = new DrawPile();
        drawPile.generateDrawPile();
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
     * This method should be called at the end of a game.
     * The goal is to see if a player has more than 100 points. If so, the game should end.
     * If there is no player with more than 100 points, we'll have to create a new round in this game.
     */
    public void stateOfTheGame(){
        /*
        Hasn't been tested yet.
         */
        boolean isFinished = false;
        String winner = new String();
        for(Player player : players){
            if(player.getScoreGame() >= 100){
                System.out.println("The game is finished!");
                isFinished = true;
                winner = player.getPlayer();
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
