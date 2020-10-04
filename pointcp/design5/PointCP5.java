
/**
 * This abstract class is implemented byPointCP3 and PointCP. If the coordinates are polar then a PointCP2 objest is created. 
 * If coordinates are cartesian then a PointCP3 objest is created.
 * @author Fran&ccedil;ois B&eacute;langer, edited for implementration of design 2
 * @author Dr Timothy C. Lethbridge
 * @author reimplementede by armys group
 * @version July 2000
 */
abstract public class PointCP5
{ 
  //instance methods dependsing on subclass
  public abstract double getX();

  public abstract double getY();
  
  public abstract double getRho();
  
  public abstract double getTheta();
	
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public abstract double getDistance(PointCP5 pointB);
  

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public abstract PointCP5 rotatePoint(double rotation);
  
  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public abstract String toString();

}