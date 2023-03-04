import becker.robots.*;
import java.util.Scanner;

public class Rep_I_O extends Object {
   public static void main(String[] args) {
      City toronto = new City();
      Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
      new Thing(toronto, 3, 2);
      
      /* Your code should after here: */
      Scanner keyboard = new Scanner(System.in);
      int userChoice;
      boolean done = false;
      System.out.println("Type 1 if you want the robot to turn left");
      System.out.println("Type 2 if you want it to move 1 intersection");
      System.out.println("Type 3 if you want the robot to pick a thing up");
      System.out.println("Type 4 if you want the robot to put a thing down");
      System.out.println("Type 5 if you want to quit");
      
      while (!done)
      {
         if (keyboard.hasNextInt())
         {
            userChoice = keyboard.nextInt();
            keyboard.nextLine();
            
            if (userChoice == 1)
            {
               jo.turnLeft();
               System.out.println("Type 1 if you want the robot to turn left");
               System.out.println("Type 2 if you want it to move 1 intersection");
               System.out.println("Type 3 if you want the robot to pick a thing up");
               System.out.println("Type 4 if you want the robot to put a thing down");
               System.out.println("Type 5 if you want to quit");
            }
            
            if (userChoice == 2)
            {
               jo.move();
               System.out.println("Type 1 if you want the robot to turn left");
               System.out.println("Type 2 if you want it to move 1 intersection");
               System.out.println("Type 3 if you want the robot to pick a thing up");
               System.out.println("Type 4 if you want the robot to put a thing down");
               System.out.println("Type 5 if you want to quit");
            }
            
            if (userChoice == 3)
            {
               jo.pickThing();
               System.out.println("Type 1 if you want the robot to turn left");
               System.out.println("Type 2 if you want it to move 1 intersection");
               System.out.println("Type 3 if you want the robot to pick a thing up");
               System.out.println("Type 4 if you want the robot to put a thing down");
               System.out.println("Type 5 if you want to quit");
            }
            
            if (userChoice == 4)
            {
               jo.putThing();
               System.out.println("Type 1 if you want the robot to turn left");
               System.out.println("Type 2 if you want it to move 1 intersection");
               System.out.println("Type 3 if you want the robot to pick a thing up");
               System.out.println("Type 4 if you want the robot to put a thing down");
               System.out.println("Type 5 if you want to quit");
            }
            
            if (userChoice == 5)
            {
               System.out.println("Program ends now!");
               done = true;
            }
         }
         
      }
      
   } 
}