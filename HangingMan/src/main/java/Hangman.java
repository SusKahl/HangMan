
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class Hangman {
    
    public  Scanner sc = new Scanner(System.in);
    public  String secretWord = "Hello";
    public  String name;
    public  String[] wordList
            = {
                "computer", "java", "activity", "alaska",
                "appearance", "javatar", "automobile", "falafel", "birthday",
                "canada", "central", "character", "chicken", "chosen", "cutting",
                "daily", "darkness", "shawarma", "disappear", "driving", "effort",
                "establish", "exact", "establishment", "fifteen", "football",
                "foreign", "frequently", "frighten", "function", "gradually",
                "hurried", "identity", "importance", "impossible", "invented",
                "italian", "journey", "lincoln", "london", "massage", "minerals",
                "outer", "paint", "particles", "personal", "physical", "progress",
                "quarter", "recognise", "replace", "rhythm", "situation",
                "slightly", "steady", "stepped", "strike", "successful", "sudden",
                "terrible", "traffic", "unusual", "volume", "yesterday"
            };
    public  int randomNumber = 0;
    public  String wordToGuess;
    public  Random randomGenerator = new Random();

    public  StringBuffer dashes;
    public  char letter;
    public  Boolean done;
    public  String guess;
    public  String guesses;
    public  int tries;

    public  Stack<String> usedChars;
    
    public Hangman(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello To Hangman 9000");
        System.out.print("Please Enter Your Name : ");
        name = sc.next();
        System.out.println("Hello " + name);

        randomNumber = randomGenerator.nextInt(wordList.length);
        wordToGuess = wordList[randomNumber];

        for (char i : wordToGuess.toCharArray()) {
            System.out.print("_ ");
        }
        System.out.println();
        currentStatus();
    }
    public  void currentStatus() {
        done = false;
        guesses = "";
        dashes = makeDashes(wordToGuess);
        while (!done) {
            System.out.println("Your word to guess: " + dashes);

            System.out.println("Gusses so far: " + guesses + " ");
            
            switch(tries){
                case 1: 
                    System.out.println("/^^^^^\"");
                    break;
                case 2: 
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 3: 
                    System.out.println("   |---------   ");
                    System.out.println("   |/       ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 4: 
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 5: 
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 6:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |        H");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 7:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |       |H");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 8:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |       |H|");
                    System.out.println("   |   ");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 9:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |       |H|");
                    System.out.println("   |       | |");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 10:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |       |H|");
                    System.out.println("   |       | |");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"");
                    break;
                case 11:  
                    System.out.println("   |---------   ");
                    System.out.println("   |/       |");
                    System.out.println("   |        O");
                    System.out.println("   |       |H|");
                    System.out.println("   |       | |");
                    System.out.println("   |   ");
                    System.out.println("/^^^^^\"    YOU LOSE!!!!");
                    break;
                    
            }

            System.out.print("Enter a guess: ");
            guess = sc.next().trim();
            letter = guess.toCharArray()[0];
            guesses += guess;

            if (guess.length() == 1) {
                checkChars(wordToGuess, dashes, letter);
            }
            
            if(dashes.toString().equals(wordToGuess)){
                System.out.println("YOU WIN!");
                done = true;
            }

            if (guess.length() >= 2) {
                if (guess.equals(wordToGuess)) {
                    System.out.println("YOU WIN!");
                    done = true;
                } else {
                    System.out.println("You have " + (10 - tries) + " left");
                    tries++;
                }

            }

            if (tries == 11) {
                System.out.println("YOU LOSE!");
                done = true;
            }
        }
    }

    public  void checkChars(String secret, StringBuffer dashes, char letter) {
        //here we will check the input if it is in the secret word              
        boolean correct = false;
        int index = 0;
        
        for (int i = index; i < secret.length(); i++) {
            if (secret.charAt(i) == letter) {
                dashes.setCharAt(i, letter);
                correct = true;
            }
        }
        
        if(correct){
            System.out.println("Good guess -");
        } else{
            System.out.println("You have " + (10 - tries) + " left");
            tries++;
        }

    }

    public  StringBuffer makeDashes(String s) {
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count = 0; count < s.length(); count++) {
            dashes.append('_');
        }
        return dashes;
    }

    public  Boolean usedChars(String input) {

        if (!usedChars.contains(input)) {
            usedChars.push(input);
            return true;
        } else {
            return false;
        }

    }
}
