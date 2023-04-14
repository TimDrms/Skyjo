public class Player {
    private String player = new String();
    private int nbGamesPlayed, nbGamesWon;
    Player(){
        this.player = null;
        this.nbGamesPlayed = 0;
        this.nbGamesWon = 0;
    }
    Player(String namePlayer){
        this.player = namePlayer;
        this.nbGamesPlayed = 0;
        this.nbGamesWon = 0;
    }
    public void setPlayer(String namePlayer){
        this.player = namePlayer;
    }
    public String getPlayer(){
        return this.player;
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
    public String toString(){
        return this.getPlayer() + " has played " + this.getNbGamesPlayed() + " games and won " + this.getNbGamesWon() + " games.";
    }
}
