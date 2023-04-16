import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

public class DrawPile extends CardPile{
    public void generateDrawPile() throws IOException {
        //int nbPlayers = game.getNbPlayers();
        if(this.cardPile.isEmpty()){
            Scanner scan = new Scanner(System.in);
            File myObj = new File("./data/cards.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextInt()){
                int value = myReader.nextInt();
                if(myReader.hasNextInt()){
                    int amount = myReader.nextInt();
                    for (int i = 0; i < amount; i++) {
                        this.cardPile.add(new Card(value, false));
                    }
                }
           }
            myReader.close();



                //
            }
       else{
          System.out.println("The draw pile has already been generated.");
        }
    }
    public void pickDrawCard(){
        if(cardPile.isEmpty()){
            System.out.println("Error: the draw pile is empty!");
        }
        else{
            Collections.shuffle(this.cardPile);
            System.out.println(this.cardPile.get(0));
        }
    }
    public String toString(){
        for(int i = 0 ; i<150 ; i++){
            System.out.println(String.valueOf(cardPile.get(i)));
        }
        return "";
    }

}
