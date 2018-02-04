import java.util.*;
public class Hero extends Items{
    private int health;
    Sword weapon;
    Armor armor;
    private int herox;
    private int heroy;
    private int damage;
    private int speed;
    public Hero(){
        health = 100;
        heroy = 0;
        herox = 14;
        weapon = new Sword("dagger");
        armor = new Armor("none");
        
        speed = 25;
    }

    public void addHealth(int add){
        health = add + health;
    }
    
    public int getspeed(){
        return speed;
    }
    
    public void setspeed(int a){
        speed = speed + a;
    }
    
    
    public double getDefence(){
        return armor.getDefence();
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
        return weapon.getDamage();
    }
    
    public void updateHealth(int herohealth){
        health = herohealth;
    }
}
