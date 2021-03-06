import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int[] mergeArrays(int[] a, int[] b) {

        // combine the sorted arrays into one large sorted array
        int[] out = new int[a.length + b.length] ;
        int a_idx = 0;
        int b_idx = 0 ;

        while (a_idx < a.length && b_idx < b.length ) {
            if (a[a_idx] < b[b_idx]) {
                out[a_idx+b_idx]  = a[a_idx] ;
                a_idx++ ;
            } else if (a[a_idx] >= b[b_idx]) {
                out[a_idx+b_idx]  = b[b_idx] ;
                b_idx++ ;
            }
        }
        if (a_idx < a.length) {
            while (a_idx < a.length) {
                out[a_idx+b_idx]  = a[a_idx] ;
                a_idx++ ;
            }
        }
        if (b_idx < b.length) {
            while (b_idx < b.length) {
                out[a_idx+b_idx]  = b[b_idx] ;
                b_idx++ ;
            }
        }
        return out ;
    }




    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
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