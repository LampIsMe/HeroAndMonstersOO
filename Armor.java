public class Armor extends Items{
    private String type;
    private int durability;
    public Armor(String type){
        this.type = type;
        setItem(type);
        durability = (int)(Math.random() * 40) + 20;
    }
    public String getName(){
        return type;
    }

    public int getDefence(){
        return durability;
    }


}
