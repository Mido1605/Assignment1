
/**
 * This subclass contains instances of cartesian coordinates. It extends the abstract class PintCP5.
 *
 * @author Fran&ccedil;ois B&eacute;langer, edited for implementration of design 2
 * @author Dr Timothy C. Lethbridge
 * @author reimplementede by armys group
 * @version July 2000
 */
public class PointCP3 extends PointCP5
{
 //Instance variables ************************************************

  /**
   * Contains the current value of X 
   * of coordinates.
   */
  private double xCoordinate;
  
  /**
   * Contains the current value of Y 
   * type of coordinates.
   */
  private double yCoordinate;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object.
   */
  public PointCP3(double xCoordinate, double yCoordinate)
  {
    super(); 
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }
	
  
  //Instance methods **************************************************
 
  public double getX()
  {
    return xCoordinate;
  }
  
  public double getY()
  {
    return yCoordinate;
  }
  //Calculates Rho and Theta if called on. 
  public double getRho()
  {
    return (Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2)));
  }
  
  public double getTheta()
  {
    return Math.toDegrees(Math.atan2(yCoordinate, xCoordinate));
  }
  
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP5 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return  "Cartesian  (" + getX() + "," + getY() + ")";
       
    }

}