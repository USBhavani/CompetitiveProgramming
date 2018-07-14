import java.io.*; 
  
class DecToBin 
{ 
 
    static int[] decToBinary(int n) 
    { 
 
        int[] binaryNum = new int[1000]; 

        int i = 0; 
        while (n > 0)  
        {
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
   
        return binaryNum;

    } 
      
    // driver program 
    public static void main (String[] args)  
    { 
        int[] b1 = new int[1000];
        int[] b2 = new int[1000];
        int k, c=0;

        int n = 25; 
        b1 = decToBinary(n); 
        // System.out.println("\n");
        // System.out.println(" ++++ ");
        int m = 30; 
        b2 = decToBinary(m); 


        for(k=0; k<8;k++)
        {
            System.out.print(b1[k]);
        } 

        System.out.println("\n");

        for(k=0; k<8;k++)
        {
            System.out.print(b2[k]);
        } 

        for(k=0;k<8;k++)
        {
            if(b1[k]==1 && b2[k]==1)
            {
                break;
            }
            else
            {
                c=c+1;
            }
        }

        System.out.print("\n");
        System.out.print(c);

    } 
} 