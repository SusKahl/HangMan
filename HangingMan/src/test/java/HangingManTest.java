/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class HangingManTest {
    
    public HangingManTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestPopulateArray() {
        //Testing whether the array in the hangman game, is actually the one we create
        Hangman hm = new Hangman();
        String[] expected = hm.wordList;
        String[] actual = new String[]
            {
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
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void TestMakeDashes() {
        //Testing whether the length of the StringBuffer is correct, according to the word
        Hangman hm = new Hangman();
        String word = "expected"; 
        StringBuffer expected = new StringBuffer("--------");
        StringBuffer actual = hm.makeDashes(word);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    public void TestCheckCharsTrue(){
        //Testing for an input that exists in the word you need to guess
        Hangman hm = new Hangman();
        String word = "expected";
        String letter = "x";
        StringBuffer dashes = new StringBuffer("--------");
        
        boolean expected = true;
        boolean actual = hm.checkChars(word, dashes, letter.toCharArray()[0]);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void TestCheckCharsFalse(){
        //Testing for an input that does not exist in the word you need to guess
        Hangman hm = new Hangman();
        String word = "expected";
        String letter = "s";
        StringBuffer dashes = new StringBuffer("--------");
        
        boolean expected = true;
        boolean actual = hm.checkChars(word, dashes, letter.toCharArray()[0]);
        
        assertNotSame(expected, actual);
    }
    
    @Test
    public void TestCheckCharsInputNumber(){
        //Testing for an input that isn't a letter but a number
        Hangman hm = new Hangman();
        String word = "expected";
        String letter = "1";
        StringBuffer dashes = new StringBuffer("--------");
        
        boolean expected = true;
        boolean actual = hm.checkChars(word, dashes, letter.toCharArray()[0]);
        
        assertNotSame(expected, actual);
    }
}
