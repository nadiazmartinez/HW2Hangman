import org.junit.*;     // JUnit tools

import java.util.*;     // Collections
import java.io.*;       // File access

/**
 * Modify this comment
 */
public class HangmanManagerTest {

    /* Loads the words in fileName and returns the set of all words in that file*/
    private Set<String> getDictionary(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            Set<String> dictionary = new HashSet<>();
            while(fileScanner.hasNext()) {
                dictionary.add(fileScanner.next());
            }
            return dictionary;
        } catch(FileNotFoundException e) {
            Assert.fail("Something went wrong.");      //Something went wrong
        }
        /* Should never be reached. */
        return new HashSet<>();
    }

    /**
     * Add comments
     */
    @Test
    public void test1(){
        try {
            Scanner input = new Scanner(new File("dictionary5.txt"));
            List<String> dictionary = new ArrayList<String>();
            HangmanManager test = new HangmanManager(dictionary, 5, 5);
            Assert.fail();
        } catch (FileNotFoundException a) {
            System.out.println("This dictionary doesn't exist.");
        }


    }
    /**
     * tests to determine if guessesLeft is works
     */
    @Test
    public void test2(){
        List<String> dictionary = new ArrayList<String>();
        HangmanManager a = new HangmanManager(dictionary, 5, 7);
        Assert.assertEquals(a.guessesLeft(), 7);
    }
    /**
     * test to determine if guessesLeft method works without any guesses
     */
    @Test
    public void test3(){
        List<String> dictionary = new ArrayList<String>();
        HangmanManager a = new HangmanManager(dictionary, 5, 0);
        Assert.assertEquals(a.guessesLeft(), 0);
    }
    /**
     * test to determine if the correct amount of dashes are displayed for dictionary2.txt
     */
    @Test
    public void test4() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary2.txt"));
        List<String> dictionary = new ArrayList<String>();
        while(input.hasNext())
            dictionary.add(input.next().toLowerCase());
        HangmanManager test = new HangmanManager(dictionary, 4, 4);
        Assert.assertEquals("- - - -", test.pattern());

    }
    /**
     * test to determine if the correct amount of dashes are displayed for dictionary.txt
     */
    @Test
    public void test5() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<String>();
        while(input.hasNext())
            dictionary.add(input.next().toLowerCase());
        HangmanManager test = new HangmanManager(dictionary, 7, 4);
        Assert.assertEquals("- - - - - - -", test.pattern());

    }
    /**
     * test to determine if record catches when letters are guessed twice from dictionary2.txt
     */
    @Test
    public void test6() {
        try{
            Scanner input = new Scanner(new File("dictionary2.txt"));
            List<String> dictionary = new ArrayList<String>();
            while (input.hasNext())
                dictionary.add(input.next().toLowerCase());
            HangmanManager test = new HangmanManager(dictionary, 4, 3);
            test.record('q');
            test.record('q');
            Assert.fail();
        } catch (IllegalArgumentException | FileNotFoundException a) {
            System.out.println("Letter was already guessed.");
        }

    }
    /**
     * test to determine if record catches when letters are guessed twice from dictionary.txt
     */
    @Test
    public void test7() {
        try{
            Scanner input = new Scanner(new File("dictionary.txt"));
            List<String> dictionary = new ArrayList<String>();
            while (input.hasNext())
                dictionary.add(input.next().toLowerCase());
            HangmanManager test = new HangmanManager(dictionary, 7, 8);
            test.record('q');
            test.record('q');
            Assert.fail();
        } catch (IllegalArgumentException | FileNotFoundException a) {
            System.out.println("Letter was already guessed.");
        }

    }
    /**
     * test to determine if record catches when there are no more guesses allowed
     */
    @Test
    public void test8() {
        try{
            List<String> dictionary = new ArrayList<String>();
            HangmanManager test = new HangmanManager(dictionary, 4, 2);
            test.record('q');
            test.record('w');
            test.record('e');
            Assert.fail();
        } catch (IllegalStateException a) {
            System.out.println("No more guesses allowed.");
        }

    }


}

