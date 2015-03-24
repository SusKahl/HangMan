

import java.io.Console;
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

    public static String secretWord = "Hello";
    public static String name;

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
        System.out.println("hello " + name);
        
        done = false;
        dashes = makeDashes(secretWord);
        
        while (!done) {
            System.out.print("Please enter the first letter :");
            String chars = sc.next();
            System.out.println("You have entered  " + chars);
            letter = guess.charAt(0);
            guesses += letter;
            if (secretWord.indexOf(letter) < 0) // not there
            {
                System.out.print("bad guess - ");
            } else // letter is in the secret
            {
                //	put it in dashes where it belongs
                checkChars(secretWord, dashes, letter);
            }
        }
    }

    public static void checkChars(String secret, StringBuffer dashes, char letter) {
        //here we will check the input if it is in the secret word              

        for (int index = 0; index < secret.length(); index++) {
            if (secret.charAt(index) == letter) {
                dashes.setCharAt(index, letter);
            }
        }
        System.out.print("good guess - ");

    }

    public static Boolean usedChars(String input){
        
        if(!usedChars.contains(input)){
             usedChars.push(input);
             return true;
        }else{
             return false;
        }
        
    }
    public static StringBuffer makeDashes(String s) {
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count = 0; count < s.length(); count++) {
            dashes.append('-');
        }
        return dashes;
    }
}
