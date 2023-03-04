import becker.robots.*;
import java.util.Random; // to use the "Random" class


public class I_04_If extends Robot
{
	public I_04_If(City c, int i, int j, Direction dir, int k)
   {
      super(c, i, j, dir, k);
   }

   // These are a couple of new commands that belong to the program
	// rather than any particular robot.
	// For right now, don't worry about how these work :)
    public static void hallwayN(City c, int st, int ave, int streetsNorth)
    {
        for(int i = 0; i < streetsNorth; i++)
        {
            new Wall(c, st - i, ave, Direction.WEST);
            new Wall(c, st - i, ave, Direction.EAST);
        }
    }
    
    public void solveLine()
    {
       int i = 0;
       // Move forward as long as you can and count your steps
       while (this.frontIsClear())
       {
          this.move();
          i++;
       }
       
       // Pick up thing and turn around
       if (this.canPickThing())
       {
          this.pickThing();
       }
       this.turnLeft();
       this.turnLeft();
          
       // Going back to start
       while (i > 0)
       {
          this.move();
          i--;
       } 
    }
    
    public void solveEast()
    {
       this.solveLine();
    }
    
    public void solveNorth()
    {
       this.solveLine();
    }
    
    public void solveSouth()
    {
       this.move();
       this.turnLeft();
       this.turnLeft();
       this.turnLeft();
       this.move();
       this.turnLeft();
       this.solveLine();
       this.turnLeft();
       this.turnLeft();
       this.turnLeft();
       this.move();
       this.turnLeft();
       this.move();
    }
    
    public void solveWest()
    {
       this.move();
       this.turnLeft();
       this.turnLeft();
       this.turnLeft();
       this.solveLine();
       this.turnLeft();
       this.move();
    }
    
    public static void setupCity(City c)
    {
        // North hallway:
        hallwayN(c, 5, 5, 5);
        new Wall(c, 1, 5, Direction.NORTH);
        new Thing(c, 1, 5);
        
        // West hallway:
        hallwayN(c, 5, 4, 5);
        new Wall(c, 1, 4, Direction.NORTH);
        new Wall(c, 6, 4, Direction.WEST);
        new Wall(c, 6, 4, Direction.SOUTH);
        new Thing(c, 1, 4);
        
        // southern hallway
        hallwayN(c, 9, 4, 2);
        new Wall(c, 7, 4, Direction.WEST);
        new Wall(c, 7, 5, Direction.EAST);
        new Wall(c, 7, 5, Direction.SOUTH);
        new Wall(c, 9, 4, Direction.SOUTH);
        new Thing(c, 9, 4);
        
        // eastern hallway
        new Wall(c, 6, 6, Direction.EAST);
        new Wall(c, 6, 6, Direction.NORTH);
        new Wall(c, 6, 6, Direction.SOUTH);
        new Thing(c, 6, 6);
    }
    
    public static Direction pickDirection()
    {
        Random r = new Random(System.currentTimeMillis());
        switch(r.nextInt(4))
        {
            case 0:
                return Direction.NORTH;
            case 1:
                return Direction.WEST;
            case 2:
                return Direction.EAST;
            case 3:
                return Direction.SOUTH;
            default:
                return Direction.SOUTH; // to keep the compiler happy
        }
    }


   public static void main(String[] args)
   { 
      City toronto = new City(12, 9);
      I_04_If jo = new I_04_If(toronto, 6, 5, pickDirection(), 0);
      setupCity(toronto); // ignore this line for now

      /* Your code should go here: */
      switch(jo.getDirection())
      {
      case EAST:
         jo.solveEast();
         break;
      case NORTH:
         jo.solveNorth();
         break;
      case WEST:
         jo.solveWest();
         break;
      case SOUTH:
         jo.solveSouth();
         break;
      default:
         System.out.println("Get Direction gave a different output.");
      }
   } 
}


