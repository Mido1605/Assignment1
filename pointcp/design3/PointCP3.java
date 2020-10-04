// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in cartiesian
 * type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer, edited for implementration of design 2
 * @author Dr Timothy C. Lethbridge
 * @author reimplementede by armys group
 * @version July 2000
 */
public class PointCP3
{
  //Instance variables ************************************************

  /**
   * Contains the current value of X 
   * coordinate.
   */
  private double xCoordinate;
  
  /**
   * Contains the current value of Y 
   * coordinate.
   */
  private double yCoordinate;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object
   */
  public PointCP3(double xCoordinate, double yCoordinate)
  {
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
  public double getDistance(PointCP3 pointB)
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