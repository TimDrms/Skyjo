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
    public void setNbPlayers(int nb){
        this.nbPlayers = nb;
    }
    public int getNbPlayers(){
        return this.nbPlayers;
    }
    public void setActualRound(Round actualRound) {
        this.actualRound = actualRound;
    }
    public Round getActualRound(){
        return this.actualRound;
    }
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
