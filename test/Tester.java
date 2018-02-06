import java.lang.*;
import java.util.*;

public class Tester
{
    public static void main(String[] args)
    {
        System.out.println("Tests are up and running...");
        
        Test("Sum of empty list is zero", () -> 
        {   
            List<Integer> emptyList = new ArrayList<Integer>();
            int sum = Util.Sum(emptyList);
            AreEqual(0, sum);
        });

        Test("Sum(1 .. 10) = 55", () ->
        {
            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= 10; i++) 
            {
                numbers.add(i);
            }
            int sum = Util.Sum(numbers);
            AreEqual(55, sum);
        });
    }


    public static void Test(String testName, Runnable expresstion)
    {
        try 
        {
            expresstion.run();
            System.out.println(testName + " | Passed");
        }
        catch (Exception ex)
        {
            System.out.println(testName + " | Failed");   
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for(StackTraceElement el : stackTrace) 
            {
                System.out.println(el.toString()); 
            }
        }
    }


    public static <T extends Comparable<T>> void AreEqual(T x, T y, String msg)
    {
        if (x.compareTo(y) != 0) 
        { 
            throw new Error("Expected " + x + " but got " + y + "\n" + msg);
        }
    }

    public static <T extends Comparable<T>> void AreEqual(T x, T y)
    {
        if (x.compareTo(y) != 0) 
        {
            throw new Error("Expected " + x + " but got " + y);
        }
    }

}