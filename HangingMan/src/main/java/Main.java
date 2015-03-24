
import java.io.Console;
import java.util.Random;
import java.util.Scanner;

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
    public static String secretWord = "Hello";
    public static String name;
    public static String[] wordList = { "computer", "java", "activity", "alaska",
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
            "terrible", "traffic", "unusual", "volume", "yesterday" };
    public static int randomNumber = 0;
    public static String wordToGuess;
    public static Random randomGenerator = new Random();
    
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Hello To Hangman 9000");
        System.out.println("Please Enter Your Name");
        
        
         name = sc.next();
        
        System.out.println("hello " + name);
        
        randomNumber = randomGenerator.nextInt(wordList.length);
        wordToGuess= wordList[randomNumber];
        
        for (char i : wordToGuess.toCharArray()){
            System.out.print("_ ");
        }
        System.out.println();
        
        System.out.print("Please enter the first letter :");
        String chars = sc.next();
        
        System.out.println("You have entered  " + chars);     
    }
    
        public static void checkChars(){
        //here we will check the input if it is in the secret word
        
    }
}
