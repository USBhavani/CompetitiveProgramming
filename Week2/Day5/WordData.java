//import java.util.HashMap;
import java.util.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution 
{

    public static class WordCloudData 
    {

        private Map<String, Integer> arrWords = new HashMap<>();

        private void populateWordsToCounts(String s) 
        {

            // String w;
            Integer x = null;
            String t = s.replaceAll("[^A-Za-z '-]+", " ");
            String s2 = t.replaceAll("( )+", " ");
            
            String[] ft = s2.split(" ");
            for(String word:ft)
            {               
                
                if(!word.equals("-"))
                {
                    if(isCapital(word))
                    {
                        if(Arrays.asList(ft).contains(word)&&Arrays.asList(ft).contains(word.toLowerCase()))
                        {
                            x = arrWords.get(word.toLowerCase());
                            if (x == null) 
                            {
                                arrWords.put(word.toLowerCase(), 1);
                            } 
                            else 
                            {
                                arrWords.put(word.toLowerCase(), x+1);
                            }
                        }
                        else
                        {
                            x = arrWords.get(word);
                            if (x == null) 
                            {
                                arrWords.put(word, 1);
                            } 
                            else 
                            {
                                arrWords.put(word, x+1);
                            }
                        }
                    }
                    else
                    {
                    
                        x = arrWords.get(word);
                        if (x == null) 
                        {
                            arrWords.put(word, 1);
                        } 
                        else 
                        {
                            arrWords.put(word, x+1);
                        }
                    }
                }

            }
        }
        
        public boolean isCapital(String s)
        {
            char c = s.charAt(0);
            return c >= 'A' && c <= 'Z';
        }

        public WordCloudData(String k) 
        {
            populateWordsToCounts(k);
        }

        public Map<String, Integer> geteWordsToCounts() 
        {
            return arrWords;
        }
    }









    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2); 
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
                put("mmm", 2);
                put("decisions", 2); 
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.geteWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}