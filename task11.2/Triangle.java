//
public class Triangle
{
  private Point A, B, C;
  private double aToB, bToC, cToA;      
  
  public Triangle (Point p0, Point p1, Point p2)
  {
  A = new Point (p0.getX(), p0.getY());
  B = new Point (p1.getX(), p1.getY());
  C = new Point (p2.getX(), p2.getY());
  aToB = Math.sqrt(Math.pow(Math.abs(p0.getX() - p1.getX()), 2)
                + Math.pow(Math.abs(p0.getY() - p1.getY()), 2));
	
  bToC = Math.sqrt(Math.pow(Math.abs(p1.getX() - p2.getX()), 2)
                + Math.pow(Math.abs(p1.getY() - p2.getY()), 2));
		
  cToA = Math.sqrt(Math.pow(Math.abs(p2.getX() - p0.getX()), 2)
                + Math.pow(Math.abs(p2.getY() - p0.getY()), 2));
		
  } //Triangle
  
  public double area() 
  {
  double semiPerimeter = (aToB + bToC + cToA) / 2;
  return Math.sqrt(semiPerimeter * (semiPerimeter - aToB)
         * (semiPerimeter - bToC) * (semiPerimeter - cToA));
  }
  	
	 
  public double perimeter() 
  {
  return aToB + bToC + cToA;
  }
  
  public String toString()
  {
    return "Triangle with vertices (" + A.getX() + ", "
            + A.getY() + "), (" + B.getX() + ", " + B.getY()
	    + "), (" + C.getX() + ", " + C.getY() + ")";
  } //string
  
  public Triangle shift(double xShift, double yShift) 
  {
   Point aS = new Point (A.getX() + xShift, A.getY() + yShift);
   Point bS = new Point (B.getX() + xShift, B.getY() + yShift);
   Point cS = new Point (C.getX() + xShift, C.getY() + yShift);
   
   return new Triangle (aS, bS, cS);
  }
}
