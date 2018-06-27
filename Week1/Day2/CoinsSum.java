import java.util.*;

class CoinsSum
{

    public static int make_change(int n, List<Integer> rp) 
    {
        int i, rem;
        int[] combinations = new int[n+1];
        for (i = 1; i <= n; i++) 
        {
            combinations[i] = 0;
        }

        combinations[0] = 1;
            
        for(int c:rp)
        {
            for (i = c; i <= n; i++) 
            {
                rem = i - c;
                combinations[i] += combinations[rem];
            }
        }

        System.out.println(Arrays.toString(combinations));
        return combinations[n];
    } 


    public static void main(String args[])
    {

        int total = 4;
        List<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(2);
        m.add(3);

        int b = make_change(total, m);
        System.out.println(b);
    }

}