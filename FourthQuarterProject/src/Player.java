// Name: Manav Gagvani
// Period: 2nd
// Date: April 26th, 2021

/**
 * The Player class contains information about each player.
 * It also contains methods to access the player's statistics and simulate actions.
 * 
 * @author Manav Gagvani
*/
public class Player {
    private String name;
    private double RestrictArea_FGpercent,Paint_FGpercent,MidRange_FGpercent,LeftCorner3_FGpercent,RightCorner3_FGpercent,AboveBreak3_FGpercent;
    private int RestrictArea_FGA,Paint_FGA,MidRange_FGA,LeftCorner3_FGA,RightCorner3_FGA,Totals_FGA,AboveBreak3_FGA;
    private int RestrictArea_FGM,Paint_FGM,MidRange_FGM,LeftCorner3_FGM,RightCorner3_FGM,AboveBreak3_FGM,Totals_FGM;
    private int pointsScored;
    private int twoPTM, twoPTA, threePTM, threePTA;
    private boolean[] lotsOfShots2;
    private boolean[] lotsOfShots3;

    /**
     * Constructor for Player. 
     * Takes information about the player's on-court stats and the player's name
     * 
     * @param name Name of the player
     * @param RestrictArea_FGpercent Percent of shots made in the restricted area
     * @param Paint_FGpercent Percent of shots made in the paint, outside the restricted area
     * @param MidRange_FGpercent Percent of shots made in the midrange area of the court
     * @param LeftCorner3_FGpercent Percent of left corner 3-pointers made
     * @param RightCorner3_FGpercent Percent of right coner 3-pointers made
     * @param AboveBreak3_FGpercent Percent of above-the-break 3-pointers made
     * @param RestrictArea_FGA Average number of shots taken per game in the restricted area
     * @param Paint_FGA Average number of shots taken in the paint, outside of the restricted area
     * @param MidRange_FGA Average number of shots taken per game in the midrange area of the court
     * @param LeftCorner3_FGA Average number of left corner 3-pointers attempted per game
     * @param RightCorner3_FGA Average number of right corner 3-pointers attempted per game
     * @param Totals_FGA Average number of shot attempts per game by the player
     * @param AboveBreak3_FGA Average number of above-the-break 3-pointers attempted per game
     * @param RestrictArea_FGM Average number of shots made per game in the restricted area
     * @param Paint_FGM Average number of shots made in the paint, but outside of the restricted area
     * @param MidRange_FGM Average number of shots made per game in the midrange area of the court
     * @param LeftCorner3_FGM Average number of left corner 3-pointers made per game
     * @param RightCorner3_FGM Average number of right corner 3-pointers made per game
     * @param AboveBreak3_FGM Average number of above-the-break 3-pointers made per game
     * @param Totals_FGM Average number of made shots per game by the player
     */
    public Player(String name, double RestrictArea_FGpercent, double Paint_FGpercent, double MidRange_FGpercent, double LeftCorner3_FGpercent, double RightCorner3_FGpercent, double AboveBreak3_FGpercent, int RestrictArea_FGA, int Paint_FGA, int MidRange_FGA, int LeftCorner3_FGA, int RightCorner3_FGA, int Totals_FGA, int AboveBreak3_FGA, int RestrictArea_FGM, int Paint_FGM, int MidRange_FGM, int LeftCorner3_FGM, int RightCorner3_FGM, int AboveBreak3_FGM, int Totals_FGM) {
        this.name = name;
        this.RestrictArea_FGpercent = RestrictArea_FGpercent;
        this.Paint_FGpercent = Paint_FGpercent;
        this.MidRange_FGpercent = MidRange_FGpercent;
        this.LeftCorner3_FGpercent = LeftCorner3_FGpercent;
        this.RightCorner3_FGpercent = RightCorner3_FGpercent;
        this.AboveBreak3_FGpercent = AboveBreak3_FGpercent;

        this.RestrictArea_FGA = RestrictArea_FGA;
        this.Paint_FGA = Paint_FGA;
        this.MidRange_FGA = MidRange_FGA;
        this.LeftCorner3_FGA = LeftCorner3_FGA;
        this.RightCorner3_FGA = RightCorner3_FGA;
        this.Totals_FGA = Totals_FGA;
        this.AboveBreak3_FGA = AboveBreak3_FGA;

        this.RestrictArea_FGM = RestrictArea_FGM;
        this.Paint_FGM = Paint_FGM;
        this.MidRange_FGM = MidRange_FGM;
        this.LeftCorner3_FGM = LeftCorner3_FGM;
        this.RightCorner3_FGM = RightCorner3_FGM;
        this.AboveBreak3_FGM = AboveBreak3_FGM;
        this.Totals_FGM = Totals_FGM;

        this.twoPTA = this.RestrictArea_FGA + this.Paint_FGA + this.MidRange_FGA;
        this.threePTA = this.LeftCorner3_FGA + this. RightCorner3_FGA + this.AboveBreak3_FGA;

        double TwoPTpercent;
        double ThreePTpercent;

        if(this.twoPTA == 0) {TwoPTpercent = 0;}
        else {
            TwoPTpercent = (this.RestrictArea_FGM + this.Paint_FGM + this.MidRange_FGM) / (this.twoPTA);
        }

        if(this.threePTA == 0) {ThreePTpercent = 0;}
        else {
            ThreePTpercent = (this.LeftCorner3_FGM + this.RightCorner3_FGM + this.AboveBreak3_FGM)/(this.threePTA);
        }

        pointsScored = 0;
        twoPTM = 0;
        twoPTA = 0;
        threePTM = 0;
        threePTA = 0;

        int fga = this.RestrictArea_FGA + this.Paint_FGA + this.MidRange_FGA + this.LeftCorner3_FGA + this.RightCorner3_FGA + this.AboveBreak3_FGA;

        boolean[] lotsOfShots2 = new boolean[1000];
        boolean[] lotsOfShots3 = new boolean[1000];

        for(int i = 0; i < 1000; i++) {
            double rand = Math.random();
            // calculate 3 pt
            if(rand < ThreePTpercent) lotsOfShots3[i] = true;
            else if(rand > ThreePTpercent) lotsOfShots3[i] = false;
            // calculate 2 pt
            if(rand < TwoPTpercent) lotsOfShots2[i] = true;
            else if(rand > TwoPTpercent) lotsOfShots2[i] = false;
        }

    }

    /**
     * Resets the player's score
     */
    public void reset_score() {
        pointsScored = 0;
    }

    /**
     * Gets the number of points the player has scored
     * 
     * @return pointsScored The number of points the player has scored
     */
    public int get_score() {
        return pointsScored;
    }

    /**
     * Returns the player's shooting percentages and per-game shot attempts as well as makes
     * 
     * @return Array of integers with twoPTM, twoPTA, threePTM, and threePTA
     */
    public int[] get_splits() {
        return new int[]{twoPTM, twoPTA, threePTM, threePTA};
    }

    /** 
     * Resets the player's shooting splits
     */
    public void reset_splits() {
        twoPTM = 0;
        twoPTA = 0;
        threePTM = 0;
        threePTA = 0;
    }

    /**
     * Simulates the player shooting a two-pointer and returns true for a made shot and false for a missed shot
     * @param turn Current possession number of the game
     * @return If the shot was made or not
     */
    public boolean shoot2pt(int turn) {
        if(lotsOfShots2[turn] == true) return true;
        else {return false;}
    }

    /**
     * Simulates the player shooting a three-pointer and returns true for a made shot and false for a missed shot
     * @param turn Current possession number of the game
     * @return If the shot was made or not
     */
    public boolean shoot3pt(int turn) {
        if(lotsOfShots3[turn] == true) return true;
        else {return false;}
    }
}
