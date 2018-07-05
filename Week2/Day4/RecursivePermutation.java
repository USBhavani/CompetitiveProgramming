import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class RecursivePermutation 
{

    public static Set<String> permuation(String t) 
    {      
        Set<String> hs = new HashSet<>() ;
        recur(t, "", hs) ;
        return hs ;
    }


    private static void recur(String t, String f, Set<String> hs) 
    {
        if (t.length() == 0) 
        {
            hs.add(f) ;
            return ;
        }
        for (int k=0; k< t.length(); k++ ) 
        {
            recur(t.substring(0,k) + t.substring(k+1) , f+t.charAt(k) , hs) ;
        }
    }



    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = permuation("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = permuation("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = permuation("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = permuation("abc");
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RecursivePermutation.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}