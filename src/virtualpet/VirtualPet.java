/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Sara Wang
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //welcome screen
        File petopiaFile = new File("Petopia.txt");
        Scanner welcome = new Scanner(petopiaFile);
        String petopia = "";
        while (welcome.hasNext()) {
            petopia = petopia + welcome.nextLine() + "\n";
        }
        welcome.close();
        System.out.println(petopia);

        String inputDialog = JOptionPane.showInputDialog("Enter your username:");
        
        File userFile = new File(inputDialog);
        //if the user does not exist, create user and password
        if (!userFile.exists()) {
            String inputDialog2 = JOptionPane.showInputDialog("Enter your password:");
            PrintWriter pwPassword = new PrintWriter(userFile);
            pwPassword.println(inputDialog2);
        }
        //if the user exist
        else {
                String inputDialog2 = JOptionPane.showInputDialog("Enter your password:");
                Scanner readFile = new Scanner(userFile);
                String password = readFile.nextLine();
                //check if password enetered is coreect or not
                if (inputDialog2.equals (password)) {
                   
                }
                else {
                    System.out.println("Incorrect Password");
                }
        }
        
        System.out.println("Welcome, " + inputDialog + "!");
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter \"1\" or \"start\" for Start, \"2\" or \"instructions\" for Instructons, \"3\" or \"exit\" for Exit");
        String menu = keyboard.nextLine();
             
        do {
            
            //if user enter "2" or "instructions, show instructions
            if (menu.equalsIgnoreCase("2") || menu.equalsIgnoreCase("instructions")) {
                File instructionsFile = new File("Instructions.txt");
                Scanner file = new Scanner(instructionsFile);
                String instructions = "";
                while (file.hasNext()) {
                    instructions = instructions + file.nextLine() + "\n";
                }
                file.close();
                System.out.println(instructions);
            }
            
            //choose a pet
            Scanner start = new Scanner(System.in);
            System.out.println("Choose your pet from the following list: \nCat \nDog \nRabbit");
            String pet = start.nextLine();
            //user choose cat as their pet
            if (pet.equalsIgnoreCase ("cat")) {
                File catFile = new File("Cat.txt");
                Scanner cat1 =new Scanner(catFile);
                String cat = "";
                while (cat1.hasNext()) {
                    cat = cat + cat1.nextLine() + "\n";
                }
                cat1.close();
                System.out.println(cat);
            }
            //user choose dog as their pet
            else if (pet.equalsIgnoreCase ("dog")) {
                File dogFile = new File("Dog.txt");
                Scanner dog1 =new Scanner(dogFile);
                String dog = "";
                while (dog1.hasNext()) {
                    dog = dog + dog1.nextLine() + "\n";
                }
                dog1.close();
                System.out.println(dog);
            }
            //user choose rabbit as their pet
            else if (pet.equalsIgnoreCase ("rabbit")) {
                File rabbitFile = new File("Rabbit.txt");
                Scanner rabbit1 =new Scanner(rabbitFile);
                String rabbit = "";
                while (rabbit1.hasNext()) {
                    rabbit = rabbit + rabbit1.nextLine() + "\n";
                }
                rabbit1.close();
                System.out.println(rabbit);
            }
            
            int ng = keyboard.nextInt();
            
            //generate name for pet
            public String name(int ng) {
                Scanner inputName = new Scanner(System.in);
                String name = "    ";
                String[] vowels = {"a", "e", "i", "o", "u"};
                String[] consonant = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
                //user enter the name themselves
                Random r = new Random();
                if (ng == 1) {
                    System.out.println("Enter a name");
                    name = inputName.nextLine();
                //generate a four letter name woth consonants and vowels 
                } else if (ng == 2) {
                    int a = r.nextInt(consonant.length);
                    int b = r.nextInt(vowels.length); 
                    int c = r.nextInt(consonant.length);
                    int d = r.nextInt(vowels.length);
                    name.charAt(0) = consonant[a];
                    name.charAt(1) = vowels[b];
                    name.charAt(2) = consonant[c];
                    name.charAt(3) = vowels[a];
               return name;
            }
                
            //gernate random maxStats
            public int[] maxStats() {
                int[] ms = new int[3];
                Random r = new Random();
                //gererate a random max health
                int mh = r.nextInt(21);
                ms[0] = mh;
                //gererate a random max food
                int mf = r.nextInt(21 - mh);
                ms[1] = mf;
                //gererate a random max energy
                ms[2] = 20 - ms[0] - ms[1];
                return ms;
            }
            
            //index 0 = maxhealth, index 1 = maxfood, index 2 = maxenergy
            int[] maxStats = maxStats();
            
            int money = 0;
            
            //mini game - number guessing game
            public void numberGuessing(int money) {
                Random r = new Random();
                int rn = r.nextInt(101);
                int point = 0;
                Scanner input = new Scanner(System.in);
                for (int i = 0; i < 5; i++) {
                    System.out.println("Enter a number");
                    int inputNum = input.nextInt();
                    //if input number is larger than target number
                    if (inputNum > rn) {
                        System.out.println("Too high");
                    //if input number is lower than target number
                    } else if (inputNum < rn) {
                        System.out.println("Too low");
                    //if input number is the target number
                    } else {
                        System.out.println("Correct");
                        money = money + 1;
                        break;
                    }
                }
            }
            
            //index 0 = currenthealth, index 1 = currentfood, index 2 = currentenergy
            int[] currentStats = new int[3];
            
            //playing with pet
            public void playWithPet(int money, int[] currentStats) {
                //pay money
                money = money - 1;
                //current energy increase by 1
                currentStats[2] = currentStats[2] + 1;
                System.out.println("After playing with pet, the pet feels energized, current energy is increased by 1");
            }
            
            //feeding pet
            public void feedPet(int money, int[] currentStats) {
                //pay money
                money = money - 1;
                //current food increase by 1
                currentStats[1] = currentStats[1] + 1;
                System.out.println("After feeding pet, the pet feels less hungry, current food is increased by 1");
            }
                
            //grooming pet
            public void groomPet(int money, int[] currentStats) {
                //pay money
                money = money - 1;
                //current health increase by 1
                currentStats[0] = currentStats[0] + 1;
                System.out.println("After grooming pet, the pet becomes healthier, current health is increased by 1");
            }
            
            //store information
            boolean Append = true;
            FileWriter save = newFileWriter(inputDialog);
            PrintWriter append = newPrintWriter(save);
            append.println(pet + '\n' + money + '\n' + currentStats);
            
        //continue while the user does not enter "3" or "exit" to exit the program    
        } while (menu.equalsIgnoreCase ("3") || menu.equalsIgnoreCase ("exit"));
        //exit program
        System.exit(0);
     
    }
    
}
