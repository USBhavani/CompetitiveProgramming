import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class LargestStack {    

    public static class LarStack extends Stack {
        
        private Stack ab ;

	    public LarStack() 
	    {
	        ab = new Stack() ;
	    }

        public Object push(int n) 
        {
            
            if (ab.empty()) 
            {
	           ab.push(n);
	        }
	        else 
	        {
	            Object lar = ab.peek();
	            if ( n >=(Integer) lar)
	            ab.push(n);
	        }
	        return super.push((Integer)n);
        }

        public Object pop() 
        {
            Object s = peek() ;
	        if (s == ab.peek()) 
	        {
	            ab.pop() ;
	        }
	        return super.pop();
        }

        public Object getMax() 
        {
           if (ab.empty()) return null ;
        return ab.peek() ;
        }
    }


    // tests

    @Test
    public void LarStackTest() {
        final LarStack s = new LarStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LargestStack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}