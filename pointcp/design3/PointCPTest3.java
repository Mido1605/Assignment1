// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

/**
 * This class prompts the user for a set of cartesian coordinates,
 * the resturns calculated polar coordniates.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @author reimplementede by armys group
 * @version July 2000
 */
public class PointCPTest3
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP3
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest3 &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[1] The value of X.
   * @param args[2] The value of Y.
   */
  public static void main(String[] args)
  {
    PointCP3 point;

    System.out.println("Cartesian Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP3 object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
      point = new PointCP3( 
        Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    //Returns stored cartesian coordinate and calculated polar coordinates.
    System.out.println("\nYou entered Cartesian coordinate:\n" + point);
    System.out.println("\nAfter asking to compute as Polar:\n" + "[" + point.getRho() + "," + point.getTheta() + "]");
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP3
   * object.
   *
   * @return A PointCP3 constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP3 getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 2; i++)
    {
        while (!(isOK))
        {
            isOK = true;  //flag set to true assuming input will be valid
            
            // Prompt the user
             // Firstand second arguments
            System.out.print("Enter the value of " +
            (i == 0 ? "X " : "Y ") + "using a decimal point(.): ");

            // Get the user's input      
        
            // Initialize the buffer before we read the input
            for(int k=0; k<1024; k++)
                buffer[k] = '\u0020';        
                
            System.in.read(buffer);
            theInput = new String(buffer).trim();
            
            // Verify the user's input
            try{
                if (i == 0)
                {
                    a = Double.valueOf(theInput).doubleValue();
                }else
                
                {
                    b = Double.valueOf(theInput).doubleValue();
                }
            }
            catch(Exception e)
            {
                System.out.println("Incorrect input");
                isOK = false;  //Reset flag as so not to end while loop
            }
        }
          //Reset flag so while loop will prompt for other arguments
        isOK = false;
    }
    

    //Return a new PointCP3 object
    return (new PointCP3(a, b));
  }
}
