public class Card {
    private int value = 0;
    private String name=null;
    private boolean isReturned = false;
    private boolean isColumn = false;
    Card(){
        this.value = 0;
        this.name = null;
        this.isReturned = false;
        this.isColumn = false;
    }
    Card(int value){
        this.value = value;
    }
    Card(int value, String name, boolean isReturned, boolean isColumn){
        this.value = value;
        this.name = name;
        this.isReturned = isReturned;
        this.isColumn = isColumn;
    }

    /**
     * Setter that will set the value of a card.
     * The value on the card must be between -2 and 12.
     *
     * @param value the value of the card
     */
    public void setValue(int value){
        if(value >= -2 && value <= 12){
            this.value = value;
        }
        else{
            System.out.println("Error: the value must be between -2 and 12!");
        }
    }

    /**
     * Getter that will return the value of a card
     *
     * @return the value of the card
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Getter that will return the name of the card
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter that will set the string in parameter as the name of the card
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter that will set if a card is returned or not
     *
     * @param isReturned boolean that say true if the card is returned, and false if the card isn't returned
     */
    public void setIsReturned(boolean isReturned){
        this.isReturned = isReturned;
    }

    /**
     * Getter that will return if a card is returned or not
     *
     * @return a boolean (true/false) that will say if a card is return or not
     */
    public boolean getIsReturned(){
        return this.isReturned;
    }

    /**
     * Setter that will set if a card is in a column with other identical cards or not
     *
     * @param isColumn boolean that say true if the card is in a column with other identical cards, and false if not
     */
    public void setIsColumn(boolean isColumn){
        this.isColumn = isColumn;
    }

    /**
     * Getter that will return if a card is in a column with other identical cards or not
     *
     * @return a boolean (true/false) that will say if a card is in a column with other identical cards or not
     */
    public boolean getIsColumn(){
        return this.isColumn;
    }


    @Override
    /**
     * toString method that is used when we want to print a card.
     * It will say the value of the card and will act according to whether the card is returned or not.
     */
    public String toString() {
        if(this.isReturned == false){
            return "a " + this.name;
        }
        else{
            return "a " + this.name;
        }

    }
}
