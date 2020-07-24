import java.util.Scanner;

/* This programme performs simple calculations and maipulations of 
esimple shapes expressed in 2d coordinate geometry

first ask user to choose one shape from three and prompts for details
  circle specified giving centre point and radius
  traingle specified by giving vertices points
  rectangle specified ny giving points of diagonally opposite corners
  
then user prompted to specify offet for x and y
creates specifeid shape and similar one thats offset

programme reports original shape plus area and perimeter also new shape */

//helper method to read point from input
public class ShapeShift
{
  private static Scanner inputScanner = new Scanner(System.in);
  
  private static Point inputPoint(String prompt)
  {
    System.out.print(prompt);
    double x = inputScanner.nextDouble();
    double y = inputScanner.nextDouble();
    return new Point (x, y);
  } //inputPint
  
//method to shift


  private static double xShift, yShift;
  
//read shifts
  private static void inputXYShifts()
  {
    System.out.print("Enter the offset as X Y: ");
    xShift = inputScanner.nextDouble();
    yShift = inputScanner.nextDouble();
    
  } //inputXYShifts
 
 
 //main
 public static void main(String[] args)
 {
   //obtain choice
   System.out.print("Choose circle [1], triangle [2], rectangle [3]: ");
   int shapeChoice = inputScanner.nextInt();
   
   switch (shapeChoice)
   {
   
   //circle
   case 1:
   Point centre = inputPoint("Enter the centre as X Y: ");
   System.out.print("Enter the radius: ");
   double radius = inputScanner.nextDouble();
   Circle originalCircle = new Circle(centre, radius);
   inputXYShifts();
   Circle shiftedCircle = originalCircle.shift(xShift, yShift);
   System.out.println();
   System.out.println(originalCircle);
   System.out.println("has area " + originalCircle.area()
                      + ", perimeter " + originalCircle.perimeter());
   System.out.println("and when shifted by x offset " + xShift
                      + " and Y offset " + yShift + ", gives");
   System.out.println(shiftedCircle);
   break;
   
   
   //triangle 
   case 2:
   Point pointA = inputPoint("Enter point A as X Y:");
   Point pointB = inputPoint("Enter point B as X Y: ");
   Point pointC = inputPoint("Enter point C as X Y: ");
   Triangle originalTriangle = new Triangle(pointA, pointB, pointC);
   inputXYShifts();
   Triangle shiftedTriangle = originalTriangle.shift(xShift, yShift);
   System.out.println();
   System.out.println(originalTriangle);
   System.out.println("has area " + originalTriangle.area()
                      + ", perimeter " + originalTriangle.perimeter());
   System.out.println("and when shifted by x offset " + xShift
                      + " and Y offset " + yShift + ", gives");
   System.out.println(shiftedTriangle);
   break;
   
   
   //rectangle
   case 3:
   Point diag1End1 = inputPoint("Enter one corner as X Y:");
   Point diag1End2 = inputPoint("Enter opposite corner as X Y: ");
   
   Rectangle originalRectangle = new Rectangle(diag1End1, diag1End2);
   inputXYShifts();
   Rectangle shiftedRectangle = originalRectangle.shift(xShift, yShift);
   System.out.println();
   System.out.println(originalRectangle);
   System.out.println("has area " + originalRectangle.area()
                      + ", perimeter " + originalRectangle.perimeter());
   System.out.println("and when shifted by x offset " + xShift
                      + " and Y offset " + yShift + ", gives");
   System.out.println(shiftedRectangle);
   break;
   
   
   //bad choice
   default:
     System.out.println("That was not 1 2 or 3!!!!");
     break;
     
  } //switch
 } //main

} //class
