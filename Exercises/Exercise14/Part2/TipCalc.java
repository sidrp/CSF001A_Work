import java.util.Scanner;

public class TipCalc extends Object
{
   public static void main(String[] args)
   { 
      double costOfMeal = 0;
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter the cost of your meal: ");
      
      if( keyboard.hasNextDouble() ) // if user typed in a double
      {
          costOfMeal = keyboard.nextDouble();
          double tip15 = costOfMeal * 0.15;
          double tip20 = costOfMeal * 0.2;
          double tip30 = costOfMeal * 0.3;
          System.out.println("15% tip will be $" + tip15);
          System.out.println("20% tip will be $" + tip20);
          System.out.println("30% tip will be $" + tip30);
      }


      System.out.println("Cost is: " + costOfMeal );
      boolean mealIsPricey;

      if (costOfMeal > 20)
      {
          mealIsPricey = true;
      }
      else
      {
          mealIsPricey = false;
      }
      
      if( mealIsPricey ) 
      System.out.println("the meal is expensive" );
   }
}
