//print a calender output that highlights a particular day
//when given 3 inputs; day of the week to start on, total
//days in the month, and date that should be highlighted.

public class CalendarHighlight
{
  //main method assigns the command line arguments to 
  //variables of meaning. Then calls the printMONTH method.
  
  public static void main(String[] args)
  {
    int startColumn = Integer.parseInt(args[0]);
    int endDay = Integer.parseInt(args[1]);
    int highlightDay = Integer.parseInt(args[2]);
   
    printMonth(startColumn, endDay, highlightDay);
  } //main

  
  private static void printMonth(int startColumn, 
                                 int endDay,
                                 int highlightDay)
				 
  {  
     // our 2 'keep track' variables- we assign them inital values
     int currentColumn = 1;
     int currentDay = 1;
  
     printLine();
     printHeadings();
     
     //one border edge before blank cells.
     System.out.print("|");
     
     //loop to get the correct column to start printing dates.
     //the method will print a blank section untill the column
     //matches the command line input for starting day. 
     while(currentColumn < startColumn)
       {
       printBlank();
       currentColumn++;
       } //while
       
     //for loop to finish off first row of calender.
     for( int column = currentColumn; column <= 7; column++)
       {
         if(currentDay == highlightDay)
	 printHighlightDay(currentDay);
	 
         else
         printDayNumber(currentDay);

	 currentDay++;
	 }
      
     //border of end of first row of dates.
     System.out.println("|");
      
     //loop for printing out all the dates in the month starting
     //from second row, a row will
     //be printed with all the dates untill the end day is met. 
     //when the currentDay equals the highlighted day, the code prints
     // -->28 for example instead of just 28. 
     while(currentDay <= endDay)
     {
       System.out.print("|");
       
       for( int column = 1; column <= 7; column++)
       {
         //double if loop to stop the row being finished off
	 //even when its gone past endDay.
         if(currentDay <= endDay)
	 {
           if(currentDay == highlightDay)
	   printHighlightDay(currentDay);
	 
           else
           printDayNumber(currentDay);
  
	   currentDay++;
	 } //if
	 else
	 {
	   printBlank();
	   currentColumn++;
	 } //else
	 
       } //for
       
       //new line once row has finised, it will cycle thorugh the for loop
       //until while loop condition not met.
       System.out.println("|");
       
     } //while
     
     printLine();
     
   } //printMonth
   
   
  //method to print out the calenders border
  private static void printLine()
  {
    for(int column = 1; column <= 7; column++)
      System.out.print("------");
    System.out.println();
  } //printLine

  //method to print out the days of the week at the top
  //of the page, along with a vertical border.
  private static void printHeadings()
  {
    System.out.print("|");
    for(int dayNumber = 1; dayNumber <= 7; dayNumber++)
    printDayNames(dayNumber);
    System.out.println("|");
  } //printHeadings
  
  //method which assigns each column number to a physical
  //string representation of the days of the week.
  private static void printDayNames(int dayNumber)
  {
    switch(dayNumber)
    {
    case 1: System.out.print("    Mo"); break;
    case 2: System.out.print("    Tu"); break;
    case 3: System.out.print("    We"); break;
    case 4: System.out.print("    Th"); break;
    case 5: System.out.print("    Fr"); break;
    case 6: System.out.print("    Sa"); break;
    case 7: System.out.print("    Su"); break;
    } //switch
  } //printDayNames
  
  //method used to ensure the date printing starts from the 
  //correct day of the week by printing blank cells.
  private static void printBlank()
  {
    System.out.print("      ");
  } //printBlank
  
  //method to print out the current day into calender.
  //they are formatted as to sit the same for clarity
  private static void printDayNumber(int currentDay)
  {
    System.out.printf("%6d", currentDay);
  } //printDayNumber
  
  //method to print the highlighted day out so it stands
  //out. it has been formatted also.
  private static void printHighlightDay(int highlightDay)
  {
    if(highlightDay < 10)
      System.out.print(" --> " + highlightDay);
    else
      System.out.print(" -->" + highlightDay);
  } //printHighlightDay
  
} //class
  



