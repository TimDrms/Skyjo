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
}
