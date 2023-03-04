import java.util.*;


class ArrayHelper extends Object
{
    public void PrintArray(int[] arrayToPrint)
    {
        for (int i = 0; i < arrayToPrint.length; ++i)
        {
            System.out.println(arrayToPrint[i]);
        }
    }
}

public class ICE_18_PrintArray extends Object
{
    public static void main(String[] args)
    {
        ArrayHelper ah = new ArrayHelper();
    
        // Now set up the array stuff, which is more interesting:
        int [] shortArray = new int[4];
        int i;
        for(i = 0; i < shortArray.length; i++)
        {
            shortArray[i] = (i + 1) * 2;
        }
        
        int [] longArray = new int[14];
        for(i = 0; i < longArray.length; i++)
        {
            longArray[i] = (i + 1) * 3;
        }
        // print out both arrays
        ah.PrintArray(shortArray);
        ah.PrintArray(longArray);
    }
}