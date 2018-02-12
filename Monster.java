import java.util.Scanner;
public class Monster{
    private int health;
    private int attack;
    private int mspeed;
    private int placey;
    private int placex;
    private int hhealth;
    private int hdamage;
    private int probability;
    private int hspeed;
    private int monorientation;
    private boolean dead = false;
    public Monster(int monsternum){
        health = (int)(Math.random() * 100) + 1;
        attack = (int)(Math.random() * 30) + 1;
        mspeed = (int)(Math.random() * 15);
        monorientation = (int)(Math.random() * 3)-1;

    }

    public int getmonorientation(){
        return monorientation;
    }

    public int gethealth(){
        return health;
    }

    public int getattack(){
        return attack;
    }

    public int getspeed(){
        return mspeed;   
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

    public int battle(int herohealth, int herodamage, double armor, int speed, int orientation, Inventory inv){
        hhealth = herohealth;
        hdamage = herodamage;
        Scanner a = new Scanner(System.in);
        hspeed = speed;
        Inventory inve = inv;
        try{
            System.out.println("Battle has commenced");
            Thread.sleep (1000);
            while (dead == false){

                System.out.println("Monster has " + health + " health\nand " + attack + " attack power");

                System.out.println("Hero has " + hhealth + " health\nand "+ hdamage + " attack damage");

                System.out.println("Run away(yes) or fight(no)");
                String c = a.next();
                if (c.equals("yes")||c.equals("Yes")){
                    System.out.println("You attempt to run away");
                    if (hspeed-15 > mspeed){
                        if (checkOrientation(orientation)!=0){
                            System.out.println("You have successfully ran away");
                            Thread.sleep(800);
                            dead = true;
                            return 1010;
                        }
                    }
                    else{
                        System.out.println("You have failed in running away");
                        Thread.sleep(800);
                    }
                }
                else if (c.equals("open")){
                    System.out.println("You currently have " + inve.getSize() + " objects in your inventory");
                    System.out.println(inve.inventory());
                    if (inve.getSize()>0){
                        System.out.println("Do you want to use an item?");
                        String answer = a.next().toLowerCase();
                        if(answer.equals("yes")){
                            System.out.println("Which one(Press the corresponding index(1st item = 0, 2nd item = 1, etc.))");
                            int answer2 = a.nextInt();
                            int effect = inve.getEffect(answer2);
                            Object item = inve.useItem(answer2);
                            inve.removeItem(answer2);

                            if (item.toString().equals("short sword")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("long sword")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("battle axe (OP)")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("1/2 energy")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("full energy")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("pheonix down")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("breastplate")){
                                armor = armor + effect;
                            }
                            else if (item.toString().equals("bomb")){
                                hdamage = hdamage + effect;
                            }

                        }
                        try{Thread.sleep(2000);}catch(InterruptedException e){System.out.println("got interrupted!");
                        }

                    }
                }
                Thread.sleep(800);
                System.out.println("Monster has attacked. Monster attacks with " + attack);
                Thread.sleep(500);
                if (mspeed - hspeed >= 5){
                    hhealth = hhealth - (int)(attack * armor);
                }else{
                    System.out.println("Monster misses");
                    Thread.sleep(500);
                }
                System.out.println("Hero attacks. Hero attacks with " + hdamage);
                if (hspeed - mspeed >= 5){
                    health = health - hdamage;
                }else{
                    System.out.println("Hero misses");
                    Thread.sleep(500);
                }
                if (hdamage>health && hspeed - mspeed >5){
                    System.out.println("The monster has been slain");
                    Thread.sleep(1000);
                    dead = false;
                    return hhealth;
                }
                if (hhealth < attack && mspeed - hspeed > 5){
                    System.out.println("Hero has died");
                    dead = true;
                    return 0;}
                System.out.println("Monster has " + health + " health\nand " + attack + " attack power");

                System.out.println("Hero has " + hhealth + " health\nand "+ hdamage + " attack damage");

                System.out.println("Run away(yes) or fight(no)");
                String d = a.next();
                if (d.equals("yes")||d.equals("Yes")){
                    System.out.println("You attempt to run away");
                    if (hspeed-15 > mspeed){
                        if (checkOrientation(orientation)!=0){
                            System.out.println("You have successfully ran away");
                            Thread.sleep(800);
                            dead = true;
                            return 1010;
                        }
                    }
                    else{
                        System.out.println("You have failed in running away");
                        Thread.sleep(800);
                    }
                }
                else if (c.equals("open")){
                    System.out.println("You currently have " + inve.getSize() + " objects in your inventory");
                    System.out.println(inve.inventory());
                    if (inve.getSize()>0){
                        System.out.println("Do you want to use an item?");
                        String answer = a.next().toLowerCase();
                        if(answer.equals("yes")){
                            System.out.println("Which one(Press the corresponding index(1st item = 0, 2nd item = 1, etc.))");
                            int answer2 = a.nextInt();
                            int effect = inve.getEffect(answer2);
                            Object item = inve.useItem(answer2);
                            inve.removeItem(answer2);

                            if (item.toString().equals("short sword")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("long sword")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("battle axe (OP)")){
                                hdamage = hdamage + effect;
                            }
                            else if (item.toString().equals("1/2 energy")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("full energy")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("pheonix down")){
                                hhealth = hhealth + effect;
                            }
                            else if (item.toString().equals("breastplate")){
                                armor = armor + effect;
                            }
                            else if (item.toString().equals("bomb")){
                                hdamage = hdamage + effect;
                            }

                        }
                        try{Thread.sleep(2000);}catch(InterruptedException e){System.out.println("got interrupted!");
                        }

                    }
                }
                Thread.sleep(800);
                if (hdamage < 200){
                    System.out.println("Monster has attacked. Monster attacks with " + attack);
                    Thread.sleep(500);
                    if (mspeed - hspeed >= 5){
                        hhealth = hhealth - (int)(attack * armor);
                    }else{
                        System.out.println("Monster misses");
                        Thread.sleep(500);
                    }
                    System.out.println("Hero attacks. Hero attacks with " + hdamage);
                    if (hspeed - mspeed >= 5){
                        health = health - hdamage;
                    }else{
                        System.out.println("Hero misses");
                        Thread.sleep(500);
                    }
                    if (hdamage>health && hspeed - mspeed >5){
                        System.out.println("The monster has been slain");
                        Thread.sleep(1000);
                        dead = false;
                        return hhealth;
                    }
                    if (hhealth < attack && mspeed - hspeed > 5){
                        System.out.println("Hero has died");
                        dead = true;
                        return 0;}
                }
            }
        }
        catch(InterruptedException e){System.out.println("got interrupted!");
        }

        return 0;
    }

    public int checkOrientation(int orientation){
        if (monorientation == -1){
            if (orientation == 1){
                return 0;
            }
        }
        else if (monorientation == 1){
            if (orientation == - 1){
                return 0;
            }
        }
        else if (monorientation == 2){
            if (orientation == 0){
                return 0;
            }
        }
        else if (monorientation == 0){
            if (orientation == 2){
                return 0;
            }
        }
        return 5;
    }

    public void setX(int num){
        placex = num;
    }

    public void setY(int num){
        placey = num;
    }

    public int gethhealth(){
        return hhealth;
    }

    public String toString(){
        return ("Health: " + health + "\nAttack: " + attack + "\nSpeed: " + mspeed + "\n" + placey + ":" + placex);
    }
}
