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
    public String name;
    public double RestrictArea_FGpercent,Paint_FGpercent,MidRange_FGpercent,LeftCorner3_FGpercent,RightCorner3_FGpercent,AboveBreak3_FGpercent;
    public double RestrictArea_FGA,Paint_FGA,MidRange_FGA,LeftCorner3_FGA,RightCorner3_FGA,Totals_FGA,AboveBreak3_FGA;
    public double RestrictArea_FGM,Paint_FGM,MidRange_FGM,LeftCorner3_FGM,RightCorner3_FGM,AboveBreak3_FGM,Totals_FGM;
    public int pointsScored;
    public int twoPTM, twoPTA, threePTM, threePTA;
    public boolean[] lotsOfShots2;
    public boolean[] lotsOfShots3;
    public int fga;

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
    public Player(String name, double RestrictArea_FGM, double RestrictArea_FGA, double RestrictArea_FGpercent, double Paint_FGM, double Paint_FGA, double Paint_FGpercent, double MidRange_FGM, double MidRange_FGA, double MidRange_FGpercent, double LeftCorner3_FGM, double LeftCorner3_FGA, double LeftCorner3_FGpercent, double RightCorner3_FGM, double RightCorner3_FGA, double RightCorner3_FGpercent, double Totals_FGM,  double Totals_FGA, double AboveBreak3_FGM, double AboveBreak3_FGA, double AboveBreak3_FGpercent) {
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

        this.twoPTA = (int)(this.RestrictArea_FGA + this.Paint_FGA + this.MidRange_FGA);
        this.threePTA = (int)(this.LeftCorner3_FGA + this. RightCorner3_FGA + this.AboveBreak3_FGA);

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

        fga = (int)(this.RestrictArea_FGA + this.Paint_FGA + this.MidRange_FGA + this.LeftCorner3_FGA + this.RightCorner3_FGA + this.AboveBreak3_FGA);

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
    public Player()
    {
      
    }
    /**
     * @param points Adds the specified amount of points to the player's pointsScored variable
     */
    public void add_score(int points) {
        pointsScored += points;
    }

    /**
     * Add a shot attempt to a player, in the 2-point or 3 point zone
     * 
     * @param position 2 or 3
     */
    public void add_attempt(int position) {
        if(position == 2) {
            twoPTA += 1;
        }
        else if(position == 3) {
            threePTA += 1;
        }
    }

    /**
     * Add a shot make to a player, in the 2-point or 3 point zone
     * 
     * @param position 2 or 3
     */
    public void add_make(int position) {
        if(position == 2) {
            twoPTM += 1;
        }
        else if(position == 3) {
            threePTM += 1;
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
     * @return The name of the player
     */
    public String get_name() {
        return name;
    }

    /**
     * @return The amount of shot attempts the player averages
     */
    public int get_fga() {
        return fga;
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
