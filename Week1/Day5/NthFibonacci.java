import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class NthFibonacci
{

    static int[] g = new int[899];
    public static int fibonacci(int m) 
    {
        
    if (m == 0)
            return 0;
             
        if (m == 1 || m == 2)
            return (g[m] = 1);

        if (g[m] != 0)
            return g[m];
      
        int j = (m & 1) == 1? (m + 1) / 2
                            : m / 2;

        g[m] = (m & 1) == 1? (fibonacci(j) * fibonacci(j) + 
                        fibonacci(j - 1) * fibonacci(j - 1))
                       : (2 * fibonacci(j - 1) + fibonacci(j)) 
                       * fibonacci(j);
      
        return g[m];
    }



    // tests

    @Test
    public void zerothfibonaccionacciTest() {
        final int actual = fibonacci(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstfibonaccionacciTest() {
        final int actual = fibonacci(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondfibonaccionacciTest() {
        final int actual = fibonacci(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdfibonaccionacciTest() {
        final int actual = fibonacci(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthfibonaccionacciTest() {
        final int actual = fibonacci(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthfibonaccionacciTest() {
        final int actual = fibonacci(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void negativefibonaccionacciTest() {
        fibonacci(-1);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NthFibonacci.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}