
import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.Timer;
import java.awt.image.*;
import java.util.*;
import java.io.*;
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
   
*/
public class AllStarPanel extends JPanel{

   BufferedImage image;
   int xPos = 0;
   int yPos = 600;
   int direction =1;
   
   public AllStarPanel ()
   {
      
      
      
      setLayout(new GridLayout(20,2));
      
      JLabel directions = new JLabel("Select players from the drop down menu and add them to the perfered team.");
      JButton addt1 = new JButton("Add Team 1");
      JButton deletet1 = new JButton("Delete Team 1");
      JButton addt2 = new JButton("Add Team 2");
      JButton deletet2 = new JButton("Delete Team 2");
      
      JLabel menuLabel = new JLabel("Select a player");
      
      JComboBox playerlist = new JComboBox();
      
      JLabel team1 = new JLabel("Team One:");
      
      JLabel player1t1 = new JLabel("player");
      JLabel player2t1 = new JLabel("player");
      JLabel player3t1 = new JLabel("player");
      JLabel player4t1 = new JLabel("player");
      JLabel player5t1 = new JLabel("player");
      
      JLabel team1score = new JLabel("Score:");
      
      JLabel team2 = new JLabel("Team Two:");
      
      JLabel player1t2 = new JLabel("player");
      JLabel player2t2 = new JLabel("player");
      JLabel player3t2 = new JLabel("player");
      JLabel player4t2 = new JLabel("player");
      JLabel player5t2 = new JLabel("player");
      
      JLabel team2score = new JLabel("Score:");
      JButton start = new JButton("START");
      start.addActionListener(new StartPressed());
      
      
      
      
      
      
   
      add(directions);
      add(new JLabel()); //used to occupy a slot allowing the formatting to look better
      
      
      add(addt1);
      add(deletet1);
      
      add(addt2);
      
      add(deletet2);
      
      add(menuLabel);
      add(new JLabel());
      
      add(playerlist);
      
      add(new JLabel());
      
      add(team1score);
      add(team2score);
      
      add(team1);
      add(team2);
      
      add(player1t1);
      add(player1t2);
      
      add(player2t1);
      add(player2t2);
      
      add(player3t1);
      add(player3t2);
      
      add(player4t1);
      add(player4t2);
      
      add(player5t1);
      add(player5t2);
      
      
      
      add(start);
      try{
      
         image = ImageIO.read(new File("basketball.jpeg"));
      
      }
      catch(IOException ex)
      {
      
      }
               
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      playerlist.addItem("test1");
      playerlist.addItem("test2");
      playerlist.addItem("test3");
      
      
      
      
      
   }
   /**
   * Displays animation during the run of the program.
   * The animation will only run once the start button has been pressed.
   *
   * @param Graphics component
   */
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(image, xPos,yPos,150,150, this);
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
            try {
              
         Timer timer = new Timer(40, 
            new ActionListener() {
               @Override
                    public void actionPerformed(ActionEvent e) {
                 yPos = (int)((0.005)*(Math.pow(xPos, 2))) - xPos + 600;
                  xPos += direction;
                  if (xPos + image.getWidth() > getWidth()+50) {
                     xPos = getWidth() - image.getWidth();
                     direction *= -1;
                  } else if (xPos < 0) {
                     xPos = 0;
                     direction *= -1;
                  }
                  if (yPos + image.getHeight() > getHeight() +200)
                  {
                     
                     xPos = 0;
                  }
                  repaint();
               }
                
            
            });
         timer.setRepeats(true);
         timer.setCoalesce(true);
         timer.start();
      } 
      catch(Exception ex) 
      {
         
      }

      }
   }
   /**
   * Listener class for when a player has been selected from the drop down menu and wants to be added to the team.
   *
   *
   */
   private class SelectDropDownTeam1 implements ActionListener
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
   * Listener class for when a player has been selected from the drop down menu and wants to be added to the team.
   *
   *
   */
   private class SelectDropDownTeam2 implements ActionListener
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
   private class DeleteTeam1Pressed implements ActionListener
   {
   /**
   * Removes player selected from the team
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         xPos += direction;
         if (xPos + image.getWidth() > getWidth()) {
            xPos = getWidth() - image.getWidth();
            direction *= -1;
         } else if (xPos < 0) {
            xPos = 0;
            direction *= -1;
         }
         repaint();
      }
   }
   private class DeleteTeam2Pressed implements ActionListener
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
   private class Animation implements ActionListener
   {
   /**
   * Runs animation
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
            
      }
   }
}
