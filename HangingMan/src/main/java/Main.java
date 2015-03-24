
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Hello To Hangman 9000");
        System.out.println("Please Enter Your Name");
        
        
         name = sc.next();
        
        System.out.println("hello " + name);
        
        System.out.print("Please enter the first letter :");
        String chars = sc.next();
        System.out.println("You have entered  " + chars);     
    }
    
        public static void checkChars(){
        //here we will check the input if it is in the secret word
        
    }
}
