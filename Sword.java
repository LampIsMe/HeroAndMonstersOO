public class Sword{
    int swordx;
    int swordy;
    int damage;
    String type;
    public Sword(int swordnum, String swordtype){
        swordx = (int)(Math.random() * 15) ;
        swordy = (int)(Math.random() * 15);
        
        type = swordtype;
    }
    public void setType(String t){
        type = t;
        
    }
    public String getType(){
        return type;
        
    }
    public int getx(){
        return swordx;
    }

    public int gety(){
        return swordy;
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

    public void resetx(){
        swordx = (int)(Math.random() * 10) ;
    }
    
    public void resety(){
        swordy  = (int)(Math.random() * 10);
    }
}