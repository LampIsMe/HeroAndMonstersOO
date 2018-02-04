public class Sword{
    int damage;
    String type;
    public Sword(String swordtype){
        type = swordtype;
    }
    public void setType(String t){
        type = t;
        
    }
    public String getName(){
        return type;
        
    }
    
    public int getDamage(){
        if (type.equals("dagger")){
            damage = (int)(Math.random()*30) + 1;
            
        }else if (type.equals("short sword")){
            damage = (int)(Math.random()*20) + 30;
            
            
        }else if (type.equals("long sword")){
            damage = (int)(Math.random()*20) + 50;
            
            
        }else if (type.equals("battle axe (OP)")){
            damage = (int)(Math.random()*100) + 100;
        }
        return damage;
    }
}

