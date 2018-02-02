public class Armor{
    int armorx;
    int armory;
    int durability;
    public Armor(int armornum){
        armorx = (int)(Math.random() * 15) ;
        armory = (int)(Math.random() * 15);
        durability = (int)(Math.random() * 40) + 20;
    }

    public int getx(){
        return armorx;
    }

    public int gety(){
        return armory;
    }

    public int getDefence(){
        return durability;
    }

    public void resetx(){
        armorx = (int)(Math.random() * 10) ;
    }
    
    public void resety(){
        armory = (int)(Math.random() * 10) ;
    }
}