import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

public class DrawPile extends CardPile{
    public void generateDrawPile() throws IOException {
        //int nbPlayers = game.getNbPlayers();
        //Verify if the draw pile has already been generated
        if(this.cardPile.isEmpty()){
            //Open the file cards.txt containing the number of each card to initialize
            Scanner scan = new Scanner(System.in);
            File myObj = new File("./data/cards.txt");
            Scanner myReader = new Scanner(myObj);

            //the first number of each line is the value of the card and the second one is the quantity
            while (myReader.hasNextInt()){
                int value = myReader.nextInt();
                if(myReader.hasNextInt()){
                    int quantity = myReader.nextInt();
                    for (int i = 0; i < quantity; i++) {
                        this.cardPile.add(new Card(value, false));
                    }
                }
           }
            myReader.close();
            System.out.println("draw pile has been generated");

                //
            }
       else{
          System.out.println("The draw pile has already been generated.");
        }
    }
    public Card pickDrawCard(){
        if(cardPile.isEmpty()){
            System.out.println("Error: the draw pile is empty!");
            return new Card();
        }
        else{
            Collections.shuffle(this.cardPile);
            Card drawncard = new Card();
            drawncard = this.cardPile.get(0);
            this.cardPile.remove(0);
            return drawncard;
        }
    }


}
