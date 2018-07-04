import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class DeleteNode {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(Node n) {

        Node s = n.next;
        n.value = s.value;
        n.next = s.next;
    }


    // tests

    @Test
    public void nodeAtBeginningTest() {
        Node head = new Node(1); 
        appendToList(head, 2);
        appendToList(head, 3);
        appendToList(head, 4);

        deleteNode(head);

        Node node = head;
        assertEquals(2, node.value);

        node = node.next;
        assertEquals(3, node.value);

        node = node.next;
        assertEquals(4, node.value);

        assertNull(node.next);
    }

    @Test
    public void nodeInTheMiddleTest() {
        Node head = new Node(1);
        Node nodeToDelete = appendToList(head, 2);
        appendToList(head, 3);
        appendToList(head, 4);

        deleteNode(nodeToDelete);

        Node node = head;
        assertEquals(1, node.value);

        node = node.next;
        assertEquals(3, node.value);

        node = node.next;
        assertEquals(4, node.value);

        assertNull(node.next);
    }

    @Test(expected = Exception.class)
    public void nodeAtTheEndTest() {
        Node head = new Node(1);
        appendToList(head, 2);
        appendToList(head, 3);
        Node nodeToDelete = appendToList(head, 4);

        deleteNode(nodeToDelete);
    }

    @Test(expected = Exception.class)
    public void oneNodeListTest() {
        Node head = new Node(1);
        deleteNode(head);
    }

    private static Node appendToList(final Node head, int value) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        return current.next;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DeleteNode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}