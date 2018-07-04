import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class BracketValidator {

    public static boolean verify(String t) 
    {

        HashMap<Character, Character> h = new HashMap<Character, Character>();
		h.put('(', ')');
		h.put('[', ']');
		h.put('{', '}');
	 
		Stack<Character> x = new Stack<Character>();

		int k;
	 
		for (k = 0; k < t.length(); k++) 
		{
			char p = t.charAt(k);
	 
			if (h.keySet().contains(p)) 
			{
				x.push(p);
			} 
			else if (h.values().contains(p)) 
			{
				if (!x.empty() && h.get(x.peek()) == p) 
				{
					x.pop();
				} 
				else 
				{
					return false;
				}
			}
		}
	 
		return x.empty();
    }



    // tests

    @Test
    public void validShortCodeTest() {
        final boolean result = verify("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = verify("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = verify("([][]}");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = verify("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = verify("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = verify("");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BracketValidator.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}