import java.util.*;

public class TwoEgg
{

    public static int dropPoint(int n, int m) 
    {

        int floor[][] = new int[n+1][m+1];
        int rem;
        int k, l, t;
          
        for (k = 1; k <= n; k++)
        {
            floor[k][1] = 1;
            floor[k][0] = 0;
        }
          
        for (l = 1; l <= m; l++)
            floor[1][l] = l;

        for (k = 2; k <= n; k++)
        {
            for (l = 2; l <= m; l++)
            {
                floor[k][l] = Integer.MAX_VALUE;
                for (t = 1; t <= l; t++)
                {
                     rem = 1 + max(floor[k-1][t-1], floor[k][l-t]);
                     if (rem < floor[k][l])
                        floor[k][l] = rem;
                }
            }
        }
          
        return floor[n][m];
 
    }
    
    static int max(int a, int b) 
    { 
        return (a > b)? a: b; 
    }

    public static void main(String[] args) 
    {
        String testInput = "test input";
        System.out.println(dropPoint(2,100));
    }
}