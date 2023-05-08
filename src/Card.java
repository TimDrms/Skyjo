public class Card {
    private int value = 0;
    private boolean isReturned = false;
    Card(){
        this.value = 0;
        this.isReturned = false;
    }
    Card(int value){
        this.value = value;
    }
    Card(int value, boolean isReturned){
        this.value = value;
        this.isReturned = isReturned;

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


    @Override
    /**
     * toString method that is used when we want to print a card.
     * It will say the value of the card and if the card is returned or not.
     */
    public String toString() {
        if(this.isReturned == false){
            return "a " + this.value;
        }
        else{
            return "a " + this.value;
        }

    }
}
