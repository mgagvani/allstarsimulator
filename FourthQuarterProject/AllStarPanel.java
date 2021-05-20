

import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.Timer;
import java.awt.image.*;
import java.util.*;
import java.util.List;
import java.io.*;
import javax.swing.JOptionPane;
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

* @param image
* @param xPos
* @param yPos
* @param direction
* @param playernum
* @param firstpressed

* @param players
* @param team
* @param Arraylist players
* @param AllPlayers
* @param playernum
* @param firstpressed
   
*/
public class AllStarPanel extends JPanel{

   BufferedImage image;
   BufferedImage logo;
   ImageIcon logo2;
   BufferedImage hoop;
   int xPos = 0;
   int yPos = 650;
   int direction =1;
   int playernumt1 = 0;
   int playernumt2 = 0;
   Boolean firstpressed = false;
   Boolean firstpressedt2 = false;
   
   
   Player p1t1 = new Player();
   Player p2t1 = new Player();
   Player p3t1 = new Player();
   Player p4t1 = new Player();
   Player p5t1 = new Player();
   
   Player p1t2 = new Player();
   Player p2t2 = new Player();
   Player p3t2 = new Player();
   Player p4t2 = new Player();
   Player p5t2 = new Player();
   
   ArrayList<Player> allPlayers = new ArrayList<>();
   Player [] allPlayersArray;
   Team [] teams;
   
   int [] team1scores = new int [5];
   int [] team2scores = new int [5];
   
   String [] turnResult;
   
   Team t1 = new Team("Donuts",0.5,0.5);
   Team t2 = new Team("Hot Dogs", 0.5, 0.5);
   int scoret1 = 0;
   int scoret2 = 0;
   int delay = 0;
   int quarter = 0;
   
   String team1s = "";
   String team2s = "";
   Game game = new Game();
   String message = "";
   
   
   
      
   JLabel directions = new JLabel("                                  Select players from the drop down menu.");
   JLabel directions2 = new JLabel("Then, add them to the perfered team.");
   JButton addt1 = new JButton("Add Team 1");
   JButton deletet1 = new JButton("Delete Team 1");
   JButton addt2 = new JButton("Add Team 2");
   JButton deletet2 = new JButton("Delete Team 2");
      
   JLabel menuLabel = new JLabel("Select a player:");
      
   JComboBox playerlist = new JComboBox();
      
   JLabel team1 = new JLabel("The Untouchaballs:");
      
   JLabel player1t1 = new JLabel("player 1");
   JLabel player2t1 = new JLabel("player 2");
   JLabel player3t1 = new JLabel("player 3");
   JLabel player4t1 = new JLabel("player 4");
   JLabel player5t1 = new JLabel("player 5");
      
   JLabel team1score = new JLabel("Score:");
      
   JLabel team2 = new JLabel("Swish Kebabs:");
      
   JLabel player1t2 = new JLabel("player 1");
   JLabel player2t2 = new JLabel("player 2");
   JLabel player3t2 = new JLabel("player 3");
   JLabel player4t2 = new JLabel("player 4");
   JLabel player5t2 = new JLabel("player 5");
      
   JLabel team2score = new JLabel("Score:");
   JButton start = new JButton("START");
   JButton reset = new JButton("RESET");
   JButton cancel = new JButton("CANCEL");
   JButton quit = new JButton("QUIT");
   
   JTextField score = new JTextField("0:0");
   JTextField info = new JTextField("Info",40);
   Boolean flag = false;
   Timer timer;
   java.net.URL f;
   
   
   ArrayList<String> players = new ArrayList<>();
   String line = "";
      
   public AllStarPanel () 
   {
      // Working on this part
      message = message + "\n1. 2011-2012";
      message = message + "\n2. 2012-2013";
      message = message + "\n3. 2013-2014";
      message = message + "\n4. 2014-2015";
      message = message + "\n5. 2016-2017";
      message = message + "\n6. 2017-2018";
      message = message + "\n7. 2018-2019";
      message = message + "\n8. 2019-2020";
      message = message + "\n9. 2020-2021";
      int choice = Integer.parseInt(JOptionPane.showInputDialog(message));
      
      switch(choice)
      {
         case 1: f = getClass().getResource("playersRegular2011-12.csv");
            break;
         case 2: f = getClass().getResource("playersRegular2012-13.csv");
            break;
         case 3: f = getClass().getResource("playersRegular2013-14.csv");
            break;
         case 4: f = getClass().getResource("playersRegular2014-15.csv");
            break;
         case 5: f = getClass().getResource("playersRegular2016-17.csv");
            break;
         case 6: f = getClass().getResource("playersRegular2017-18.csv");
            break;
         case 7: f = getClass().getResource("playersRegular2018-19.csv");
            break;
         case 8: f = getClass().getResource("playersRegular2019-20.csv");
            break;
         case 9: f = getClass().getResource("playersRegular2020-21.csv");
            break;
         default: f= getClass().getResource("players.csv");
         break;
               
      }
      java.net.URL logoURL = getClass().getResource("Logo.png");
      logo2 = new ImageIcon(logoURL);
      JOptionPane.showMessageDialog(null, "All Star!","Logo", JOptionPane.INFORMATION_MESSAGE, logo2);
      
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(f.openStream())); 
         
         while ((line = br.readLine()) != null)
         {
            
            String [] parameters = line.split(",");
            for(int x = 0; x < parameters.length; x++)
            {
               players.add(parameters[x]);
            } 
         }
      }
      catch(IOException e)
      {
      
      }  
      for(int x = 0; x < players.size();x+=25)
      {
         playerlist.addItem((players.get(x)));
      }
      
      for (int x = 25; x < players.size(); x+=25)
      {
         
         allPlayers.add(new Player(players.get(x),Double.parseDouble(players.get(x+4)),Double.parseDouble(players.get(x+5)),Double.parseDouble(players.get(x+6)),Double.parseDouble(players.get(x+7)),Double.parseDouble(players.get(x+8)),Double.parseDouble(players.get(x+9)),Double.parseDouble(players.get(x+10)),Double.parseDouble(players.get(x+11)),Double.parseDouble(players.get(x+12)),Double.parseDouble(players.get(x+13)),Double.parseDouble(players.get(x+14)),Double.parseDouble(players.get(x+15)),Double.parseDouble(players.get(x+16)),Double.parseDouble(players.get(x+17)),Double.parseDouble(players.get(x+18)),Double.parseDouble(players.get(x+19)),Double.parseDouble(players.get(x+20)),Double.parseDouble(players.get(x+22)),Double.parseDouble(players.get(x+23)),Double.parseDouble(players.get(x+24))));
      }
      allPlayersArray = new Player[allPlayers.size()];
      for(int x = 0; x < allPlayers.size(); x++)
      {
         allPlayersArray[x] = allPlayers.get(x);
      }
     
      JPanel top = new JPanel();
     
      
      top.setLayout(new GridLayout(0,2));
      
      quit.addActionListener(new QuitPressed());
      start.addActionListener(new StartPressed());
      reset.addActionListener(new ResetPressed());
      cancel.addActionListener(new CencelPressed());
      addt1.addActionListener(new SelectDropDownTeam1());
      addt2.addActionListener(new SelectDropDownTeam2());
      deletet1.addActionListener(new DeleteTeam1Pressed());
      deletet2.addActionListener(new DeleteTeam2Pressed());
      
      
      setBackground(Color.BLUE);
      top.setBackground(Color.RED);
      
      
      
      
   
      top.add(directions);
      
      top.add(directions2); 
      
      
      top.add(addt1);
      top.add(addt2);
      
      
      
      top.add(deletet1);
      top.add(deletet2);
      
      top.add(menuLabel);
      top.add(new JLabel()); //used to occupy a slot allowing the formatting to look better
      
      top.add(playerlist);
      
      top.add(new JLabel());
      
      
      
      top.add(team1);
      top.add(team2);
      
      top.add(player1t1);
      top.add(player1t2);
      
      top.add(player2t1);
      top.add(player2t2);
      
      top.add(player3t1);
      top.add(player3t2);
      
      top.add(player4t1);
      top.add(player4t2);
      
      top.add(player5t1);
      top.add(player5t2);
      
      
      
      top.add(start);
      top.add(reset);
      top.add(cancel);
      top.add(quit);
      
      add(top, BorderLayout.NORTH);
      
      JPanel subPanel = new JPanel();
      subPanel.setLayout(new GridLayout(0,1));
      score.setFont(new Font("Serif", Font.PLAIN, 100));
      score.setBackground(Color.RED);
      subPanel.add(score);
      info.setFont(new Font("Serif", Font.PLAIN, 20));
      info.setBackground(Color.RED);
      subPanel.add(info);
      subPanel.setBackground(Color.RED);
      add(subPanel, BorderLayout.SOUTH);
      
      try{
         java.net.URL basketball = getClass().getResource("basketball.png");
         image = ImageIO.read(basketball);
      
      }
      catch(IOException ex)
      {
      
      }
      try{
         java.net.URL logoResource = getClass().getResource("Logo.png");
         logo = ImageIO.read(logoResource);
      
      }
      catch(IOException ex)
      {
         
      }
      try{
         java.net.URL hoopResource = getClass().getResource("basketballHoop.png");
         hoop = ImageIO.read(hoopResource);
      
      }
      catch(IOException ex)
      {
      
      }
   
               
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
     
      
      
      
      
      
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
      g.drawImage(image, xPos,yPos,50,50, this);
      g.drawImage(hoop, 170,600,250,250, this);
      g.drawImage(logo, 590,650, 200, 100, this);
      
   }
  
   private class StartPressed implements ActionListener
   {
   /**
   * Runs the simulation of a game between the selected players
   * Also runs animation. The one timer delays the labels but sustains animation.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         
         if (flag == true)
         {
         
         t1.reset_scores();
         t2.reset_scores();
         timer.stop();
         }
         
         flag = false;
         t1.addPlayer(p1t1);
         t1.addPlayer(p2t1);
         t1.addPlayer(p3t1);
         t1.addPlayer(p4t1);
         t1.addPlayer(p5t1);
         
         t2.addPlayer(p1t2);
         t2.addPlayer(p2t2);
         t2.addPlayer(p3t2);
         t2.addPlayer(p4t2);
         t2.addPlayer(p5t2);
         
         for (int x = 0; x < 5 - 1; x++)
         {
            for (int y = x + 1; y < 5; y++)
            {
               if (t1.get_players()[x].get_name().compareTo(t1.get_players()[y].get_name()) == 0)
               {
                  info.setText("Duplicate players!");
                  flag = true;
               }
            }
         }
         
         for (int x = 0; x < 5 - 1; x++)
         {
            for (int y = x + 1; y < 5; y++)
            {
               if (t2.get_players()[x].get_name().compareTo(t2.get_players()[y].get_name()) == 0)
               {
                  info.setText("Duplicate players");
                  flag = true;
               }
            }
         }
         
         teams = new Team[2];
         teams[0] = t1;
         teams[1] = t2;
      
         String[] team1players = new String[]{p1t1.get_name(),p2t1.get_name(),p3t1.get_name(),p4t1.get_name(),p5t1.get_name()};
         String[] team2players = new String[]{p1t2.get_name(),p2t2.get_name(),p3t2.get_name(),p4t2.get_name(),p5t2.get_name()};
         
         game = new Game(teams, allPlayersArray, 200);
         
         int numPossessions = game.add_players_to_teams(team1players, team2players);
         
         try {
              
            timer = new Timer(20, 
               new ActionListener() {
                  @Override
                    public void actionPerformed(ActionEvent e) {
                     if (flag == false)
                     {
                        yPos = (int)((0.006)*(Math.pow(xPos, 2)) - 1.3*xPos + 670);
                        xPos += direction;
                        if (xPos + image.getWidth() > getWidth()+50) {
                           xPos = getWidth() - image.getWidth();
                           direction *= -1;
                        } else if (xPos < 0) {
                           xPos = 0;
                           direction *= -1;
                        }
                        if (yPos + image.getHeight() > getHeight() +240 && xPos > 200)
                        {
                           
                           xPos = 0;
                        }
                        repaint();
                        delay++;
                        if (delay % 10 == 0)
                        {
                           turnResult = game.play_turn();
                           
                        
                           scoret1 = game.get_team1_score();
                           scoret2 = game.get_team2_score();
                        
                           score.setText(scoret1 + " : " + scoret2);
                           if(turnResult.length == 4)
                           {
                              team1s = turnResult[0];
                              team2s = turnResult[1];
                              
                              int currentPossession = Integer.parseInt(turnResult[3]);
                              if (currentPossession < 0.25 * numPossessions)
                              {
                                 quarter = 1;
                              }
                              else if (currentPossession < 0.5 * numPossessions)
                              {
                                 quarter = 2;
                              }
                              else if (currentPossession < 0.75 * numPossessions)
                              {
                                 quarter = 3;
                              }
                              else
                              {
                                 quarter = 4;
                              }
                           
                              info.setText("Quarter: " + quarter + " " + turnResult[2]);
                           }
                           else
                           {
                              flag = true;
                           
                              info.setFont(new Font("Serif", Font.BOLD, 50));
                              if(Integer.parseInt(team1s) > Integer.parseInt(team2s))
                                 info.setText("WINNER: The Untouchaballs!");
                              else
                                 info.setText("WINNER: The Swish Kebabs!");
                              info.setFont(new Font("Serif", Font.PLAIN, 20));
                           }
                              
                           delay = 0;
                           
                           player1t1.setText("Player: " + p1t1.get_name() + " points: " + game.get_team1_scores()[0]);
                           player2t1.setText("Player: " + p2t1.get_name() + " points: " + game.get_team1_scores()[1]);
                           player3t1.setText("Player: " + p3t1.get_name() + " points: " + game.get_team1_scores()[2]);
                           player4t1.setText("Player: " + p4t1.get_name() + " points: " + game.get_team1_scores()[3]);
                           player5t1.setText("Player: " + p5t1.get_name() + " points: " + game.get_team1_scores()[4]);
                           
                           player1t2.setText("Player: " + p1t2.get_name() + " points: " + game.get_team2_scores()[0]);
                           player2t2.setText("Player: " + p2t2.get_name() + " points: " + game.get_team2_scores()[1]);
                           player3t2.setText("Player: " + p3t2.get_name() + " points: " + game.get_team2_scores()[2]);
                           player4t2.setText("Player: " + p4t2.get_name() + " points: " + game.get_team2_scores()[3]);
                           player5t2.setText("Player: " + p5t2.get_name() + " points: " + game.get_team2_scores()[4]);
                        }
                     
                     
                     }
                     
                     
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
   * Ensures the player selected is added to the team for the most recent available place.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         int count = 0;
         if(firstpressed == true && playernumt1 != 0)
         {
            playernumt1 -=1;
            firstpressed = false;
         }
         if(firstpressed == true && playernumt1 == 0)
         {
            firstpressed = false;
         }
         if(playernumt1 < 5)
         {
            playernumt1+=1;
         }
         if (playernumt1 == 1)
         {
            player1t1.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p1t1 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));
            
         }
         else if (playernumt1 == 2)
         {
            player2t1.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            } 
            p2t1 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));
               
         }
         else if (playernumt1 == 3)
         {
            player3t1.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            } 
            p3t1 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));
               
         }
         else if (playernumt1 == 4)
         {
            player4t1.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            } 
            p4t1 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));
               
         }
         else if (playernumt1 == 5)
         {
            player5t1.setText("Player: " + playerlist.getSelectedItem().toString());
            
            
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            } 
            p5t1 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));
            
               
         }
         
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
   * Ensures the player selected is added to the team for the most recent available place.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         int count = 0;
         if(firstpressedt2 == true && playernumt2 != 0)
         {
            playernumt2 -=1;
            firstpressedt2 = false;
         }
         if(firstpressedt2 == true && playernumt2 == 0)
         {
            firstpressedt2 = false;
         } 
           
         if(playernumt2 < 5)
         {
            playernumt2 +=1;
         }
         if (playernumt2 == 1)
         {
            player1t2.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p1t2 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));   
         }
         else if (playernumt2 == 2)
         {
            player2t2.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p2t2 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));   
         }
         else if (playernumt2 == 3)
         {
            player3t2.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p3t2 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));  
         }
         else if (playernumt2 == 4)
         {
            player4t2.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p4t2 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));   
         }
         else if (playernumt2 == 5)
         {
            player5t2.setText("Player: " + playerlist.getSelectedItem().toString());
            while (!players.get(count).equals(playerlist.getSelectedItem().toString()))
            {
               count+=25;
            }
            p5t2 = new Player(players.get(count),Double.parseDouble(players.get(count+4)),Double.parseDouble(players.get(count+5)),Double.parseDouble(players.get(count+6)),Double.parseDouble(players.get(count+7)),Double.parseDouble(players.get(count+8)),Double.parseDouble(players.get(count+9)),Double.parseDouble(players.get(count+10)),Double.parseDouble(players.get(count+11)),Double.parseDouble(players.get(count+12)),Double.parseDouble(players.get(count+13)),Double.parseDouble(players.get(count+14)),Double.parseDouble(players.get(count+15)),Double.parseDouble(players.get(count+16)),Double.parseDouble(players.get(count+17)),Double.parseDouble(players.get(count+18)),Double.parseDouble(players.get(count+19)),Double.parseDouble(players.get(count+20)),Double.parseDouble(players.get(count+22)),Double.parseDouble(players.get(count+23)),Double.parseDouble(players.get(count+24)));   
         }
            
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
   * Setting the flag as true terminates the scoring process of the simulation and the animation.
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         flag = true;
         timer.stop();
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
   * Resets all labels and all values from the Team and Game class.
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         if(flag == true)
         {
            player1t1.setText("Player 1");
            player2t1.setText("Player 2");
            player3t1.setText("Player 3");
            player4t1.setText("Player 4");
            player5t1.setText("Player 5");
            
            player1t2.setText("Player 1");
            player2t2.setText("Player 2");
            player3t2.setText("Player 3");
            player4t2.setText("Player 4");
            player5t2.setText("Player 5");
            
            
            score.setText("0:0");
            info.setText("Info:");
            
            game.init_game();
            
            t1.reset_scores();
            t1.reset_splits();
            t1.resetPlayers();
            t2.reset_scores();
            t2.reset_splits();
            t2.resetPlayers();
            
            playernumt1 = 0;
            playernumt2 = 0;
            
            timer.stop();
         }
            
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
   * Removes the most recent player selected from the team
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         if(firstpressed == false && playernumt1 != 6)
         {
            playernumt1 +=1;
            firstpressed = true;
         }
         else if(firstpressed == false && playernumt1 == 6)
         {
            firstpressed = true;
         }
         if (playernumt1 >0)
         {
            playernumt1 -= 1;
         }
         if (playernumt1 == 1)
         {
            playernumt1 -=1;
            player1t1.setText("Player: ");
            
         }
         if (playernumt1 == 2)
         {
            player2t1.setText("Player: ");
            
         }
         if (playernumt1 == 3)
         {
            player3t1.setText("Player: ");
            
         }
         if (playernumt1 == 4)
         {
            player4t1.setText("Player: ");
            
         }
         if (playernumt1 == 5)
         {
            player5t1.setText("Player: ");
            
         }
         
      }
   }
   private class DeleteTeam2Pressed implements ActionListener
   {
   /**
   * Removes the most recent player selected from the team
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         if(firstpressedt2 == false && playernumt2 != 6)
         {
            playernumt2 +=1;
            firstpressedt2 = true;
         }
         else if(firstpressedt2 == false && playernumt2 == 6)
         {
            firstpressedt2 = true;
         }
         if (playernumt2 >0)
         {
            playernumt2 -= 1;
         }
         if (playernumt2 == 1)
         {
            playernumt2 -=1;
            player1t2.setText("Player: ");
            
         }
         if (playernumt2 == 2)
         {
            player2t2.setText("Player: ");
            
         }
         if (playernumt2 == 3)
         {
            player3t2.setText("Player: ");
            
         }
         if (playernumt2 == 4)
         {
            player4t2.setText("Player: ");
            
         }
         if (playernumt2 == 5)
         {
            player5t2.setText("Player: ");
            
         }
      }
   }
   /**
   * Exits the program regardless of where the program is
   *
   *
   */
   private class QuitPressed implements ActionListener
   {
   /**
   * Exits the program
   *
   * @param actionEvent e
   */
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   
}
