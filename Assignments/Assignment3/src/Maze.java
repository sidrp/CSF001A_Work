import becker.robots.*;

/**
 * CS1A - Assignment 3 - "The Maze" <br>
 * Quarter: Winter<br>
 * TODO: THE SUMMARY GOES HERE <br>
 *    This program makes the robot stick to the right wall by checking the right wall to see if it's there. 
 *    It places a thing at every intersection it passes to keep track of where it is. While it is not the quickest
 *    way to get out of the maze, it is a foolproof way that will work in any maze where all the walls are fully connected. 
 *    
 *    In order to achieve this, we had to create several methods, including putThingDown(), moveSafer(), moveForward(), 
 *    printEverything(), isAtEndSpot(), and navigateMaze(). putThingDown() makes sure there is nothing at the intersection 
 *    before placing a thing down. moveForward() tells the robot to place a thing down and move forward while counting its steps. 
 *    moveSafer() checks to make sure that the direction is clear. printEverything() prints the movements in each direction and the
 *    total movements. isAtEndSpot() tells the robot whether or not it is at the end of the maze. navigateMaze() calls all these 
 *    functions in order for the robot to get through the maze. 
 *
 * @author Kaveri Desai
 * @author Sid Pellakuru
 */
class MazeBot extends RobotSE
{
   int totalMoves = 0;
   int movesWest = 0;
   int movesEast = 0;
   int movesSouth = 0;
   int movesNorth = 0;

   public MazeBot(City theCity, int str, int ave, Direction dir, int numThings)
   {
      super(theCity, str, ave, dir, numThings);
   }

   // Checks to see if there is a thing before placing.
   public void putThingDown()
   {
      if (!this.canPickThing())
      {
         this.putThing();
      }
   }

   // Puts a thing down and moves forward while counting its movements. 
   public void moveForward()
   {
      this.putThingDown();
      this.move();
      if (this.getDirection() == Direction.NORTH)
      {
         ++movesNorth;
      }
      if (this.getDirection() == Direction.SOUTH)
      {
         ++movesSouth;
      }
      if (this.getDirection() == Direction.EAST)
      {
         ++movesEast;
      }
      if (this.getDirection() == Direction.WEST)
      {
         ++movesWest;
      }
   }

   // Checks each direction to see if it's clear. 
   public void moveSafer()
   {
      this.turnRight();
      
      // Checking the right wall
      if (this.frontIsClear())
      {
         this.moveForward();
      } 
      
      // If right isn't clear
      else
      {
         this.turnLeft();
         
         // Checking the front wall
         if (this.frontIsClear())
         {
            this.moveForward();
         }
         
         // If front isn't clear
         else 
         {
            this.turnLeft();
            
            // Checking the left wall
            if (this.frontIsClear())
            {
               this.moveForward();
            }
            
            // If left wall isn't clear
            else
            {
               this.turnLeft();
               
            }
         }
      }
      ++totalMoves;
   }
   
   // Prints the number of movements in each direction and in total. 
   public void printEverything()
   {
      System.out.println("total moves North: " + movesNorth);
      System.out.println("total moves South: " + movesSouth);
      System.out.println("total moves East: " + movesEast);
      System.out.println("total moves West: " + movesWest);
      System.out.println("total moves: " + totalMoves);
      System.out.print("Hooray don has solved the maze!");
   }

   // Checks if the robot is at the end of the maze.
   private boolean isAtEndSpot()
   {
      return getAvenue() == 9 && getStreet() == 10;
   }

   // Calls all methods to get through the maze.
   public void navigateMaze()
   {

      while (!isAtEndSpot())
      {
         this.moveSafer();

      }

      this.printEverything();
   }
}


public class Maze extends Object
{
   private static void makeMaze(City theCity)
   {
      for (int i = 1; i < 11; i++)
      {
         // north wall
         new Wall(theCity, 1, i, Direction.NORTH);
         // Second to north wall
         if (i <= 9)
            new Wall(theCity, 1, i, Direction.SOUTH);
         // Third to north wall
         if (i >= 4)
            new Wall(theCity, 4, i, Direction.SOUTH);
         // south wall
         if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
            new Wall(theCity, 10, i, Direction.SOUTH);
         // west wall
         if (i != 1) // (1, 1, WEST) is where the 'entrance' is
            new Wall(theCity, i, 1, Direction.WEST);
         // second to most western wall
         if (i >= 3 && i < 6)
            new Wall(theCity, i, 6, Direction.WEST);
         // east wall
         new Wall(theCity, i, 10, Direction.EAST);
      }
      // Cul de Sac
      new Wall(theCity, 3, 10, Direction.WEST);
      new Wall(theCity, 3, 10, Direction.SOUTH);
      new Wall(theCity, 2, 8, Direction.WEST);
      new Wall(theCity, 2, 8, Direction.SOUTH);
      new Wall(theCity, 10, 8, Direction.NORTH);
      new Wall(theCity, 10, 9, Direction.EAST);
      new Wall(theCity, 10, 9, Direction.NORTH);
      makeSpiral(theCity, 8, 9, 3);
      new Wall(theCity, 8, 10, Direction.SOUTH);
      makeSpiral(theCity, 10, 5, 4);
   }

   public static void makeSpiral(City theCity, int st, int ave, int size)
   {
      // We start out building the wall northward
      // the walls will be built on the east face of the current
      // intersection
      Direction facing = Direction.EAST;
      while (size > 0)
      {
         int spacesLeft = size;
         int aveChange = 0;
         int stChange = 0;
         switch (facing)
         {
         case EAST:
            stChange = -1;
            break;
         case NORTH:
            aveChange = -1;
            break;
         case WEST:
            stChange = 1;
            break;
         case SOUTH:
            aveChange = 1;
            break;
         }
         while (spacesLeft > 0)
         {
            new Wall(theCity, st, ave, facing);
            ave += aveChange;
            st += stChange;
            --spacesLeft;
         }
         // back up one space
         ave -= aveChange;
         st -= stChange;
         switch (facing)
         {
         case EAST:
            facing = Direction.NORTH;
            break;
         case NORTH:
            facing = Direction.WEST;
            size--;
            break;
         case WEST:
            facing = Direction.SOUTH;
            break;
         case SOUTH:
            facing = Direction.EAST;
            size--;
            break;
         }
      }
   }

   // ###########################################################################################
   // Main Method
   // ###########################################################################################
   public static void main(String[] args)
   {
      City calgary = new City(12, 12);
      MazeBot don = new MazeBot(calgary, 1, 1, Direction.EAST, 1000);
      Maze.makeMaze(calgary);
      calgary.showThingCounts(true);
      
      // Calling all methods
      don.navigateMaze(); 
   }
}
