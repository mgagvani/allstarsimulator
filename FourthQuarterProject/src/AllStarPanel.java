
import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//@Author Dev Kodre
//Period: 2
//Date: 4/26/21

/**
* The AllStarPanel allows the user to select players.
* Allows the user to run a simulation based on players selected.
*
*
* @param start_Button  Executes simulation of game between players selected.
* @param cancel_Button Terminates simulation after start button is pressed.
* @param JComboBox Drop down menu to select players
* @param SelectButton   selects the player highlighted in the JComboBox
* @param team1Score_Label   Displays total score for team one 
* @param team2Score_Label   Displays total score for team two
*
* Displays points scored, scoring ratio for 2 pointers and 3 pointers for each player
*
* @param team1p1Stats_Label 
* @param team1p2Stats_Label
* @param team1p3Stats_Label
* @param team1p4Stats_Label
* @param team1p5Stats_Label
*
* @param team2p1Stats_Label
* @param team2p2Stats_Label
* @param team2p3Stats_Label
* @param team2p4Stats_Label
* @param team2p5Stats_Label

* @param Directions_Label  Information on how to run the simulation

* @author Dev Kodre
   
*/
public class AllStarPanel extends JPanel {
   
   public AllStarPanel ()
   {
      
   }
   /**
   * Displays animation during the run of the program.
   * The animation will only run once the start button has been pressed.
   *
   * @param Graphics component
   */
   public void paintComponent(Graphics g)
   {
   
   }
   /**
   * Adds number of points scored to player's total number of scored points
   * The method will be called after the start button has been pressed.
   *
   * @param player_points   points scored by player
   * @return total  total number of points scored by player
   */
   public int PlayerAddPoint(int points )
   {
      
      return 1;
   } 
   /**
   * Adds number of points scored to team's total number of scored points
   * The method will be called after the start button has been pressed.
   *
   * @param player_points   points scored by player
   * @return total  total points scored by team
   */
   public int TeamAddPoint(int points )
   {
      
      return 1;
   }
   /**
   * Listener class for when the start button has been pressed.
   *
   *
   */
   private class StartPressed implements ActionListener
   {
   /**
   * Runs the simulation of a game between the selected players
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
   /**
   * Listener class for when a player has been selected from the drop down menu and wants to be added to the team.
   *
   *
   */
   private class SelectDropDown implements ActionListener
   {
   /**
   * Ensures the player selected is added to the team.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
   /**
   * Ends the simulation of the game after the start button has been pressed.
   *
   *
   */
   private class CencelPressed implements ActionListener
   {
   /**
   * Terminates all calcuations and resets all variables.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
   /**
   * Resets the points after a match has been simulated for the ability to run another simulation.
   *
   *
   */
   private class ResetPressed implements ActionListener
   {
   /**
   * Resets total points scored and total points scored by each individual player.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
   /**
   * removes most recent player selected
   *
   *
   */
   private class DeletePressed implements ActionListener
   {
   /**
   * Removes player selected from the team
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
}
