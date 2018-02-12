import java.util.ArrayList;
public class Location{
    public Location(){

    }

    public int check(int herox, int heroy, ArrayList <Monster> monsterArray, ArrayList<Potion> potionArray, ArrayList<Villager>villagerArray){
        for (int i = 0; i < potionArray.size();i++){
            if (herox+1 == potionArray.get(i).getx() && heroy == potionArray.get(i).gety()){
                return 2;
            }
            //up of hero
            if (herox == potionArray.get(i).getx() && heroy+1 == potionArray.get(i).gety()){
                return 2;
            }
            //down of hero
            if (herox == potionArray.get(i).getx() && heroy - 1 == potionArray.get(i).gety()){
                return 2;
            }
            //left of hero
            if (herox - 1 == potionArray.get(i).getx() && heroy == potionArray.get(i).gety()){
                return 2;
            }
        }
        for (int i = 0; i < monsterArray.size(); i ++){
            //right of hero
            if (herox+1 == monsterArray.get(i).getx() && heroy == monsterArray.get(i).gety()){
                return 1;
            }
            //up of hero
            if (herox == monsterArray.get(i).getx() && heroy+1 == monsterArray.get(i).gety()){
                return 1;
            }
            //down of hero
            if (herox == monsterArray.get(i).getx() && heroy - 1 == monsterArray.get(i).gety()){
                return 1;
            }
            //left of hero
            if (herox - 1 == monsterArray.get(i).getx() && heroy == monsterArray.get(i).gety()){
                return 1;
            }
        }
        
        for (int i = 0; i < villagerArray.size(); i ++){
            //right of hero
            if (herox+1 == villagerArray.get(i).getx() && heroy == villagerArray.get(i).gety()){
                return 5;
            }
            //up of hero
            if (herox == villagerArray.get(i).getx() && heroy+1 == villagerArray.get(i).gety()){
                return 5;
            }
            //down of hero
            if (herox == villagerArray.get(i).getx() && heroy - 1 == villagerArray.get(i).gety()){
                return 5;
            }
            //left of hero
            if (herox - 1 == villagerArray.get(i).getx() && heroy == villagerArray.get(i).gety()){
                return 5;
            }
        }
        return 6;
    }
}
