import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class ParanthesisMatching {

    public static int getParanthesis(String a, int n) {
        
        Stack s = new Stack();
        s.push(a.charAt(n)) ;
        while (!s.empty()) {
        n++;
        if (a.charAt(n) == '(') s.push(a.charAt(n)) ;
        if (a.charAt(n) == ')' ) s.pop() ;
        }
        return n ;
    }

    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getParanthesis("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getParanthesis("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getParanthesis("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParanthesisMatching.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}