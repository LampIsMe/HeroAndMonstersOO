import java.util.ArrayList;
public class Villager{
    ArrayList<Monster>monsterArray;
    int villagerx;
    int villagery;
    public Villager(int num){
        villagerx = (int)(Math.random() * 10) ;
        villagery = (int)(Math.random() * 10);
    }

    public String Vi(int num, ArrayList monsterArray){
        if (num == 1){
            if(monsterArray.size()==4){
                return ("Four monsters remaining");
            }
            return("Thx for saving me...");
        }
        if (num ==0){
            if(monsterArray.size()==2){
                return ("Two monsters remaining");
            }
            return("You saved my life");
        }

        return "";
    }import java.util.ArrayList;
import java.util.Scanner;
public class Villager{
    ArrayList<Monster>monsterArray;
    int villagerx;
    int villagery;
    public Villager(int num){
        villagerx = (int)(Math.random() * 15) ;
        villagery = (int)(Math.random() * 15);
        
    }

    public String Vi(int num){
        Scanner a = new Scanner(System.in);
        
        if (num ==0){
            System.out.println("That bag looks a bit small");
            System.out.println("Would you like to buy a Satchel for 30 gold");
            String answer = a.next().toLowerCase();
            if (answer.equals("yes")){
                return "Satchel";
            }
        }
        if (num == 1){
            
        }
        if (num == 3){
            System.out.println("Hi, I have a pair of Leather Sandels for you");
        }
        
        return "";
    }

    public int getx(){
        return villagery;
    }

    public int gety(){
        return villagerx;
    }

    public void resetx(){
        villagery = (int)(Math.random() * 10) ;
    }

    public void resety(){
        villagerx = (int)(Math.random() * 10);
    }
}

    public int getx(){
        return villagery;
    }

    public int gety(){
        return villagerx;
    }

    public void resetx(){
        villagery = (int)(Math.random() * 10) ;
    }

    public void resety(){
        villagerx = (int)(Math.random() * 10);
    }
}
