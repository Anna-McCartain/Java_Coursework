//class to format a rectangle from two corner points. it will then call
//the shift method and apply to each corner point, then calculate the
//perimeter and area of the rectangle.

public class Rectangle
{
  private Point cornerOne, cornerThree, cornerTwo, cornerFour;
  private double length, width;
  
//constructor method for type rectangle

  public Rectangle (Point diag1End1, Point diag1End2)
  {
     cornerOne   = new Point (diag1End1.getX(), diag1End1.getY());
     cornerThree = new Point (diag1End2.getX(), diag1End2.getY());
     cornerTwo  = new Point (diag1End1.getX(), diag1End2.getY());
     cornerFour = new Point (diag1End2.getX(), diag1End1.getY());
     width  = Math.abs(diag1End1.getX() - diag1End2.getX());
     length = Math.abs(diag1End1.getY() - diag1End2.getY());
    
  } //Rectangle
 
//method to calculate area of rectangle, by using the caluclations.
  public double area()
  {
    return (width * length);
  } //area
  
  public double perimeter()
  {
      return width + width + length + length;
  } //perimeter
  
  public String toString()
  {
    return "Rectangle with Corners: (" + cornerOne.getX() + ", " 
            + cornerOne.getY() + ") , (" + cornerTwo.getX() + ", " 
            + cornerTwo.getY() + ") , (" + cornerThree.getX() + ", " 
            + cornerThree.getY() + ") , (" + cornerFour.getX() + ", " 
            + cornerFour.getY() + ")";
  } //toString
  
  public Rectangle shift (double xShift, double yShift)
  {
     Point cornerOneS = new Point (cornerOne.getX() + xShift, cornerOne.getY() + yShift);
     Point cornerThreeS = new Point (cornerThree.getX() + xShift, cornerThree.getY() + yShift);
   
    return new Rectangle (cornerOneS, cornerThreeS);
  } 
    
 } //rectangle
 
 //get each point and add the x or y value to x or y shift
 //return new rectangle allf our coordiates
