// Name: Manav Gagvani
// Period: 2nd
// Date: April 27th, 2021

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
    private String[] fgaOrder;

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
    }

    /**
     * Reset information about the game, so that another one can start. 
     */
    public void init_game() {

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
