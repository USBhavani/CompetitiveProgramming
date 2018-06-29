import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class Inflight {

    public static boolean twoMovies(int[] x_time, int n) 
    {

      HashMap<Integer, Boolean> k = new HashMap<Integer, Boolean >();

            for(int i = 0; i < x_time.length; i++)
            {
                int dif = n -  x_time[i];
                if(k.get(dif) != null) return true;
        
                k.put( x_time[i], true);
        }

        return false;
    }




    // tests

    @Test
    public void shortFlightTest() {
        final boolean result = twoMovies(new int[] {2, 4}, 1);
        assertFalse(result);
    }

    @Test
    public void longFlightTest() {
        final boolean result = twoMovies(new int[] {2, 4}, 6);
        assertTrue(result);
    }

    @Test
    public void onlyOneMovieHalfFlightLenghtTest() {
        final boolean result = twoMovies(new int[] {3, 8}, 6);
        assertFalse(result);
    }

    @Test
    public void twoMoviesHalfnTest() {
        final boolean result = twoMovies(new int[] {3, 8, 3}, 6);
        assertTrue(result);
    }

    @Test
    public void lotsOfPossiblePairsTest() {
        final boolean result = twoMovies(new int[] {1, 2, 3, 4, 5, 6}, 7);
        assertTrue(result);
    }

    @Test
    public void oneMovieTest() {
        final boolean result = twoMovies(new int[] {6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = twoMovies(new int[] {}, 6);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Inflight.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}