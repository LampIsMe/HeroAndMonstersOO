public class Potion{
    int potionx;
    int potiony;
    int potency;
    public Potion(int potionnum){
        potionx = (int)(Math.random() * 15);
        potiony = (int)(Math.random() * 15);
        potency = (int)(Math.random() * 30) + 5;
    }

    public int getx(){
        return potiony;
    }

    public int gety(){
        return potionx;
    }

    public int Potency(){
        return potency;
    }

    public void resetx(){
        potiony = (int)(Math.random() * 10) ;
    }
    
    public void resety(){
        potionx = (int)(Math.random() * 10);
    }
}