import becker.robots.*;

public class ICE_12_Errors_2 extends Object
{
    public static void main(String[] args)
    { 
        City ForgetsVille = new City();
        MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
        new Wall(ForgetsVille, 2, 5, Direction.NORTH);

        // First keep track of these 4
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.printNumberOfMoves();
        
        mary.leftTurnCounted();
        mary.printLeftTurns();
        
        while (mary.frontIsClear())
        {
           mary.moveCounted();
        }
        
        mary.printNumberOfMoves();
    }
}

