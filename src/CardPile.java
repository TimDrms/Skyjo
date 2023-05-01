import java.util.ArrayList;

public class CardPile {
    private ArrayList<Card> cardPile = new ArrayList<>(150);
    public String toString() {
        System.out.println(this.cardPile.size());
        for (int i = 0; i < this.cardPile.size(); i++) {
            System.out.println(String.valueOf(cardPile.get(i)));
        }
        return "";
    }

    public ArrayList<Card> getCardPile() {
        return cardPile;
    }

    public void setCardPile(ArrayList<Card> cardPile) {
        this.cardPile = cardPile;
    }
}
