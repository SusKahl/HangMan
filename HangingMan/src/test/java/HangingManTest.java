/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Hangman hm = new Hangman();
        String word = "expected"; 
        StringBuffer expected = new StringBuffer("--------");
        StringBuffer actual = hm.makeDashes(word);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    public void Test(){
        
    }
}
