public class AppleStocks
{

    public static int getMaxProfit(int[] stocks_price) 
    {
		int i;      
        if (stocks_price.length < 2) 
        {
            throw new IllegalArgumentException("Enter minimum two stock prices");
        }

        int min_amount = stocks_price[0];
        int max_profit = stocks_price[1] - stocks_price[0];  
         
        for (i = 1; i < stocks_price.length; i++) 
        {        
            max_profit = Math.max(max_profit, stocks_price[i] - min_amount);
            min_amount = Math.min(min_amount, stocks_price[i]);
        }

        return max_profit;
    }

    public static void main(String[] args) 
    {
        int[] s = new int[] {1, 2, 3, 4, 5};
        System.out.println(getMaxProfit(s));
    }
}