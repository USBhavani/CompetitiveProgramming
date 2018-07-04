import java.util.Stack;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class QueueWithTwoStacks {    

    public static class Qstack  {

        private Stack<Integer> x = new Stack<>();
        private Stack<Integer> y = new Stack<>();
        
        public void enqueue(int n) 
        {
               x.push(n);
        }

        public int dequeue() 
        {

            while (!x.empty()) {
                y.push(x.pop());
        }
        Integer z =  y.pop();
        
        while (!y.empty()) {
            x.push(y.pop());
        }
        return z;

    }


}

    // tests

    @Test
    public void basicQueueOperationsTest() {
        final Qstack q = new Qstack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDeuqueFromNewQueueTest() {
        final Qstack q = new Qstack();
        q.dequeue();
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDeuqueFromEmptyQueueTest() {
        final Qstack q = new Qstack();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(QueueWithTwoStacks.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}