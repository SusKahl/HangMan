
import java.io.Console;
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

    public static StringBuffer dashes;
    public static char letter;
    public static Boolean done;
    public static String guess;
    public static String guesses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello To Hangman 9000");

        System.out.println("Please Enter Your Name");
        name = sc.next();
        System.out.println("hello " + name);
        guesses ="";
        done = false;
        dashes = makeDashes(secretWord);

        while (!done) {
            System.out.println("Here is your word: " + dashes);
            System.out.println("Guesses so far: " + guesses);
            System.out.print("Please enter a letter :");
            String guess = sc.next();
            System.out.println("You have entered  " + guess);
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

    public static StringBuffer makeDashes(String s) {
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count = 0; count < s.length(); count++) {
            dashes.append('-');
        }
        return dashes;
    }
}
