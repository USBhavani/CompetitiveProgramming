class ProductOther
{
    void multiply(int b[], int s) 
    {
        int i,j, tp = 1;
         
        int m[] = new int[s];

        for(j=0; j<s; j++)
            m[j]=1;
 
        for (i = 0; i < s; i++) 
        {
            m[i] = tp;
            tp *= b[i];
        }
 
        tp = 1;
 
        for (i = s - 1; i >= 0; i--) 
        {
            m[i] *= tp;
            tp *= b[i];
        }
        for (i = 0; i < s; i++)
            System.out.print(m[i] + " ");
 
        return;
    }
 
    public static void main(String[] args) 
    {
        ProductOther mn = new ProductOther();
        int x[] = {1, 2, 3, 4};
        System.out.println("The product bay is : ");
        mn.multiply(x, x.length);
    }
}