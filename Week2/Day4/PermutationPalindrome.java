import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class PermutationPalindrome
{

    public static boolean hasPalindrome(String t) 
    {

     int k;
     HashMap < Character, Integer > h = new HashMap < > ();

     for (k = 0; k < t.length(); k++) 
     {
         h.put(t.charAt(k), h.getOrDefault(t.charAt(k), 0) + 1);
     }

     int c = 0;

     for (char ch: h.keySet()) 
     {
         c += h.get(ch) % 2;
     }

     return c <= 1;
 
    }


    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindrome("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindrome("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindrome("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindrome("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindrome("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindrome("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PermutationPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}