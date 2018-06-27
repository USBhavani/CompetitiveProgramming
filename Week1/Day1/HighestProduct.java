public class HighestProduct
{
 
  public static int maximumProduct(int[] value) 
  {
        int max_v1 = Integer.MIN_VALUE, max_v2 = Integer.MIN_VALUE, max_v3 = Integer.MIN_VALUE, min_v1 = Integer.MAX_VALUE, min_v2 = Integer.MAX_VALUE;
        for (int i : value) 
        {
            if (i > max_v1) 
            {
                max_v3 = max_v2;
                max_v2 = max_v1;
                max_v1 = i;
            } 
            else if (i > max_v2) 
            {
                max_v3 = max_v2;
                max_v2 = i;
            } 
            else if (i > max_v3) 
            {
                max_v3 = i;
            }

            if (i < min_v1) 
            {
                min_v2 = min_v1;
                min_v1 = i;
            } 
            else if (i < min_v2) 
            {
                min_v2 = i;
            }
        }
        return Math.max(max_v1 * max_v2 * max_v3, max_v1 * min_v1 * min_v2);
    }


    public static void main(String[] args) 
    {
        HighestProduct hp = new HighestProduct();
        int b[] = {7, 8, 3, 1, 9};
        System.out.println("The Highest product is: ");
        int ot= hp.maximumProduct(b);
        System.out.println(ot);
    }
}