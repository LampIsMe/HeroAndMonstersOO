public class Sword{
    int damage;
    String type;
    
    public Sword(String swordtype){
        type = swordtype;
        if (type.equals("short sword")){
            damage = (int)(Math.random()*30) + 30;
            
        }else if (type.equals("long sword")){
            damage = (int)(Math.random()*20) + 50;
            
            
        }else if (type.equals("battle axe (OP)")){
            damage = (int)(Math.random()*100) + 100;
        }
    }
    public void setType(String t){
        type = t;
        
    }
    public int getDamage(){
        return damage;
    }
    public String getName(){
        return type;
        
    }
    public String toString(){
        return type;
    }
}
