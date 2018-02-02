public class Sword{
    int swordx;
    int swordy;
    int damage;
    public Sword(int swordnum){
        swordx = (int)(Math.random() * 15) ;
        swordy = (int)(Math.random() * 15);
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