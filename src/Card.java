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
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public void setIsReturned(boolean isReturned){
        this.isReturned = isReturned;
    }
    public boolean getIsReturded(){
        return this.isReturned;
    }

    @Override
    public String toString() {
        if(this.isReturned == false){
            return "The value of the card is " + this.value + " and this card isn't returned";
        }
        else{
            return "The value of the card is " + this.value + " and this card is returned";
        }

    }
}
