public class Armor {
    private String type;
    private int durability;
    public Armor(String type){
        this.type = type;
        
        durability = ((int)(Math.random() * 40) + 20)/100;
    }
    public String getName(){
        return type;
    }

    public int getDefence(){
        return durability/100;
    }
    public String toString(){
        return type;
    }

}
