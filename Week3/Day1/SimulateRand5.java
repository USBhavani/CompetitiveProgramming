import java.util.Random;

class SimulateRand5 {

    private static final Random r = new Random();

    private static int random7() 
    {
        return r.nextInt(7) + 1;
    }

    public static int random5() 
    {

      int t = 0 ;

        for (int i=0; i<5; i++)
        {
            t = t + random7();
        }

        return t / 5 ;

    }

  
    
    public static void main(String[] args) 
    {
        for (int i = 0; i < 10; i++) 
        {
            System.out.printf("%d ", random5());
        }
        System.out.println();
    }
}