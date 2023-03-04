import java.util.Scanner;

class ArrayHelper extends Object
{

    // Copy this from the previous in class exercise
    public void PrintArray(int[] arrayToPrint)
    {
        for (int i = 0; i < arrayToPrint.length; ++i)
        {
            System.out.println(arrayToPrint[i]);
        }
    }

	 // This is the code you need to fill in
    public void FindInArray(int[] arrayToFind, int numberToFind) // DON'T FORGET TO FILL IN THE STUFF IN THE PARENS!
    {
	 	for (int i = 0; i < arrayToFind.length; ++i)
	 	{
	 	    if (numberToFind == arrayToFind[i])
	 	    {
	 	        int index = i;
	 	        System.out.println(numberToFind + " is at index " + index);
	 	    }
	 	}
    }
}

public class ICE_18_FindInArray extends Object
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
        // We want to put numbers into the long array in reverse order
        // we should thus count DOWN through the slot numbers, 
        // and simultaneously have counter count UP
        int counter = 0;
        for(i = longArray.length-1; i >= 0; i--)
        {
            longArray[i] = (counter + 1) * 3;
            counter++;
        }
		  
        System.out.println("Short Array: " );
        ah.PrintArray(shortArray);
        System.out.println("Long Array:  " );
        ah.PrintArray(longArray);


		// Start by writing out the 'find' logic here, in main
		//		(You can pick any value to search for - make sure that your
		//		logic does the right thing for both values that ARE
		//		present in the array and those that ARE NOT present.



		// Once you've got the logic working make sure that you can get these commands to work:
//        ah.FindInArray(shortArray, 2); // SHOULD TELL US THAT '2' WAS FOUND AT SLOT 0
//        ah.FindInArray(longArray, 10); // SHOULD NOT PRINT ANYTHING
        
        ah.FindInArray(shortArray, 2);
        ah.FindInArray(longArray, 10);
    }
}