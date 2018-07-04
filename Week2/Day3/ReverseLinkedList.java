import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseLinkedList 
{

    public static class Node 
    {

        public int value;
        public Node next;

        public Node(int value) 
        {
            this.value = value;
        }
    }

    public static Node reverse(Node n) 
    {

        Node previous = null;
        Node present = n;
        Node next = null;
        while (present != null) 
        {
            next = present.next;
            present.next = previous;
            previous = present;
            present = next;
        }
        n = previous;
        return n;
    }

    // tests

    @Test
    public void shortLinkedListTest() {
        final Node[] nodes = valuesToNodes(new int[] {1, 2});
        final Node result = reverse(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void longLinkedListTest() {
        final Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4, 5, 6});
        final Node result = reverse(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void oneElementLinkedListTest() {
        final Node node = new Node(1);
        final Node result = reverse(node);
        assertSame(node, result);
    }

    @Test
    public void emptyLinkedListTest() {
        final Node result = reverse(null);
        assertNull(result);
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

    private static boolean isListReversed(Node list, Node[] originalNodes) {
        int i = originalNodes.length - 1;
        while (list != null && i >= 0) {
            if (originalNodes[i] != list) {
                return false;
            }
            list = list.next;
            i--;
        }
        return list == null;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseLinkedList.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}