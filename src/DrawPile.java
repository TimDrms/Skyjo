import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

public class DrawPile extends CardPile{
    /**
     * This method generate the DrawPile, it will be used at the beginning of each round.
     * The configuration of the drawPile is stored in the file cards.txt
     * For each line we read, we have an integer, who represent the number of card that will be created,
     * an integer for the value of those cards and a string for the name of those cards.
     * @throws IOException
     */
    public void generateDrawPile() throws IOException {
        //int nbPlayers = game.getNbPlayers();
        //Verify if the draw pile has already been generated
        if(this.getCardPile().isEmpty()){
            //Open the file cards.txt containing the number of each card to initialize
            Scanner scan = new Scanner(System.in);
            File myObj = new File("./data/cards.txt");
            Scanner myReader = new Scanner(myObj);

            //For each line :
            //We read the first number, which is the value of the card
            while (myReader.hasNextInt()){
                int value = myReader.nextInt();
                if(myReader.hasNextInt()){
                    //We read the second number, which is the quantity
                    int quantity = myReader.nextInt();
                    if(myReader.hasNext()){
                        //We read the name of the card
                        String name = myReader.next();
                        //We generate the quantity of card read from the file
                        for (int i = 0; i < quantity; i++) {
                            //Each card has the value and the name read from the file
                            this.getCardPile().add(new Card(value, name,false, false));
                        }
                    }

                }
           }
            myReader.close();
            }
       else{
          System.out.println("The draw pile has already been generated.");
        }
    }

    /**
     * This method will randomly pick a card in the draw card.
     * We use shuffle to mix all the card randomly, and then, we pick the first card of the drawPile and return it.
     * If the drawPile is empty, an error will be written in the console and an empty card will be return.
     * @return Card drawn
     */
    public Card pickDrawCard(){
        if(getCardPile().isEmpty()){
            System.out.println("Error: the draw pile is empty!");
            return new Card();
        }
        else{
            Collections.shuffle(this.getCardPile());
            Card drawncard = new Card();
            drawncard = this.getCardPile().get(0);
            this.getCardPile().remove(0);
            return drawncard;
        }
    }


}
