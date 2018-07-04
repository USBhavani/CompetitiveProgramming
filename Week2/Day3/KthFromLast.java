import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class KthFromLast {

    public static class Node 
    {
        public int value;
        public Node next;

        public Node(int value) 
        {
            this.value = value;
        }
    }

    public static Node nToLast(int m, Node h) 
    {       
        int l = 0,y=0, j;
        Node t = h;

        while (t != null)
        {
            t = t.next;
            l++;
        }

        if (l < m)
            m=l/0;
            
        if(m==0)
          y=l/m;
 
        t = h;
 
        for (j = 1; j < l-m+1; j++)
            t = t.next;

        return t;
    }


    // tests

    @Test
    public void firstToLastNodeTest() {
        final Node[] listNodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final int k = 1;
        final Node actual = nToLast(k, listNodes[0]);
        final Node expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void secondToLastNodeTest() {
        final Node[] listNodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final int k = 2;
        final Node actual = nToLast(k, listNodes[0]);
        final Node expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void firstNodeTest() {
        final Node[] listNodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final int k = 4;
        final Node actual = nToLast(k, listNodes[0]);
        final Node expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test(expected = Exception.class)
    public void kIsGreaterThanLinkedListlgthTest() {
        final Node[] listNodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final int k = 5;
        nToLast(k, listNodes[0]);
    }

    @Test(expected = Exception.class)
    public void kIsZeroTest() {
        final Node[] listNodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final int k = 0;
        nToLast(k, listNodes[0]);
    }

    private static Node[] valuesToNodes(int[] values) {
        final Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i]; 
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(KthFromLast.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}