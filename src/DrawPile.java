import java.util.ArrayList;
import java.util.Collections;

public class DrawPile {
    ArrayList<Card> drawPile = new ArrayList<>(150);
    public void generateDrawPile(ArrayList drawPile, Game game){
        int nbPlayers = game.getNbPlayers();
        if(this.drawPile.isEmpty()){
            for (int value = -2; value <= 12; value++) {
                int quantity = 10;
                if (value == -2) {
                    quantity = 5;
                } else if (value == 0) {
                    quantity = 15;
                }
                for (int i = 0; i < quantity; i++) {
                    drawPile.add(new Card(value));
                }
            }

            // Generate (150 - 12 * nb_player) cards
            // I'm not sure if my variable nbPlayers will work.
                // Generate the cards (how to generate all the different cards ???)
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
