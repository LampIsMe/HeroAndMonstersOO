import java.util.*;
public class Driver{
    public static void main (String arg[]){
        Scanner scan = new Scanner(System.in);                     
        boolean play = true;
        boolean betrayal = false;
        Map map = new Map();
        try{
            System.out.println("A world of darkness...");
            Thread.sleep(100); 
            System.out.println("My harem is gone...");
            Thread.sleep(100);
            System.out.println("Where are they all?");
            Thread.sleep(100);
            System.out.println("Silence...");
            Thread.sleep(100);
            System.out.println("But wait...you see something moving...");
            Thread.sleep(100);
            System.out.println("Help...");
            Thread.sleep(100); 
            System.out.println("Do you want to save your harem?");
            Thread.sleep(100);
        }
        catch(InterruptedException e){System.out.println("got interrupted!");
        }
        System.out.println("Choices:\nyes\nno");
        String answer = scan.next();
        answer.toLowerCase();
        if (answer.equals("yes")){
            System.out.println("Hello sir?");
            System.out.println("I believe in you! You are the chosen one, the one who will save your harem!");
            betrayal = true;
        }else{
            System.out.println("Who wouldn't want to save a harem?! You still have to do it, sucks to be you");
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
                        System.out.println("You collapse down on the ground...");
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
                        System.out.println("Your harem is saved...");
                        Thread.sleep(2000);
                        System.out.println("THE END");
                        Thread.sleep(2000);
                        for (int i = 0; i < 5; i++){
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                            System.out.println("CREDITS TO ETHAN W. AND ETHAN W.");
                            Thread.sleep(500);
                        }	
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
