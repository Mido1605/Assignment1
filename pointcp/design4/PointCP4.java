// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in both polar or
 * cartesian format. It stores both Polar and Cartesian so can return.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author reimplementede by armys group
 * @version July 2000
 */
public class PointCP4
{
  //Instance variables ************************************************
  
  /**
   * Contains the current value of x
   * of coordinates.
   */
  private double xCoordinate;
  
  /**
   * Contains the current value of Y 
   * type of coordinates.
   */
  private double yCoordinate;
	
  
  /**
   * Contains the current value of RHO 
   * of coordinates.
   */
  private double rho;
  
  /**
   * Contains the current value of THETA 
   * type of coordinates.
   */
  private double theta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP4(char type, double xOrRho, double yOrTheta)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    if(type == 'C'){
      this.xCoordinate = xOrRho;
      this.yCoordinate = yOrTheta;
      this.rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
      this.theta =(Math.toDegrees(Math.atan2(yOrTheta, xOrRho)));

    }else{
      this.rho = xOrRho;
      this.theta = yOrTheta;
      this.xCoordinate= (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
      this.yCoordinate =(Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }
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
  
  public double getRho()
  {
    return rho; 
  }
  
  public double getTheta()
  {
    return theta; 
  }
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP4 pointB)
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
  public PointCP4 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP4('C',
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
    return "Stored as " + "Cartesian  (" + getX() + "," + getY() + ") and Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}
