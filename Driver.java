import java.util.*;
public class Driver{
    public static void main (String arg[]){
        Scanner scan = new Scanner(System.in);                     
        boolean play = true;
        boolean betrayal = false;
        Map map = new Map();
        try{
            System.out.println("A world of darkness...");
            Thread.sleep(500); 
            System.out.println("A city is left demolished...");
            Thread.sleep(500);
            System.out.println("There is no one left in sight...");
            Thread.sleep(500);
            System.out.println("Silence...");
            Thread.sleep(500);
            System.out.println("But wait...you see something moving...");
            Thread.sleep(500);
            System.out.println("Help...");
            Thread.sleep(500); 
            System.out.println("Is someone there?");
            Thread.sleep(500);
        }
        catch(InterruptedException e){System.out.println("got interrupted!");
        }
        System.out.println("Choices:\nyes\nno");
        String answer = scan.next();
        answer.toLowerCase();
        if (answer.equals("yes")){
            System.out.println("Thank you so much");
            System.out.println("Our city is in need of help, save us");
            betrayal = true;
        }else{
            System.out.println("You walk past the villager");
            betrayal = false;
        }
        System.out.println("Rules:\nMove around using the WASD keys\nDefeat all monsters\nSave the villagers\nGood luck");

        map.Map();
        while (play == true){
            if (map.play().equals("playing")){
                play = true;
            }else{
                play = false;
                if (map.play().equals("success")){
                    try{
                        System.out.println("As you strike the final blow...");
                        Thread.sleep(800);
                        System.out.println("You fall down...");
                        Thread.sleep(1000);
                        System.out.print("Exhausted...");
                        Thread.sleep(500);
                        System.out.print("Sore...");
                        Thread.sleep(500);
                        System.out.println("But the thing you feel the most of was...");
                        Thread.sleep(500);
                        System.out.println("Happiness...");
                        Thread.sleep(500);
                        System.out.println("You close your eyes knowing that...");
                        Thread.sleep(1000);
                        System.out.println("The world, at the very least this town, is safe once again...");
                        Thread.sleep(2000);
                        System.out.println("THE END");
                        break;
                    }
                    catch(InterruptedException e){System.out.println("got interrupted!");
                    }
                }
                else{
                    break;
                }
            }
        }

    }
}
