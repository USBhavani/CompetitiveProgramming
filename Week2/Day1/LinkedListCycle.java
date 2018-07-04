import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class LinkedListCycle {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean haveCycle(Node f_node) {

       Node x = f_node, y = f_node;
        while (x != null && y != null && y.next != null) 
        {
            x = x.next;
            y = y.next.next;
            if (x == y) 
            {
                return true;
            }
        }
        return false;
    }


    // tests

    @Test
    public void linkedListWithNoCycleTest() {
        final Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4});
        final boolean result = haveCycle(nodes[0]);
        assertFalse(result);
    }

    @Test
    public void cycleLoopsToBeginningTest() {
        final Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4});
        nodes[3].next = nodes[0];
        final boolean result = haveCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void cycleLoopsToMiddleTest()  {
        final Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4, 5});
        nodes[4].next = nodes[2];
        final boolean result = haveCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void twoNodeCycleAtEndTest() {
        final Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4, 5});
        nodes[4].next = nodes[3];
        final boolean result = haveCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void emptyListTest() {
        final boolean result = haveCycle(null);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListNoCycleTest() {
        final Node node = new Node(1);
        final boolean result = haveCycle(node);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListCycleTest() {
        final Node node = new Node(1);
        node.next = node;
        final boolean result = haveCycle(node);
        assertTrue(result);
    }

    private static Node[] valuesToNodes(int[] values) {
        final Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; ++i) {
            nodes[i] = new Node(values[i]);
            if (i > 0) {
                nodes [i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LinkedListCycle.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}