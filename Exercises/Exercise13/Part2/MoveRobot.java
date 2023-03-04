import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot
{
    //Forgot to add variable type. Compile-time
    int numberOfMovesMade = 0;
    int leftTurnsMade = 0;
    
    MoveRobot( City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveCounted()
    {
        this.move();
        //Multiplied by 2 instead of adding 1. Intent error
        this.numberOfMovesMade = this.numberOfMovesMade + 1;
    }
    
    public void printNumberOfMoves()
    {
        System.out.println("Since I started counting, I moved:");
        //Printed on next line. Intent error
        System.out.print( this.numberOfMovesMade);
        System.out.println(" times!");
        //Reset number back to 0
        this.numberOfMovesMade = 0;
    }
    
    public void leftTurnCounted()
    {
       this.turnLeft();
       this.leftTurnsMade = this.leftTurnsMade + 1;
    }
    
    public void printLeftTurns()
    {
       System.out.println("Since I started counting, I turned left:");
       System.out.print(this.leftTurnsMade);
       System.out.println(" times!");
       this.leftTurnsMade = 0;
    }
}
