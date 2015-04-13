
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
 * @author Poul
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static String secretWord = "Hello";
    public static String name;
    public static String[] wordList
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
    public static int randomNumber = 0;
    public static String wordToGuess;
    public static Random randomGenerator = new Random();

    public static StringBuffer dashes;
    public static char letter;
    public static Boolean done;
    public static String guess;
    public static String guesses;

    public static Stack<String> usedChars;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello To Hangman 9000");
        System.out.println("Please Enter Your Name");
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

    public static void currentStatus() {
        int tries = 0;
        done = false;
        guesses = "";
        dashes = makeDashes(wordToGuess);
        while (!done) {
            System.out.println("Your word to guess: " + dashes);
            System.out.println("Guessed so far: " + guesses);
            System.out.println("Enter a guess: ");
            guess = sc.next().trim();
            letter = guess.toCharArray()[0];
            guesses += guess;

            if (guess.length() == 1) {
                checkChars(wordToGuess, dashes, letter);
            } else {
                tries++;
                System.out.println("You have " + (10 - tries) + " left");
            }
            
            if(dashes.toString().equals(wordToGuess)){
                System.out.println("YOU WIN!");
                done = true;
            }

            if (guess.length() >= 2) {
                if (guess.equals(wordToGuess)) {
                    System.out.println("YOU WIN!");
                } else {
                    tries++;
                    System.out.println("You have " + (10 - tries) + " left");
                }

            }

            if (tries == 10) {
                System.out.println("YOU LOSE!");
                done = true;
            }
        }
    }

    public static void checkChars(String secret, StringBuffer dashes, char letter) {
        //here we will check the input if it is in the secret word              

        int index = 0;
        
        for (int i = index; i < secret.length(); i++) {
            if (secret.charAt(i) == letter) {
                dashes.setCharAt(i, letter);
            } 
        }
        System.out.print("Good guess - ");

    }

    public static StringBuffer makeDashes(String s) {
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count = 0; count < s.length(); count++) {
            dashes.append('_');
        }
        return dashes;
    }

    public static Boolean usedChars(String input) {

        if (!usedChars.contains(input)) {
            usedChars.push(input);
            return true;
        } else {
            return false;
        }

    }

}
