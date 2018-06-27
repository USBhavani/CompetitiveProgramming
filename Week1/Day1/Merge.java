import java.util.*;
import java.lang.*;
import java.io.*;

class schedule 
{
    int start;
    int end;

    schedule() 
    {
        start = 0;
        end = 0;
    }

    schedule(int st, int ed) 
    {
        start = st;
        end = ed;
    }
}

public class Merge 
{
    public static void main(String[] args) throws java.lang.Exception 
    {
        ArrayList<schedule> k = new ArrayList<schedule>();
        schedule t1 = new schedule(0, 1);
        schedule t2 = new schedule(3, 5);
        schedule t3 = new schedule(4, 7);
        schedule t4 = new schedule(10, 12);
        schedule t5 = new schedule(6, 8);

        k.add(t1);
        k.add(t2);
        k.add(t3);
        k.add(t4);
        k.add(t5);


        ArrayList<schedule> m = merge(k);

        for (schedule y : m) 
        {
            System.out.println(y.start + " " + y.end);
        }

    }

    public static ArrayList<schedule> merge(ArrayList<schedule> schedules) 
    {

        if (schedules.size() == 0)
            return schedules;
        if (schedules.size() == 1)
            return schedules;

        Collections.sort(schedules, new scheduleComparator());

        schedule ft = schedules.get(0);
        int start = ft.start;
        int end = ft.end;

        ArrayList<schedule> r1 = new ArrayList<schedule>();

        for (int i = 1; i < schedules.size(); i++) 
        {
            schedule cur = schedules.get(i);
            if (cur.start <= end) 
            {
                end = Math.max(cur.end, end);
            } else 
            {
                r1.add(new schedule(start, end));
                start = cur.start;
                end = cur.end;
            }

        }

        r1.add(new schedule(start, end));

        return r1;

    }
}

class scheduleComparator implements Comparator 
{
    public int compare(Object ob1, Object ob2) 
    {
        schedule s1 = (schedule) ob1;
        schedule s2 = (schedule) ob2;
        return s1.start - s2.start;
    }
}