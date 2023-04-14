public class Main {
    public static void main(String[] args) {
        System.out.println("Create two cards.");
        Card card1 = new Card(8, false);
        Card card2 = new Card(12, true);
        System.out.println(card1);
        System.out.println(card2);

        System.out.println("--------------------------\nCreate a draw pile of 150 cards.");
        DrawPile drawPile1 = new DrawPile();
        drawPile1.generateDrawPile();
        System.out.println(drawPile1);

        System.out.println("\n Take 3 random cards from the draw pile.");
        for(int i = 0 ; i<=2 ; i++){
            drawPile1.pickDrawCard();
        }

        System.out.println("\n-------------------------------\nCreate a new player");
        Player player1 = new Player("SuperTimCraft");

        System.out.println("\nCreate a new deck");
        Deck deck1 = new Deck();

        System.out.println("\n Return 3 cards from our deck");
        for(int i = 0 ; i <= 2 ; i++){
            System.out.println("hi");
        }

        System.out.println("Aziz");
    }
}