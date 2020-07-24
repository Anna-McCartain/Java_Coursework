//
public class Circle
{
  private Point A;
  private double R;
  
  public Circle (Point centre, double radius)
  {
   A = new Point(centre.getX(), centre.getY());
   R = radius;
  } //circle
  
  public double area() 
  {
  return (Math.PI) * (Math.pow( R, 2));
  } //area
  
  
  public double perimeter() 
  {
  return (Math.PI) * R * 2;
  } //perimeter
  
  public String toString()
  {
    return "Circle with centre (" + A.getX() + ", " 
            + A.getY() + ") and radius " + R;
  } //tostring
  
  public Circle shift(double xShift, double yShift) 
  {
    Point shiftCentre = new Point (A.getX() + xShift, A.getY() + yShift);
    return new Circle (shiftCentre, R);
  } //shift
  
  
} // circle class
