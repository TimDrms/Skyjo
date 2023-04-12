import java.util.ArrayList;
import java.util.Collections;

public class DrawPile {
    ArrayList<Card> drawPile = new ArrayList<>(150);
    public void generateDrawPile(ArrayList drawPile, Game game){
        int nbPlayers = game.getNbPlayers();
        if(this.drawPile.isEmpty()){
            // Generate (150 - 12 * nb_player) cards
            // I'm not sure if my variable nbPlayers will work.
            for(int i = 0; i < (150-12*nbPlayers); i++){
                // Generate the cards (how to generate all the different cards ???)
            }
        }
        else{
            System.out.println("The draw pile has already been generated.");
        }
    }
    public void pickDrawCard(ArrayList drawPile){
        if(drawPile.isEmpty()){
            System.out.println("Error: the draw pile is empty!");
        }
        else{
            Collections.shuffle(this.drawPile);
            System.out.println(this.drawPile.get(0));
        }
    }
}
