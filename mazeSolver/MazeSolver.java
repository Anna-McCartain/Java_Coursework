import java.io.File;
import java.util.Scanner;

/*Reads a maze representation from each file given as an argument and prints it out showing the shortest route from any entrance to exit.*/

public class MazeSolver
{
  public static void main(String[] args) throws Exception
  {
    //creates a new maze with the added path from the input mazes and prints.
    for (String filename : args)
      System.out.print(new MazeSolver(new Scanner(new File(filename))));
  }

  //fixed maze dimensions
  private static final int HEIGHT = 10;
  private static final int WIDTH = 20;

  //the values for cells in the maze model
  //start is zero as you get there in zero steps
  private static final int START = 0;

  //space hedge path and end must all be negative so they are not ambiguous
  //with move count.
  private static final int SPACE = -1;
  private static final int HEDGE = -2;
  private static final int PATH = -3;
  private static final int END = -4;

  //the characters used in the file and output to represent the maze
  private static final char SPACE_REP = ' ';
  private static final char HEDGE_REP = '#';
  private static final char START_REP = '?';
  private static final char END_REP   = '!';
  private static final char PATH_REP  = '.';

  //the maze model; it is 2 bigger in each dimension so we can havr an extra
  //hedge around the whole  maze. this means every real cell has 4 neighbours
  //so we dont need to check edges of the array.
  private final int[][] maze = new int[HEIGHT + 2][WIDTH + 2];

  //construct a MazeSolver from the given scanner of a file which must contain
  //HEIGHT lines each of WIDTH characters.
  public MazeSolver(Scanner input)
  {
    //first we place a surround of HEDGE cells.
    for(int row = 0; row < HEIGHT + 2; row++)
      maze[row][0] = maze[row][WIDTH + 1] = HEDGE;
    for(int column = 0; column < WIDTH + 2; column++)
      maze[0][column] = maze[HEIGHT + 1][column] = HEDGE;

    //next we read the maze - assuming the file is valid - going into position
    // 1 for HEIGHT and WIDTH - leaving the outer hedge intact.
    for (int row = 1; row <= HEIGHT; row++)
    {
      String mazeLine = input.nextLine();
      for ( int column = 1; column <= WIDTH; column++)
      {
        char inputChar = mazeLine.charAt(column - 1);
        switch (inputChar)
        {
          case SPACE_REP: maze[row][column] = SPACE; break;
          case HEDGE_REP: maze[row][column] = HEDGE; break;
          case START_REP: maze[row][column] = START; break;
          case END_REP:   maze[row][column] = END;   break;
        } //switch
      } //for
    } //for

    //then solve
    solve();
  } //MazeSolver

  //each cell has 4 neighbours: these offsets help us find them
  private int[] neighbourOffsets = {-1, 0, 1, 0};

  //find the shortest path from start to END - exceptions not added hence PATH
  //must exist
  private void solve()
  {
    int moveCount = START;
    boolean foundExit = false;
    while(!foundExit)
    {
      for (int row = 1; row <= HEIGHT; row++)
      {
        for (int column = 1; column <= WIDTH; column++)
        {
          // System.out.println("move count" + moveCount);
          // System.out.printf("row %4d column %4d value %4d", row, column,
          //                     maze[row][column]);
          if(maze[row][column] == moveCount)
          {
            //put neighbours values into an array
            int[] N_W_S_E = new int[4];
            // N_S_W_E[0] = maze[row + neighbourOffsets[0]]
            //                       [column + neighbourOffsets[1]];
            // N_S_W_E[1] = maze[row + neighbourOffsets[2]]
            //                         [column + neighbourOffsets[3]];
            // N_S_W_E[2] = maze[row + neighbourOffsets[3]]
            //                       [column + neighbourOffsets[2]];
            // N_S_W_E[3] = maze[row + neighbourOffsets[1]]
            //                       [column + neighbourOffsets[0]];

            //put north and south neighbours values into array
            for(int i = 0; i < N_W_S_E.length; i += 2)
            {
              N_W_S_E[i] = maze[row + neighbourOffsets[i]]
                                [column + neighbourOffsets[i + 1]];
            }

            //put west and east values into array
            for(int i = 3; i > 0; i -= 2)
            {
              N_W_S_E[i] = maze[row + neighbourOffsets[i]]
                                [column + neighbourOffsets[i - 1]];
            }

            // System.out.printf("coordinates of square are %4d, %4d, value of square is %5d", row, column, maze[row][column]);
            //
            // System.out.println(" ");
            // System.out.println(" North, West, South, East: ");
            //
            // for(int i = 0; i < N_W_S_E.length; i++)
            // {
            //   System.out.println(N_W_S_E[i]);
            // }

            //check north and south neighbours for space or exit
            for(int i = 0; i < N_W_S_E.length; i += 2)
            {
              if(N_W_S_E[i] == END)
              {
                foundExit = true;
                // System.out.println("EXIT FOUND");
                markPathBackFrom(row, column);
              }
              if(N_W_S_E[i] == SPACE)
              {
                maze[row + neighbourOffsets[i]][column
                          + neighbourOffsets[i + 1]] = moveCount + 1;
              }
            }

            //check west and east neighbours for space or exit
            for(int i = 3; i > 0; i -= 2)
            {
              if(N_W_S_E[i] == END)
              {
                foundExit = true;
                markPathBackFrom(row, column);
              }
              if(N_W_S_E[i] == SPACE)
                maze[row + neighbourOffsets[i]][column
                          + neighbourOffsets[i - 1]] = moveCount + 1;
            }

            // System.out.printf("N, %3d, E, %3d, S, %3d, W, %3d",
            // maze[row + neighbourOffsets[0]][column + neighbourOffsets[1]],
            // maze[row + neighbourOffsets[3]][column + neighbourOffsets[2]],
            // maze[row + neighbourOffsets[2]][column + neighbourOffsets[3]],
            // maze[row + neighbourOffsets[1]][column + neighbourOffsets[0]]);

          } //if
        } //for
      } //for
      moveCount++;
    } //while
  } //solve

  //mark the path back from row column
  private void markPathBackFrom(int row, int column)
  {
    int moveCount = maze[row][column];
    while(moveCount != 0)
    {
      maze[row][column] = PATH;
      moveCount--;

      //find value of neighbour which is new move count value.
      //put neighbours values into an array
      int[] N_W_S_E = new int[4];

      for(int i = 0; i < N_W_S_E.length; i += 2)
      {
        N_W_S_E[i] = maze[row + neighbourOffsets[i]]
                          [column + neighbourOffsets[i + 1]];
      }

      //put west and east values into array
      for(int i = 3; i > 0; i -= 2)
      {
        N_W_S_E[i] = maze[row + neighbourOffsets[i]]
                          [column + neighbourOffsets[i - 1]];
      }

      for(int i = 0; i < N_W_S_E.length; i += 2)
      {
        if(N_W_S_E[i] == moveCount)
        {
          row += neighbourOffsets[i];
          column += neighbourOffsets[i + 1];
        }
      }

      for(int i = 3; i > 0; i -=2)
      {
        if(N_W_S_E[i] == moveCount)
        {
          row += neighbourOffsets[i];
          column += neighbourOffsets[i - 1];
        }
      }
  }
}//mark path back from

  //line seperator
  private static final String NLS = System.getProperty("line.separator");

  //return a text representation of the maze
  public String  toString()
  {
    String result = "";
    for (int row = 1; row <= HEIGHT; row++)
    {
      for (int column = 1; column <= WIDTH; column++)
        switch (maze[row][column])
        {
          case HEDGE: result += HEDGE_REP; break;
          case START: result += START_REP; break;
          case END:   result += END_REP;   break;
          case PATH:  result += PATH_REP;  break;

          default:    result += SPACE_REP;
        } //switch
      result += NLS;
    } //for
    return result;
  } //toString
} //class

