import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class BeastMode {

    public static Integer duplicate(int[] ar) 
    {
        int nd = 0 ;
        int next_nd_value = 0 ;
        int next_nd = 0 ;
        //int t = 0 ;
        while (nd < ar.length) 
        {
            next_nd = ar[nd] ;

            if (nd == next_nd ) 
            {
                nd++ ;
                continue ;
            }

            next_nd_value = ar[next_nd] ;

            while ( next_nd_value != next_nd ) 
            {
                ar[next_nd] = next_nd ;
                next_nd =  next_nd_value;
                next_nd_value = ar[next_nd] ;
            }
            return next_nd_value ;
        }
        return null ;
    
    }


    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = duplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = duplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = duplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = duplicate(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BeastMode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}