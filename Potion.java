public class Potion{
    int potionx;
    int potiony;
    int potency;
    String type;
    public Potion(String inittype){
        potionx = (int)(Math.random() * 15);
        potiony = (int)(Math.random() * 15);
        type = inittype;
        if (type.equals("Minor Healing Potion" )){
            potency = (int)(Math.random()*30) + 1;
        }
        if (type.equals("Healing Potion")){
            potency = (int)(Math.random()*40) + 30;
        }
        if (type.equals("Major Healing Potion")){
            potency = (int)(Math.random()*40) + 50;
        }
    }

    public int getx(){
        return potiony;
    }

    public int gety(){
        return potionx;
    }

    public int getPotency(){
        return potency;
    }

    public void resetx(){
        potiony = (int)(Math.random() * 10) ;
    }

    public void resety(){
        potionx = (int)(Math.random() * 10);
    }

    public String toString2(){
        return "You have gained a " + type + "which heals " + getPotency();
    }

    public String toString(){
        return type;
    }

}
