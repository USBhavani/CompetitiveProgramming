import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class SingleRiffleShuffle 
{

    public static boolean shuffle(int[] s1, int[] s2, int[] deck) 
    {

        int a1 = 0 ;
        int a2 = 0 ;
        int s1max=s1.length-1;
        int s2max=s2.length-1;
        for (int card:deck) 
        {
            if (a1<=s1max && card==s1[a1]  ) 
            {
                a1++ ;
            }
            else if (a2<=s2max&& card==s2[a2] ) 
            {
                a2++ ;
            }
            else
            {
                return false;
            }
        }
        return true ;

    }

    @Test
    public void bothHalvesAreTheSameLengthTest() {
        final int[] s1 = {1, 4, 5};
        final int[] s2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 4, 5, 6};
        final boolean result = shuffle(s1, s2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void halvesAreDifferentLengthsTest() {
        final int[] s1 = {1, 5};
        final int[] s2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 6, 3, 5};
        final boolean result = shuffle(s1, s2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void oneHalfIsEmptyTest() {
        final int[] s1 = {};
        final int[] s2 = {2, 3, 6};
        final int[] shuffledDeck = {2, 3, 6};
        final boolean result = shuffle(s1, s2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void shuffledDeckIsMissingCardsTest() {
        final int[] s1 = {1, 5};
        final int[] s2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 6, 3, 5};
        final boolean result = shuffle(s1, s2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void shuffledDeckHasExtraCards() {
        final int[] s1 = {1, 5};
        final int[] s2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 5, 6, 8};
        final boolean result = shuffle(s1, s2, shuffledDeck);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SingleRiffleShuffle.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}