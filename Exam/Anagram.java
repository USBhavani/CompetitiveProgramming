import java.util.*;

public class Anagram 
{
    public static void main(String[] args) 
    {
        String s = "rat";
        String t = "car";
        String a = s.replaceAll("[^A-Za-z]+", "");
        String z = t.replaceAll("[^A-Za-z]+", "");

        String y1 = a.toLowerCase();
        char[] k = y1.toCharArray();
        String y2 = z.toLowerCase();
        char[] l = y2.toCharArray();
        Arrays.sort(k);
        Arrays.sort(l);

        int q=0;
        for(int i=0; i<k.length; i++)
        {
            if(k[i] == l[i])
            {
                q++;
            }
        }

        if(q==k.length)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

        String s1 = "Debit Card";
        String t1 = "Bad Credit";
        String a1 = s1.replaceAll("[^A-Za-z]+", "");
        String z1 = t1.replaceAll("[^A-Za-z]+", "");

        String y3 = a1.toLowerCase();
        char[] m = y3.toCharArray();
        String y4 = z1.toLowerCase();
        char[] n = y4.toCharArray();
        Arrays.sort(m);
        Arrays.sort(n);

        int q1=0;
        for(int j=0; j<m.length; j++)
        {
            if(m[j] == n[j])
            {
                q1++;
            }
        }

        if(q1==m.length)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

    }

}











