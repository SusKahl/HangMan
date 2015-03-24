 import java.util.Scanner;
   import java.io.*;

    public class Main
   {
       public static void main(String[] args) throws IOException
      {
         Scanner kb = new Scanner(System.in);
         char again = 'n';
         String secret;
         StringBuffer dashes;
         final int MAXPARTS = 6;
         int bodyparts;
         boolean done;
         String guess;
         String guesses;
         char letter;
      	
         //Scanner infile = new Scanner(new FileReader("hangWords.txt"));
      
         do {
         // play a game
            secret = "win";
            guesses = "";
            done = false;
            bodyparts = MAXPARTS;
         
         // make dashes
            dashes = makeDashes(secret);
           
            while (! done)
            {
               System.out.println("Here is your word: " + dashes);
               System.out.println("Guesses so far: " + guesses);
               System.out.print("enter a guess (letter or word): ");
               guess = kb.next();
            // process the guess
            
               if (guess.length() > 1)  // process word guess
               {
                  if (guess.equals(secret))
                     System.out.println("you win!");
                  else
                     System.out.println("you lose");
                  done=true;
               }
               else // process single letter guess
               {
                  letter = guess.charAt(0);
                  guesses += letter;
                  if (secret.indexOf(letter) < 0)  // not there
                  {	--bodyparts;
                     System.out.print("bad guess - ");
                  }
                  else // letter is in the secret
                  {
                  	//	put it in dashes where it belongs
                     matchLetter(secret, dashes, letter);                                   
                  }
                  System.out.println(bodyparts + " bodyparts are left");
                  if (bodyparts == 0)
                  {	System.out.println("you lose");
                     done = true;
                  }
                  if (secret.equals(dashes.toString()))
                  {	System.out.println("you win!");
                     done = true;
                  }
               } // process single letter guess
            
            } // process whole guess
         
            if (infile.hasNext())
            {
               System.out.print("play again (y/n)?: ");
               again = kb.next().charAt(0);
            }
            else
               System.out.println("thanks for playing (no more words)");
         } while ( (again == 'Y' || again == 'y'));
      } // end of mainh
   
   
   /*
   	Change dashes to matching letter
   for position goes from 0 to secret length
   	if character at position in secret matches letter
   		put letter in that position in dashes
   	add 1 to position
   */
       public static void matchLetter(String secret, StringBuffer dashes, char letter)
      {
         for (int index = 0; index < secret.length(); index++)
            if (secret.charAt(index) == letter)
               dashes.setCharAt(index, letter);
         System.out.print("good guess - ");
      }
   
       public static StringBuffer makeDashes(String s)
      {
         StringBuffer dashes = new StringBuffer(s.length());
         for (int count=0; count < s.length(); count++)
            dashes.append('-');
         return dashes;
      }
   	
   
   }  // end of hangmanMethods