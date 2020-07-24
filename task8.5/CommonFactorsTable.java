//programme that prints certain symbols dependant 
//on whether the two intersecting numbers have a
//common factor. eg - '--#' is printed if the GCD
//is greater that one. Otherwise '--|' printed.

public class CommonFactorsTable
{
  //define class variables, number of c/r
  private static int tableSize = 20;

  //main method calling each method inturn to
  //print the complete table.
  public static void main(String[] args)
  {
    printLine();
  
    printColumnHeadings();
 
    printLine();

    for(int row =  2; row <= tableSize; row++)
      printRow(row);

    printLine();
  } //main


  //method to print the line used to create rows etc.
  private static void printLine()
  {
    System.out.print("|-----|");
    for(int column = 2; column <= tableSize; column++)
      System.out.print("----");
    System.out.println("-|");
   } //printLine


  //method to print out the column titles 2 to 20.
  private static void printColumnHeadings()
  {
    System.out.print("|     |");
    for(int column = 2; column <= tableSize; column++)
      if (column < 10)
        System.out.print("   " + column);
      else 
        System.out.print("  " + column);
    System.out.println(" |");
  } //printColumnHeadings


  //method to print out the row contents of the table.
  private static void printRow(int row)
  {
    //Left hand column.
    System.out.print("|");
    printLeftColumn(row);
    System.out.print("|"); 

    //main body of table printing out --# or --|   
    for (int column = 2; column <= tableSize; column++)
    {
      int GCD1 = row;
      int GCD2 = column;
      while( GCD1 != GCD2)
       {
       if (GCD1 > GCD2)
            GCD1 -= GCD2;
        else
            GCD2 -= GCD1;
        } //while
     if (GCD1 == 1)
        System.out.print(" --|");
     else
        System.out.print(" --#");
      } //for
    System.out.println(" |");
    } //printRow
    

    //method to correct the spacing of Left hand column.
    private static void printLeftColumn(int numberToPrint)
    {
      System.out.printf("%5d", numberToPrint);
    } //printLeftColumn

} //class








 
