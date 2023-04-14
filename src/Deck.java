import java.util.ArrayList;
import java.util.Collections;

public class Deck extends CardPile{
    private int scoreRound; // Score of the round of the player who owns the deck.
    public void setScoreRound(int scoreRound){
        this.scoreRound = scoreRound;
    }
    public int getScoreRound(){
        return this.scoreRound;
    }
    public ArrayList initializeDeck(DrawPile drawPile){
        /* A FAIRE
        Initialiser les 12 cartes du jeu de manière aléatoire
        Il faudra modifier dans le Collections.shuffle() ce qu'il y a à l'intérieur comme variable. Actuellement c'est "deck", mais ça devra être la pile de carte dans DrawPile.
        Et la valeur à ajouter dans deck (qui s'appelle actuellement value), devra être une carte au hasard de cette pile.
        A FAIRE */
        for(int i = 0; i<4; i++){
            for(int j = 0; j<3; j++){
                Collections.shuffle(drawPile.getDrawPile());
                //this.deck.get(i).set(j,drawPile.getDrawPile().add(drawPile.pickDrawCard())); // Insère la carte dans l'emplacement [i][j] du deck.
            }
        }
        return this.cardPile;
    }
    public void returnCard(Card card){
        if(card.getIsReturded() == false){
            card.setIsReturned(true);
        }
        else{
            System.out.println("Error: this card has already been returned.");
        }
    }
}