//Name: Dev Kodre Period: 2 4/26/21

import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.*;


/**
* The AllStarDriver allows the user to interact with the interface.
* Allows the user to run a simulation based on players selected.
* Driver that runs the program.
*
*
* @param JFrame
* 
  
*/
public class AllStarDriver
{
/**
* Main method runs the AllStarPanel from the JFrame.
*
*
*
*
* @param JFrame
* 
  
*/
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("All Star Simulator!");
      frame.setSize(800, 800);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new AllStarPanel());
      frame.setVisible(true);
   }
}
