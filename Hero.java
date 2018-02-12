import java.util.*;
public class Hero{
    private int health;
    private int daggerdamage;
    private double armor;
    private int herox;
    private int heroy;
    private int damage;
    private int speed;
    private int gold;
    public Hero(){
        health = 100;
        heroy = 0;
        herox = 14;
        daggerdamage = (int)(Math.random()*40)+150;
        armor = 0.0;
        speed = 25;
        gold = 500;
    }
    
    

    public boolean checkup(){
        if (herox -1<0){
            System.out.println("You moved out of bounds");
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
            return false;
        }
        return true;
    }

    public boolean checkleft(){
        if (heroy -1<0){
            System.out.println("You moved out of bounds");
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
            return false;
        }
        return true;
    }

    public boolean checkright(){
        if (heroy +1>14){
            System.out.println("You moved out of bounds");
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
            return false;
        }
        return true;
    }

    public boolean checkdown(){
        if (herox +1>14){
            System.out.println("You moved out of bounds");
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
            return false;
        }
        return true;
    }

    public int getx(){
        return herox;
    }

    public int gety(){
        return heroy;
    }

    public int gethealth(){
        return health;
    }
    
    public int herodamage(){
        return daggerdamage;
    }
    
    public void updateHealth(int herohealth){
        health = herohealth;
    }
    public int getGold(){
        return gold;
    }
    public void addGold(int add){
        gold = gold + add;
    }
    public void addHealth(int add){
        health = add + health;
    }
    public void spend(int substract){
        gold = gold - substract;
    }
    public void addDamage(int add){
        daggerdamage = add +daggerdamage;
    }
    
    public int getspeed(){
        return speed;
    }
    
    public void setspeed(int a){
        speed = a;
    }
    public void addDefence(double add){
        armor = add + armor;
    }
    
    public double getDefence(){
        return armor;
    }
    
    public void up(){
        herox = herox -1;
    }

    public void left(){
        heroy = heroy -1;
    }

    public void right(){
        heroy = heroy + 1;
    }

    public void  down(){
        herox = herox + 1;
    }
}
