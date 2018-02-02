import java.util.Scanner;
public class Monster{
    private int health;
    private int attack;
    private int speed;
    private int placey;
    private int placex;
    private boolean dead;
    private int hhealth;
    private int hdamage;
    public Monster(int monsternum){
        health = (int)(Math.random() * 100) + 1;
        attack = (int)(Math.random() * 30) + 1;
        speed = (int)(Math.random() * 4);
        placey = (int)(Math.random() * 15);
        placex = (int)(Math.random() * 15);
        dead = false;
    }

    public int gethealth(){
        return health;
    }

    public int getattack(){
        return attack;
    }

    public int getspeed(){
        return speed;   
    }

    public int getx(){
        return placex;
    }

    public int gety(){
        return placey;
    }

    public void resetx(){
        placex = (int)(Math.random() * 10);
    }

    public void resety(){
        placey = (int)(Math.random() * 10);
    }

    public int battle(int herohealth, int herodamage, int armor){
        hhealth = herohealth + armor;
        hdamage = herodamage;
        Scanner a = new Scanner(System.in);
        try{
            System.out.println("Battle has commenced");
            Thread.sleep (1000);
            while (dead == false){
                Thread.sleep(800);
                System.out.println("Monster has " + health + " health\nand " + attack + " attack power");
                Thread.sleep(800);
                System.out.println("Hero has " + hhealth + " health\nand "+ hdamage + " attack damage");
                Thread.sleep(800);
                System.out.println("Monster has attacked. Hero lost " + attack + " health");
                Thread.sleep(800);
                hhealth = hhealth - attack;
                if (hhealth < attack){
                    System.out.println("Hero is low on health");
                    System.out.println("Run away?");
                    String c = a.next();
                    if (c.equals("yes")||c.equals("Yes")){
                        System.out.println("You attempt to run away");
                        if (speed==1 ||speed ==0){
                            
                            System.out.println("You have successfuly ran away");
                            
                            dead = true;
                            return 1010;
                        }
                        else{
                            System.out.println("You have failed in running away");
                        }
                    }
                    
                    System.out.println("Hero has died");
                    dead = true;
                    return 0;
                }
                Thread.sleep(800);
                System.out.println("Hero attacks. Hero deals " + hdamage + " to the monster");
                health = health - hdamage;
                if (hdamage>health){
                    System.out.println("The monster has been slain");
                    dead = false;
                    return hhealth;
                }
                
            }
        }
        catch(InterruptedException e){System.out.println("got interrupted!");
        }

        return 0;
    }
    public int gethhealth(){
        return hhealth;
    }
    public String toString(){
        return ("Health: " + health + "\nAttack: " + attack + "\nSpeed: " + speed + "\n" + placey + ":" + placex);
    }
}
