import java.util.ArrayList;
import java.util.Scanner;
public class Map{
    ArrayList<Monster>monsterArray = new ArrayList<Monster>();
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