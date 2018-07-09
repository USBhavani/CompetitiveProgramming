import java.util.Random;

class SimulateRand7 
{

    private static final Random r = new Random();

    private static int random5() 
    {
        return r.nextInt(5) + 1;
    }

    public static int random7() 
    {
      int t = 0 ;

        for (int i=0; i<7; i++)
        {
            t = t + random5();
        }

        return t / 7;

    }

    public static void main(String[] args) 
    {
        for (int i = 0; i < 14; i++) 
        {
            System.out.printf("%d ", random7());
        }
        System.out.println();
    }
}