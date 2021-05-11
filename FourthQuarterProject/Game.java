// Name: Manav Gagvani
// Period: 2nd
// Date: April 27th, 2021

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Collections;
import java.*;

import org.apache.commons.lang3.ArrayUtils;

/**
 * The Game class contains information about the entire game.
 * It contains 2 Teams, as well as information such as the score, the current turn, and all possible player names.
 * It also contains the logic for actually simulating a basketball game. 
 * 
 * @author Manav Gagvani
*/
public class Game {
    private Team[] teams;
    private Team team1;
    private Team team2;
    private int team1score = 0;
    private int team2score = 0;
    private Player[] players;
    private int numPossesions;
    private int turnsPlayed;
    private List<String> allAttempts = Arrays.asList();
    private List<Player> allPlayersInGame;
    public List<String> fgaOrder;
    public Player playerWithBall;

    /**
     * Constructor for Game.
     * Takes the two teams, all the players that can play, and the number of possesions in the game.
     * 
     * @param teams 2 Team objects
     * @param players Array of every Player object that can be used
     * @param numPossesions Number of possessions in a game, usually around 100 per team
     */
    public Game(Team[] teams, Player[] players, int numPossesions) {
        this.team1 = teams[0];
        this.team2 = teams[1];
        this.teams = teams;

        this.team1score = 0;
        this.team2score = 0;

        this.players = players;
        this.numPossesions = numPossesions;

    }

    /**
     * Adds players to teams. 
     * Contains logic to normalize shot attempts by estimating usage rate.
     * 
     * @param team1players Player names to be added to team 1 as Player objects.
     * @param team2players Player names to be added to team 2 as Player objects. 
     */
    public void add_players_to_teams(String[] team1players, String[] team2players) {
        for(String playerName : team1players) {
            for(Player player : players) {
                if(player.get_name() == playerName) {
                    team1.addPlayer(player);
                    break;
                }
            }
        }

        for(String playerName : team2players) {
            for(Player player : players) {
                if(player.get_name() == playerName) {
                    team2.addPlayer(player);
                    break;
                }
            }
        }

        // still need to find out distribution of possesions for players 
        // THIS IS INCOMPLETE
        Map<String, Integer> playerFGAs = new HashMap<>();
        List<String> allAttempts = new ArrayList<String>();

        // String[] allPlayerNames = ArrayUtils.addAll(team1players, team2players);
        String[] allPlayerNames = Arrays.copyOf(team1players, team1players.length + team2players.length);
        System.arraycopy(team2players, 0, allPlayerNames, team1players.length, team2players.length);
        int totalFGA = 0;

        for(String playerName: allPlayerNames) {
            for(Player player: team1.get_players()) {
                if(player.get_name() == playerName) {
                    playerFGAs.put(player.get_name(), player.get_fga());
                    totalFGA += player.get_fga();
                }
            }

            for(Player player: team2.get_players()) {
                if(player.get_name() == playerName) {
                    playerFGAs.put(player.get_name(), player.get_fga());
                    totalFGA += player.get_fga();
                }
            }
        }

        double normFactor = numPossesions/totalFGA;

        for(String playerName : allPlayerNames) {
            int normFGA = (int)Math.round(normFactor * playerFGAs.get(playerName));
            playerFGAs.put(playerName, normFGA);
        }

        for(String playerName : allPlayerNames) {
            int attemptNumber = 1;
            for(; attemptNumber < playerFGAs.get(playerName); attemptNumber++) {
                allAttempts.add(playerName);
            }
        }

        // Shuffle using the Fisher-Yates algorithm
        Random r = new Random();

        for(int i = allAttempts.size() - 1; i > 0; i--) {
            int j = r.nextInt(i);

            String temp = allAttempts.get(i);
            allAttempts.add(i, allAttempts.get(j));
            allAttempts.add(j, temp);
        }
        fgaOrder = allAttempts;

        //if numPossessions is more than length of fgaOrder, add at the end
        for(int i = 1; i < 1 + numPossesions - fgaOrder.size(); i++) {
            // String randomPlayerName = Collections.shuffle(Arrays.asList(allPlayerNames));
            Random rand = new Random();
            String randomPlayerName = allPlayerNames[rand.nextInt(allPlayerNames.length)];
            fgaOrder.add(randomPlayerName);
        }

    }

    /**
     * Reset information about the game, so that another one can start. 
     */
    public void init_game() {
        team1score = 0;
        team2score = 0;
        turnsPlayed = 0;
        team1.reset_scores();
        team2.reset_scores();
        team1.reset_splits();
        team2.reset_splits();
        team1.set_players(new Player[]{}); // no players
        team2.set_players(new Player[]{});
    }

    /**
     * Contains the logic for simulating a basketball game. 
     * Uses the normalized shot attempts information to create an accurate representation of a game.
     * For example, Michael Jordan would attempt more shots than other players on his team, instead of each player getting an equal number of shot attempts.
     * 
     * @return Updated scores and the specific turn outcome.
     */
    public String[] play_turn() {
        String turnoutcome = "";
        // private Player playerWithBall;
        List<Player> playingPlayers = new ArrayList<Player>(); // not being used for now?

        if(turnsPlayed >= numPossesions) {
            return new String[]{"error"}; // Error
        }

        String playerNameWithBall = fgaOrder.get(turnsPlayed);
        for(Player player : ArrayUtils.addAll(team1.get_players(), team2.get_players())) {
            if(player.get_name() == playerNameWithBall) {
                playerWithBall = player;
                break;
            }
        }

        turnoutcome = "" + playerNameWithBall + "did not score";

        int[] poss = new int[] {2,3};
        int position = new Random().nextInt(poss.length);

        if(position == 3) {
            boolean make = playerWithBall.shoot3pt(turnsPlayed);
            if(make) {
                turnoutcome = "" + playerNameWithBall + "made a 3-pointer";
                if(ArrayUtils.contains(team1.get_players(), playerWithBall)) {
                    team1score += 3;
                    playerWithBall.add_score(3);
                    playerWithBall.add_make(3);
                    playerWithBall.add_attempt(3);
                    playerWithBall = team2.get_players()[new Random().nextInt(team2.get_players().length)]; // inbound ball to person on other team
                }
                else if(ArrayUtils.contains(team2.get_players(), playerWithBall)) {
                    team2score += 3;
                    playerWithBall.add_score(3);
                    playerWithBall.add_make(3);
                    playerWithBall.add_attempt(3);
                    playerWithBall = team1.get_players()[new Random().nextInt(team1.get_players().length)]; // inbound ball to person on other team
                }
                else {}; // do nothing for now
            }
            else if(!make) {
                playerWithBall.add_attempt(3);
                Random rand = new Random();
                playerWithBall = playingPlayers.get(rand.nextInt(playingPlayers.size()));
            }
        }

        if(position == 2) {
            boolean make = playerWithBall.shoot2pt(turnsPlayed);
            if(make) {
                turnoutcome = "" + playerNameWithBall + "made a 2-pointer";
                if(ArrayUtils.contains(team1.get_players(), playerWithBall)) {
                    team1score += 2;
                    playerWithBall.add_score(2);
                    playerWithBall.add_make(2);
                    playerWithBall.add_attempt(2);
                    playerWithBall = team2.get_players()[new Random().nextInt(team2.get_players().length)]; // inbound ball to person on other team
                }
                else if(ArrayUtils.contains(team2.get_players(), playerWithBall)) {
                    team2score += 2;
                    playerWithBall.add_score(2);
                    playerWithBall.add_make(2);
                    playerWithBall.add_attempt(2);
                    playerWithBall = team1.get_players()[new Random().nextInt(team1.get_players().length)]; // inbound ball to person on other team
                }
                else {}; // do nothing for now
            }
            else if(!make) {
                playerWithBall.add_attempt(2);
                Random rand = new Random();
                playerWithBall = playingPlayers.get(rand.nextInt(playingPlayers.size()));
            }
        }

        turnsPlayed += 1;
        
        return new String[] {""+team1score,""+team2score,turnoutcome};
    }

    /**
     * Gets team 1's score.
     * @return team 1's score
     */
    public int[] get_team1_scores() {
        return team1.get_scores();
    }

    /**
     * @see get_team1_scores()
     * @return team 2's score
     */
    public int[] get_team2_scores() {
        return team2.get_scores();
    }

    /**
     * Gets the shooting percentages for each player in Team 1
     * @return Team 1 shooting splits
     */
    public int[][] get_team1_splits() {
        return team1.get_shooting_splits();
    }

    /**
     * @see get_team1_splits()
     * @return Team 2 shooting splits
     */
    public int[][] get_team2_splits() {
        return team2.get_shooting_splits();
    }

    /**
     * Removes the specified player from team 1.
     * 
     * @param playerName Name of the player to be deleted
     */
    public void del_from_team1(String playerName) {
        int idx = 0;
        for(Player player : team1.get_players()) {
            if(player.get_name() == playerName) {
                Player[] team1players = team1.get_players();
                team1players[idx] = null;
                team1.set_players(team1players);
                break;
            }
            idx += 1;
        }
    }

    /**
     * @see del_from_team1()
     * @param playerName Name of the player to  be deleted
     */    
    public void del_from_team2(String playerName) {
        int idx = 0;
        for(Player player : team2.get_players()) {
            if(player.get_name() == playerName) {
                Player[] team2players = team2.get_players();
                team2players[idx] = null;
                team1.set_players(team2players);
                break;
            }
            idx += 1;
        }
    }
}
