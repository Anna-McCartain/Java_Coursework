//print out a truth table for p1 p2 p3 defined
//below, for all the possible combinations of
//true and false for a, b, c, and d variables.

public class TruthTable34
{
   //method to return true or false for p1 defined below.
  private static boolean p1(boolean a, boolean b, boolean c, boolean d)
  {
    return (((a || b) && c) || ((b || c) && d)) && (a || d);
   }
   
   
   
   //method to return true or false for p2 defined below.
   private static boolean p2(boolean a, boolean b, boolean c, boolean d)
   {
     return a && c || b && d || c && d;
   }
   
   
   
   //method to return true or falase for p3 defined below.
   private static boolean p3(boolean a, boolean b, boolean c, boolean d)
   {
     return (b || c) && (c || d) && (a || d);
   }
   
   
   
   //method to print top line of table.
   private static void printTopLine()
   {
     for(column = 1; column <= 7; column ++)
     System.out.print("-------");
     System.out.println();
   }
   
   
   
   //method to print the columns and their headings
   private static void printColumnHeading()
   {
     System.out.println("|  a  ||  b  ||  c  ||  d  |
                         | p1  || p2  || p3  |");
    }
    
    
    
    //method to print out the bottom of column headings.
    private static void printColumnBottom()
    {
      for(column = 1; column <= 7; column ++)
      System.out.print("|_____|");
      System.out.println();
    }
    
    
    
    //method to print out a single row in the table of T/F values
    private static void printSingleRow(boolean a, boolean b, 
                                       boolean c, boolean d,)  
    {
      System.out.println("|" + formatRowItem(a) + "|"
                          + formatRowItem(b) + "|" 
			  + formatRowItem(c) + "|"
			  + formatRowItem(d) + "|"
			  + formatRowItem(p1(a, b, c, d)) + "|"
			  + formatRowItem(p2(a, b, c, d)) + "|"
			  + formatRowItem(p3(a, b, c, d)) + "|");
     }
     
     
     
     //method to change the boolean variable into an actual sting
     //in the table - either true or false.
     private static String formatRowItem(boolean rowItem)
     {
       return rowItem ? " true  " : " false ";
     }
     
     
     
     //main method to call each private method in turn to build table
     //then find all possible combos of a, b, c, d and return
     //the string true or false for p1, p2, p3
     public static void main(String[] args)
     {
     printTopLine();
     printColumnHeadings();
     printColumnBottom();
     
     //declare 4 variables as false initially
     boolean a = false;
     boolean b = false;
     boolean c = false;
     boolean d = false;
     
     //nested loops to print all combos of true and false
     // for a b c and d
     for( a = 0; a <= 1; a++)
     {
       for(b = 0; b <= 1; b++)
       {
         for(c = 0; c <= 1; c++)
	 {
	   for(d = 0; d <= 1; d ++)
	   {
	   printSingleRow(a, b, c, d);
	   }}}} //for
	   
     printColumnBottom();
     }
   }//class
			 
