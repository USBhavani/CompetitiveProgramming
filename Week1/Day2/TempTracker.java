public class TempTracker 
{

    // min and max
    static Integer minTp;
    static Integer maxTp;

    // mean
    static Double mean;
    static int totalNum = 0;
    static double sum = 0.0; 

    // mode
    static Integer mode;
    static int[] count = new int[120]; 
    static int maxcount = 0;

    public static void insert(int tp) 
    {

        // min and max
        if (maxTp==null || tp>maxTp) 
        {
            maxTp = tp;
        }
        if (minTp==null || tp<minTp) 
        {
            minTp = tp;
        }

        // mean
        totalNum++;
        sum = sum + tp;
        mean = sum / totalNum;

        // mode
        count[tp]++;
        if (count[tp] > maxcount) 
        {
            mode = tp;
            maxcount = count[tp];
        }

    }

    public static Integer getMin() 
    {
        return minTp;
    }

    public static Integer getMax() 
    {
        return maxTp;
    }

    public static Double getMean() 
    {
        return mean;
    }

    public static Integer getMode() 
    {
        return mode;
    }

    public static void main(String[] args) 
    {
    	insert(50);
    	System.out.println("Max: " + getMax() + " Min: " + getMin() + " Mean: " + getMean() + " Mode: " + getMode());
    	insert(50);
    	System.out.println("Max: " + getMax() + " Min: " + getMin() + " Mean: " + getMean() + " Mode: " + getMode());
    	insert(70);
    	System.out.println("Max: " + getMax() + " Min: " + getMin() + " Mean: " + getMean() + " Mode: " + getMode());
    	insert(20);
    	System.out.println("Max: " + getMax() + " Min: " + getMin() + " Mean: " + getMean() + " Mode: " + getMode());
    }
}