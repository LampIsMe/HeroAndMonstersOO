import java.util.ArrayList;
import java.util.Scanner;
public class Map{
    ArrayList<Monsimport java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Map{
    ArrayList<Monster>monsterArray = new ArrayList<Monster>();
    ArrayList<Potion>potionArray = new ArrayList<Potion>(); 
    ArrayList<Potion>potionArray2 = new ArrayList<Potion>();
    ArrayList<Villager>villagerArray = new ArrayList<Villager>();
    Inventory inv = new Inventory();
    int [][]map = new int[15][15];
    String [][]printedMap = new String[15][15];
    Scanner scan = new Scanner(System.in);
    Hero ethan = new Hero();
    String b = "";
    public void Map(){
        boolean check = false;
        String t = "";
        monsterArray.add(new Monster(1));
        monsterArray.add(new Monster(2));
        monsterArray.add(new Monster(3));
        monsterArray.add(new Monster(4));
        monsterArray.add(new Monster(5));
        monsterArray.add(new Monster(6));
        potionArray.add(new Potion("Minor Healing Potion"));
        potionArray.add(new Potion("Healing Potion"));
        potionArray.add(new Potion("Major Healing Potion"));
        villagerArray.add(new Villager(1));
        villagerArray.add(new Villager(2));
        villagerArray.add(new Villager(3));
        villagerArray.add(new Villager(4));
        villagerArray.add(new Villager(5));
        while(check==false){
            for (int i = 0; i < 15; i ++){
                for (int j = 0; j < 15; j++){
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < 15; i ++){
                for (int j = 0; j < 15; j++){
                    printedMap[i][j] = "XXXX";
                }
            }
            map[ethan.getx()][ethan.gety()] = 9;            
            printedMap[14][0] = "HERO";
            boolean check1 = true;
            boolean check2 = true;
            boolean check3 = true;
            boolean check4 = true;
            boolean check5 = true;
            for (int i = 0; i < monsterArray.size(); i ++){
                if (map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]==0){
                    map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]=1;

                }
                else{
                    monsterArray.get(i).resetx();
                    monsterArray.get(i).resety();
                    check2 = false;
                }
            }

            for (int i = 0; i < potionArray.size(); i ++){
                if (map[potionArray.get(i).getx()][potionArray.get(i).gety()]==0){
                    map[potionArray.get(i).getx()][potionArray.get(i).gety()]=2;

                }
                else{
                    potionArray.get(i).resetx();
                    potionArray.get(i).resety();
                    check2 = false;
                }
            }

            for (int i = 0; i < villagerArray.size(); i ++){
                if (map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]==0){
                    map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]=5;
                }
                else{
                    villagerArray.get(i).resetx();
                    villagerArray.get(i).resety();
                    check5 = false;
                }
            }

            if(check1 == true && check2 == true && check3 == true && check4 == true && check5 == true){
                check = true;
            }

        }
        printMap(printedMap, t);
    }

    public void printMap(String[][] printedMap, String t){
        for (int i = 0; i < 15; i ++){
            for (int j = 0; j < 15; j++){
                t = t + " " + printedMap[i][j];
            }
            t = t + "\n";
        }
        System.out.println(t);
    }

    public String play(){
        Location loc = new Location();
        boolean pot = false;
        String a = scan.next();
        Scanner d = new Scanner(System.in);
        int rand=0;

        if (a.equals("w")){
            if (ethan.checkup()==true){
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray,  villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){

                        if(ethan.getx()-2 == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-2][ethan.gety()] = "MONS";
                            updateprintedMap(ethan.getx()-2, ethan.gety(), "MONS");

                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()][ethan.gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                        else if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-1][ethan.gety()+1] = "MONS";
                            updateprintedMap(ethan.getx()-1, ethan.gety()+1, "MONS");
                        }
                        else if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-1][ethan.gety()-1] = "MONS";
                            updateprintedMap(ethan.getx()-1, ethan.gety()-1, "MONS");
                        }
                    }
                    printMap2(printedMap, b);
                    int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(), ethan.getDefence(), ethan.getspeed());

                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                        printedMap[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]="XXXX";

                    }
                }
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray,  villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx()-2 == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-2][ethan.gety()] = "POTS";
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()][ethan.gety()] = "POTS";
                        }
                        else if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-1][ethan.gety()+1] = "POTS";
                        }
                        else if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[ethan.getx()-1][ethan.gety()-1] = "POTS";
                        }
                    }
                    printMap2(printedMap, b);
                    System.out.println(potionArray.get(rand).toString2());

                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                    printedMap[potionArray.get(rand).getx()][potionArray.get(rand).gety()]="XXXX";
                }
                if (loc.check(ethan.getx()-2,ethan.gety(), monsterArray, potionArray,  villagerArray)==5){
                    for (int i = 0; i < villagerArray.size(); i++){
                        if(ethan.getx()-3 == villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()] = "FARM";
                        }
                        else if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety() ==villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()] = "FARM";
                        }
                        else if(ethan.getx()-2 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()] = "FARM";
                        }
                        else if(ethan.getx()-2 == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()] = "FARM";
                        }
                    }
                    System.out.println("You have found a villager");
                    villagerArray.get(rand).Vi(rand);
                    
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    printMap2(printedMap, b);
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()]="XXXX";
                }
            }
            if (ethan.checkup() == true){
                System.out.println("\f");
                printMap2(printedMap, b);
                map[ethan.getx()][ethan.gety()]= 0;
                printedMap[ethan.getx()][ethan.gety()]= "XXXX";
                ethan.up();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }
        else if (a.equals("a")){
            if (ethan.checkleft() == true){
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray,  villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){
                        if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety()-2 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                    }
                    printMap2(printedMap, b);
                    int e= monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(),  ethan.getDefence(), ethan.getspeed());
                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());

                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                        printedMap[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]="XXXX";
                    }
                }
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray ,  villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety()-2 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                        }
                    }
                    printMap2(printedMap, b);
                    System.out.println(potionArray.get(rand).toString2());
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                    printedMap[potionArray.get(rand).getx()][potionArray.get(rand).gety()]="XXXX";
                }

                if (loc.check(ethan.getx(),ethan.gety()-2, monsterArray, potionArray ,  villagerArray)==5){
                    for (int i = 0; i < villagerArray.size(); i++){
                        if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()-2 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                        }
                        else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()-2 ==villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";

                        }
                        else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";

                        }
                        else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety()-3 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";

                        }
                    }
                    System.out.println("You have encountered a villager");
                    villagerArray.get(rand).Vi(rand);
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    printMap2(printedMap, b);
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    map[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()]=0;
                    printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()]="XXXX";
                }
                map[ethan.getx()][ethan.gety()]= 0;
                printedMap[ethan.getx()][ethan.gety()]= "XXXX";
                ethan.left();
                map[ethan.getx()][ethan.gety()]= 9;
                printedMap[ethan.getx()][ethan.gety()]= "HERO";
            }
        }
        else if (a.equals("s")){
            if (ethan.checkdown() == true){
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray,  villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){
                        if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx(), ethan.gety(), "MONS");
                        }
                        else if(ethan.getx()+2 == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx()+2, ethan.gety(), "MONS");
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx()+1, ethan.gety(), "MONS");
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                            printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                            updateprintedMap(ethan.getx()+1, ethan.gety()-1, "MONS");
                        }
                    }
                    printMap2(printedMap, b);
                    int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(),  ethan.getDefence(), ethan.getspeed());
                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                        printedMap[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]="XXXX";
                    }
                }
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray,  villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][monsterArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx()+2 == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][monsterArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][monsterArray.get(i).gety()] = "POTS";
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                            printedMap[potionArray.get(i).getx()][monsterArray.get(i).gety()] = "POTS";
                        }
                    }
                    printMap2(printedMap, b);
                    System.out.println(potionArray.get(rand).toString2());

                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                    printedMap[potionArray.get(rand).getx()][potionArray.get(rand).gety()]="XXXX";
                }

                if (loc.check(ethan.getx()+2,ethan.gety(), monsterArray, potionArray ,  villagerArray)==5){
                    for (int i = 0; i < villagerArray.size(); i++){
                        if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                        }
                        else if(ethan.getx()+3 == villagerArray.get(i).getx() && ethan.gety() ==villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                        }
                        else if(ethan.getx()+2 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                        }
                        else if(ethan.getx()+2 == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                            printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                        }
                    }
                    System.out.println("You have encountered a villager");
                    villagerArray.get(rand).Vi(rand);

                    printMap2(printedMap, b);
                    try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                    printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()] = "XXXX";
                }
                map[ethan.getx()][ethan.gety()]= 0;
                printedMap[ethan.getx()][ethan.gety()]= "XXXX";
                ethan.down();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }
        else if (a.equals("d")){
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray,  villagerArray)==1){
                System.out.println("You have encountered a monster");
                for (int i = 0; i < monsterArray.size(); i++){
                    if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                        rand = i;
                        printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                    }
                    else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                        rand = i;
                        printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                    }
                    else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety()+2 == monsterArray.get(i).gety()){
                        rand = i;
                        printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                    }
                    else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                        rand = i;
                        printedMap[monsterArray.get(i).getx()][monsterArray.get(i).gety()] = "MONS";
                    }
                }
                printMap2(printedMap, b);
                int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(), ethan.getDefence(), ethan.getspeed());
                if (e==0){
                    System.out.println("GAME OVER");
                    return "failed";
                }
                else if (e==1010){
                    System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                    ethan.updateHealth(monsterArray.get(rand).gethhealth());
                }
                else {
                    System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                    ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    printMap2(printedMap, b);
                    map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                    printedMap[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]="XXXX";
                }
            }
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray,  villagerArray)==2){
                for (int i = 0; i < potionArray.size(); i++){
                    if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                        rand = i;
                        printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                    }
                    else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                        rand = i;
                        printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                    }
                    else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety()+2 == potionArray.get(i).gety()){
                        rand = i;
                        printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                    }
                    else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                        rand = i;
                        printedMap[potionArray.get(i).getx()][potionArray.get(i).gety()] = "POTS";
                    }
                }
                printMap2(printedMap, b);
                System.out.println(potionArray.get(rand).toString2());

                try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
                map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                printedMap[potionArray.get(rand).getx()][potionArray.get(rand).gety()]="XXXX";
            }

            if (loc.check(ethan.getx(),ethan.gety()+2, monsterArray, potionArray,  villagerArray)==5){
                for (int i = 0; i < villagerArray.size(); i++){
                    if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()+2 == villagerArray.get(i).gety()){
                        rand = i;
                        printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                    }
                    else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()+2 == villagerArray.get(i).gety()){
                        rand = i;
                        printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                    }
                    else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety()+3 ==villagerArray.get(i).gety()){
                        rand = i;
                        printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                    }
                    else if(ethan.getx() ==villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                        rand = i;
                        printedMap[villagerArray.get(i).getx()][villagerArray.get(i).gety()] = "FARM";
                    }
                }
                System.out.println("You have found a villager");
                villagerArray.get(rand).Vi(rand);
                printMap2(printedMap, b);
                try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
                printedMap[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()]= "XXXX";
            }
            if (ethan.checkright()==true){
                map[ethan.getx()][ethan.gety()]= 0;
                printedMap[ethan.getx()][ethan.gety()]= "XXXX";
                ethan.right();
                map[ethan.getx()][ethan.gety()]= 9;
                printedMap[ethan.getx()][ethan.gety()]= "HERO";
            }
        }else{
            System.out.println("You need to use wasd to move");
        }
        if(potionArray2.size()>0){
            System.out.println("Would you like to equip your potion");
            String answer = d.next().toLowerCase();
            if(answer.equals("yes")){
                inv.setItem((potionArray2.get(0)), potionArray2.get(0).getPotency());
                potionArray2.remove(potionArray2.get(0));
            }
            try{Thread.sleep(1500);}catch(InterruptedException e){System.out.println("got interrupted!");
            }
        }
        if (inv.getSize()>0){
            System.out.println("You currently have " + inv.getSize() + " objects in your inventory");
            System.out.println("They are " + inv.inventory());
            System.out.println("Do you want to use an item?");
            String answer = d.next().toLowerCase();
            if(answer.equals("yes")){
                System.out.println("Which one(Press the corresponding index(1st item = 0, 2nd item = 1, etc.))");
                int answer2 = d.nextInt();
                int effect = inv.getEffect(answer2);
                Object item = inv.useItem(answer2);
                inv.removeItem(answer2);
                if (item.toString().equals("Minor Healing Potion")){
                    ethan.addHealth(effect);
                }
                else if (item.toString().equals("Healing Potion")){
                    ethan.addHealth(effect);
                }
                else if (item.toString().equals("Major Healing Potion")){
                    ethan.addHealth(effect);
                }
                
                System.out.println("Hero's current health is " + ethan.gethealth());
                try{Thread.sleep(2000);}catch(InterruptedException e){System.out.println("got interrupted!");
                }
            }
        }
        updateMap();
        updateprintedMap(0,0,"XXXX");
        printMap2(printedMap, b);

        if (monsterArray.size()==0){
            return "success";
        }
        if (ethan.gethealth()==0){
            return "failed";
        }else{

            return "playing";}

    }

    public void printMap2(String[][]map, String b){
        for (int i = 0; i < 15; i ++){
            for (int j = 0; j < 15; j++){
                b = b + " " + printedMap[i][j];
            }
            b = b + "\n";
        }
        System.out.print("\f");
        System.out.println(b);
        b = null;
    }

    public void updateMap(){
        for (int i = 0; i < monsterArray.size(); i ++){
            if(map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]!=1){
                monsterArray.remove(monsterArray.get(i));
            };
        }
        for (int i = 0; i < potionArray.size(); i ++){
            if(map[potionArray.get(i).getx()][potionArray.get(i).gety()]!=2){
                potionArray2.add(potionArray.get(i));
                potionArray.remove(potionArray.get(i));

            };
        }
        for (int i = 0; i < villagerArray.size(); i ++){
            if(map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]!=5){
                //villagerArray.remove(villagerArray.get(i));
            };
        }

    }

    public void updateprintedMap(int x, int y, String a){
        printedMap[x][y] = a;
        printedMap[ethan.getx()][ethan.gety()] = "HERO";

    }

    public int returnHealth(){
        return ethan.gethealth();
    }
}ter>monsterArray = new ArrayList<Monster>();
    ArrayList<Potion>potionArray = new ArrayList<Potion>(); 
    ArrayList<Sword>swordArray = new ArrayList<Sword>();
    ArrayList<Armor>armorArray = new ArrayList<Armor>();
    ArrayList<Potion>potionArray2 = new ArrayList<Potion>();
    ArrayList<Villager>villagerArray = new ArrayList<Villager>();
    int [][]map = new int[15][15];
    String [][]printedMap = new String[15][15];
    Scanner scan = new Scanner(System.in);
    Hero ethan = new Hero();
    public void Map(){
        boolean check = false;
        String t = "";
        monsterArray.add(new Monster(1));
        monsterArray.add(new Monster(2));
        monsterArray.add(new Monster(3));
        monsterArray.add(new Monster(4));
        monsterArray.add(new Monster(5));
        monsterArray.add(new Monster(6));
        potionArray.add(new Potion (1));
        potionArray.add(new Potion(2));
        swordArray.add(new Sword(1));
        armorArray.add(new Armor(1));
        villagerArray.add(new Villager(1));
        villagerArray.add(new Villager(2));

        while(check==false){
            for (int i = 0; i < 15; i ++){
                for (int j = 0; j < 15; j++){
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < 15; i ++){
                for (int j = 0; j < 15; j++){
                    printedMap[i][j] = "XXXX";
                }
            }
            map[ethan.getx()][ethan.gety()] = 9;            
            printedMap[14][0] = "HERO";
            boolean check1 = true;
            boolean check2 = true;
            boolean check3 = true;
            boolean check4 = true;
            boolean check5 = true;
            for (int i = 0; i < monsterArray.size(); i ++){
                if (map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]==0){
                    map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]=1;

                }
                else{
                    monsterArray.get(i).resetx();
                    monsterArray.get(i).resety();
                    check2 = false;
                }
            }

            for (int i = 0; i < potionArray.size(); i ++){
                if (map[potionArray.get(i).getx()][potionArray.get(i).gety()]==0){
                    map[potionArray.get(i).getx()][potionArray.get(i).gety()]=2;

                }
                else{
                    potionArray.get(i).resetx();
                    potionArray.get(i).resety();
                    check2 = false;
                }
            }

            for (int i = 0; i < swordArray.size(); i ++){
                if (map[swordArray.get(i).getx()][swordArray.get(i).gety()]==0){
                    map[swordArray.get(i).getx()][swordArray.get(i).gety()]=3;

                }
                else{
                    swordArray.get(i).resetx();
                    swordArray.get(i).resety();
                    check3 = false;
                }
            }

            for (int i = 0; i < armorArray.size(); i ++){
                if (map[armorArray.get(i).getx()][armorArray.get(i).gety()]==0){
                    map[armorArray.get(i).getx()][armorArray.get(i).gety()]=4;

                }
                else{
                    armorArray.get(i).resetx();
                    armorArray.get(i).resety();
                    check4 = false;
                }
            }

            for (int i = 0; i < villagerArray.size(); i ++){
                if (map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]==0){
                    map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]=5;

                }
                else{
                    villagerArray.get(i).resetx();
                    villagerArray.get(i).resety();
                    check5 = false;
                }
            }

            if(check1 == true && check2 == true && check3 == true && check4 == true && check5 == true){
                check = true;
            }

        }
        printMap(map, t);
    }

    public void printMap(int[][] map, String t){
        for (int i = 0; i < 15; i ++){
            for (int j = 0; j < 15; j++){
                t = t + " " + printedMap[i][j];
            }
            t = t + "\n";
        }
        System.out.println(t);
    }

    public String play(){
        Location loc = new Location();
        boolean pot = false;
        String a = scan.next();
        Scanner d = new Scanner(System.in);
        int rand=0;

        if (a.equals("w")){
            if (ethan.checkup()==true){

                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){
                        if(ethan.getx()-2 == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(), ethan.getDefence());
                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                    }
                }
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx()-2 == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained a health potion");

                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==3){
                    for (int i = 0; i < swordArray.size(); i++){
                        if(ethan.getx()-2 == swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == swordArray.get(i).getx() && ethan.gety()+1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == swordArray.get(i).getx() && ethan.gety()-1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have found a weapon");
                    ethan.addDamage(swordArray.get(rand).getDamage());
                    System.out.println("Current Attack Damage is... "+ethan.getequip());
                    map[swordArray.get(rand).getx()][swordArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==4){
                    for (int i = 0; i < armorArray.size(); i++){
                        if(ethan.getx()-2 == armorArray.get(i).getx() && ethan.gety() == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == armorArray.get(i).getx() && ethan.gety() ==armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == armorArray.get(i).getx() && ethan.gety()+1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == armorArray.get(i).getx() && ethan.gety()-1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have found a piece of armor");
                    ethan.addDefence(armorArray.get(rand).getDefence());
                    System.out.println("Current Armor is... "+ethan.getDefence());
                    map[armorArray.get(rand).getx()][armorArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()-1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==5){
                    for (int i = 0; i < villagerArray.size(); i++){
                        if(ethan.getx()-2 == villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety() ==villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have found a villager");
                    System.out.println(villagerArray.get(rand).Vi(rand,monsterArray));

                }
                map[ethan.getx()][ethan.gety()]= 0;
                ethan.up();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }
        else if (a.equals("a")){
            if (ethan.checkleft() == true){
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){
                        if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety()-2 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    int  e= monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(),  ethan.getDefence());
                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());

                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                    }
                }
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray , swordArray, armorArray, villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety()-2 == potionArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained a health potion");
                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray , swordArray, armorArray, villagerArray)==3){
                    for (int i = 0; i < swordArray.size(); i++){
                        if(ethan.getx()-1 == swordArray.get(i).getx() && ethan.gety()-1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == swordArray.get(i).getx() && ethan.gety()-1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == swordArray.get(i).getx() && ethan.gety()-2 == swordArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained a weapon");
                    ethan.addDamage(swordArray.get(rand).getDamage());
                    System.out.println("Current damage is... "+ethan.getequip());
                    map[swordArray.get(rand).getx()][swordArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray , swordArray, armorArray, villagerArray)==4){
                    for (int i = 0; i < armorArray.size(); i++){
                        if(ethan.getx()-1 == armorArray.get(i).getx() && ethan.gety()-1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == armorArray.get(i).getx() && ethan.gety()-1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == armorArray.get(i).getx() && ethan.gety() == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == armorArray.get(i).getx() && ethan.gety()-2 == armorArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained armor");
                    ethan.addDefence(armorArray.get(rand).getDefence());
                    System.out.println("Current Armor is... "+ethan.getDefence());
                    map[armorArray.get(rand).getx()][armorArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx(),ethan.gety()-1, monsterArray, potionArray , swordArray, armorArray, villagerArray)==5){
                    for (int i = 0; i < swordArray.size(); i++){
                        if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()-1 ==villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety()-2 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have encountered a villager");
                    System.out.println(villagerArray.get(rand).Vi(rand, monsterArray));
                    map[villagerArray.get(rand).getx()][villagerArray.get(rand).gety()]=0;
                }
                map[ethan.getx()][ethan.gety()]= 0;
                ethan.left();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }
        else if (a.equals("s")){
            if (ethan.checkdown() == true){
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==1){
                    System.out.println("You have encountered a monster");
                    for (int i = 0; i < monsterArray.size(); i++){
                        if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+2 == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()-1 == monsterArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(),  ethan.getDefence());
                    if(e==0){
                        System.out.println("GAME OVER");
                        return "failed";
                    }
                    else if (e==1010){
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    }
                    else {
                        System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                        ethan.updateHealth(monsterArray.get(rand).gethhealth());
                        map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                    }
                }
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray, swordArray, armorArray, villagerArray)==2){
                    for (int i = 0; i < potionArray.size(); i++){
                        if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+2 == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()-1 == potionArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained a health potion");
                    map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray , swordArray, armorArray, villagerArray)==3){
                    for (int i = 0; i < swordArray.size(); i++){
                        if(ethan.getx() == swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+2 == swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == swordArray.get(i).getx() && ethan.gety()+1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == swordArray.get(i).getx() && ethan.gety()-1 == swordArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained a weapon");
                    ethan.addDamage(swordArray.get(rand).getDamage());
                    System.out.println("Current damage is... "+ethan.getequip());
                    map[swordArray.get(rand).getx()][swordArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray , swordArray, armorArray, villagerArray)==4){
                    for (int i = 0; i < armorArray.size(); i++){
                        if(ethan.getx() == armorArray.get(i).getx() && ethan.gety() == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+2 == armorArray.get(i).getx() && ethan.gety() == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == armorArray.get(i).getx() && ethan.gety()+1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == armorArray.get(i).getx() && ethan.gety()-1 == armorArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have gained armor");
                    ethan.addDefence(armorArray.get(rand).getDefence());
                    System.out.println("Current Armor is... "+ethan.getDefence());
                    map[armorArray.get(rand).getx()][armorArray.get(rand).gety()]=0;
                }
                if (loc.check(ethan.getx()+1,ethan.gety(), monsterArray, potionArray , swordArray, armorArray, villagerArray)==5){
                    for (int i = 0; i < swordArray.size(); i++){
                        if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+2 == villagerArray.get(i).getx() && ethan.gety() ==villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                        else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()-1 == villagerArray.get(i).gety()){
                            rand = i;
                        }
                    }
                    System.out.println("You have encountered a villager");
                    System.out.println(villagerArray.get(rand).Vi(rand, monsterArray));

                }
                map[ethan.getx()][ethan.gety()]= 0;
                ethan.down();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }
        else if (a.equals("d")){
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==1){
                System.out.println("You have encountered a monster");
                for (int i = 0; i < monsterArray.size(); i++){
                    if(ethan.getx()-1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx()+1 == monsterArray.get(i).getx() && ethan.gety()+1 == monsterArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety()+2 == monsterArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == monsterArray.get(i).getx() && ethan.gety() == monsterArray.get(i).gety()){
                        rand = i;
                    }
                }
                int e = monsterArray.get(rand).battle(ethan.gethealth(), ethan.herodamage(), ethan.getDefence());
                if (e==0){
                    System.out.println("GAME OVER");
                    return "failed";
                }
                else if (e==1010){
                    System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                    ethan.updateHealth(monsterArray.get(rand).gethhealth());
                }
                else {
                    System.out.println("Your remaining health is " + monsterArray.get(rand).gethhealth());
                    ethan.updateHealth(monsterArray.get(rand).gethhealth());
                    //hihihi
                    map[monsterArray.get(rand).getx()][monsterArray.get(rand).gety()]=0;
                }
            }
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==2){
                for (int i = 0; i < potionArray.size(); i++){
                    if(ethan.getx()-1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx()+1 == potionArray.get(i).getx() && ethan.gety()+1 == potionArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety()+2 == potionArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == potionArray.get(i).getx() && ethan.gety() == potionArray.get(i).gety()){
                        rand = i;
                    }
                }
                System.out.println("You have gained a health potion");

                map[potionArray.get(rand).getx()][potionArray.get(rand).gety()]=0;
            }
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==3){
                for (int i = 0; i < swordArray.size(); i++){
                    if(ethan.getx()-1 == swordArray.get(i).getx() && ethan.gety()+1 == swordArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx()+1 == swordArray.get(i).getx() && ethan.gety()+1 == swordArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == swordArray.get(i).getx() && ethan.gety()+2 == swordArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() ==swordArray.get(i).getx() && ethan.gety() == swordArray.get(i).gety()){
                        rand = i;
                    }
                }
                System.out.println("You have gained a weapon");
                ethan.addDamage(swordArray.get(rand).getDamage());
                System.out.println("Current damage is... "+ethan.getequip());
                map[swordArray.get(rand).getx()][swordArray.get(rand).gety()]=0;
            }
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==4){
                for (int i = 0; i < armorArray.size(); i++){
                    if(ethan.getx()-1 == armorArray.get(i).getx() && ethan.gety()+1 == armorArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx()+1 == armorArray.get(i).getx() && ethan.gety()+1 == armorArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == armorArray.get(i).getx() && ethan.gety()+2 ==armorArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() ==armorArray.get(i).getx() && ethan.gety() == armorArray.get(i).gety()){
                        rand = i;
                    }
                }
                System.out.println("You have gained a piece of armor");
                ethan.addDefence(armorArray.get(rand).getDefence());
                System.out.println("Current armor "+ethan.getDefence());
                map[armorArray.get(rand).getx()][armorArray.get(rand).gety()]=0;
            }
            if (loc.check(ethan.getx(),ethan.gety()+1, monsterArray, potionArray, swordArray, armorArray, villagerArray)==5){
                for (int i = 0; i < villagerArray.size(); i++){
                    if(ethan.getx()-1 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx()+1 == villagerArray.get(i).getx() && ethan.gety()+1 == villagerArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() == villagerArray.get(i).getx() && ethan.gety()+2 ==villagerArray.get(i).gety()){
                        rand = i;
                    }
                    else if(ethan.getx() ==villagerArray.get(i).getx() && ethan.gety() == villagerArray.get(i).gety()){
                        rand = i;
                    }
                }
                System.out.println("You have found a villager");
                System.out.println(villagerArray.get(rand).Vi(rand, monsterArray));

            }
            if (ethan.checkright()==true){
                map[ethan.getx()][ethan.gety()]= 0;
                ethan.right();
                map[ethan.getx()][ethan.gety()]= 9;
            }
        }else{
            System.out.println("You need to use wasd to move");
        }
        if(potionArray2.size()>0){
            System.out.println("Would you like to use a potion");
            String answer = d.next().toLowerCase();
            if(answer.equals("yes")){
                ethan.addHealth(potionArray2.get(0).Potency());

                potionArray2.remove(potionArray2.get(0));
            }
            System.out.println("Current Health is..." + ethan.gethealth());
        }
        
        String b = "";
        updateMap();
        printMap2(map, b);

        if (monsterArray.size()==0){
            return "success";
        }
        if (ethan.gethealth()==0){
            return "failed";
        }else{

            return "playing";}

    }

    public void printMap2(int[][]map, String b){
        for (int i = 0; i < 15; i ++){
            for (int j = 0; j < 15; j++){
                b = b + " " + map[i][j];
            }
            b = b + "\n";
        }
        System.out.println(b);
        b = null;
    }

    public void updateMap(){
        for (int i = 0; i < monsterArray.size(); i ++){
            if(map[monsterArray.get(i).getx()][monsterArray.get(i).gety()]!=1){
                monsterArray.remove(monsterArray.get(i));
            };
        }
        for (int i = 0; i < potionArray.size(); i ++){
            if(map[potionArray.get(i).getx()][potionArray.get(i).gety()]!=2){
                potionArray2.add(potionArray.get(i));
                potionArray.remove(potionArray.get(i));

            };
        }

        for (int i = 0; i < swordArray.size(); i ++){
            if(map[swordArray.get(i).getx()][swordArray.get(i).gety()]!=3){
                swordArray.remove(swordArray.get(i));
            };
        }
        for (int i = 0; i < armorArray.size(); i ++){
            if(map[armorArray.get(i).getx()][armorArray.get(i).gety()]!=4){
                armorArray.remove(armorArray.get(i));
            };
        }
        for (int i = 0; i < villagerArray.size(); i ++){
            if(map[villagerArray.get(i).getx()][villagerArray.get(i).gety()]!=5){
                //villagerArray.remove(villagerArray.get(i));
            };
        }

    }

    public int returnHealth(){
        return ethan.gethealth();
    }
}
