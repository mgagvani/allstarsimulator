// Name: Manav Gagvani
// Period: 2nd
// Date: April 27th, 2021

/**
 * The Team class contains information about each team.
 * It contains 5 Players as well as some other data regarding the team as a whole, including the team's name.
 * 
 * @author Manav Gagvani
*/
public class Team {
    private String name;
    private Player[] players;
    private int appendIdx = 0;
    private double pct2PA, pct3PA;

    /**
     * Constructor for Team. 
     * Takes the team's name as well as data about the overall tendencies of a team.
     * 
     * @param name Name of the team
     * @param pct2PA The percentage of the team's shot attempts which are inside the three point line
     * @param pct3PA The percentage of the team's shot attempts which are outside the three point line (Equal to 1- pct2PA)
     */
    public Team(String name, double pct2PA, double pct3PA) {
        assert(1 - pct2PA == pct3PA);
        this.name = name;
        this.pct2PA = pct2PA;
        this.pct3PA = pct3PA;
    }

    /**
     * Adds a Player to the Team, specifically the array players. 
     * 
     * @param player Player object
     */
    public void addPlayer(Player player) {
        players[appendIdx] = player;
        appendIdx += 1;
    }

    /**
     * Resets the scores of each player in the team to 0.
     */
    public void reset_scores() {
        for(Player player : players) {
            player.reset_score();
        }
    }

    /**
     * Gets the scores for each player in the team.
     * The indexing of scores matches with the players array, so scores[0] corresponds with players[0].
     * 
     * @return Points scored by each player in an array. 
     */
    public int[] get_scores() {
        int[] scores = new int[players.length];
        int i = 0;
        for(Player player: players) {
            scores[i] = player.get_score();
            i += 1;
        }
        return scores;
    }

    /**
     * Gets the shooting percentages for each player.
     * 
     * @see get_scores() for information on indexing 
     * @return A 2D array of int, which are the player's shot makes and shot attempts
     */
    public int[][] get_shooting_splits() {
        int[][] splits = {};
        int i = 0;
        for(Player player: players) {
            splits[i] = player.get_splits();
        }
        return splits;
    }

    /**
     * Resets the shooting percentages for each player on the team.
     */
    public void reset_splits() {
        for(Player player: players) {
            player.reset_splits();
        }
    }

    /**
     * Returns an array of the team's players
     */
    public Player[] get_players() {
        return players;
    }
}
