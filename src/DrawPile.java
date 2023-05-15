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
        //Verify if the draw pile has already been generated
        if(this.getCardPile().isEmpty()){
            //Open the file cards.txt containing the number of each card to initialize
            try{
                BufferedReader reader = new BufferedReader(new FileReader("./data/cards.txt")); // Read the file
                String line; // Line of the .txt file
                while ((line = reader.readLine()) != null) { // Read every lines
                    String[] parts = line.split(" "); // The separator between each value
                    int value = Integer.parseInt(parts[0]); // Read the first value (which is the value of the card)
                    int quantity = Integer.parseInt(parts[1]); // Read the second value (which is the quantity of the card in our draw pile)
                    String name = String.join(" ", parts[2]); // Read the third value (which is the name of the card)
                    for (int i = 0; i < quantity; i++) { // Creating the correct quantity of that card
                        this.getCardPile().add(new Card(value, name,false, false)); // Adding that card to the pile
                    }
                }
                reader.close(); // Closing the file
            } catch (IOException e){
                e.printStackTrace(); // Exception in case of error
            }



            /*Scanner scan = new Scanner(System.in);
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
            myReader.close();*/
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
