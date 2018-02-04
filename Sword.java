public class Sword extends Items{
    int damage;
    String type;
    public Sword(String swordtype){
        type = swordtype;
        setItem(type);
    }
    public void setType(String t){
        type = t;
        
    }
    public String getName(){
        return type;
        
    }
    
    public int getDamage(){public class Sword{
    int swordx;
    int swordy;
    int damage;
    public Sword(int swordnum){
        swordx = (int)(Math.random() * 10) ;
        swordy = (int)(Math.random() * 10);
        damage = (int)(Math.random() * 30) + 1;
    }

    public int getx(){
        return swordx;
    }

    public int gety(){
        return swordy;
    }

    public int getDamage(){
        return damage;
    }

    public void resetx(){
        swordx = (int)(Math.random() * 10) ;
    }
    
    public void resety(){
        swordy  = (int)(Math.random() * 10);
    }
}
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

