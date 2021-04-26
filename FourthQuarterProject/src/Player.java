// Name: Manav Gagvani
// Period: 2nd
// Date: April 26th, 2021

public class Player {
    private String name;
    private double RestrictArea_FGpercent,Paint_FGpercent,MidRange_FGpercent,LeftCorner3_FGpercent,RightCorner3_FGpercent,AboveBreak3_FGpercent;
    private int RestrictArea_FGA,Paint_FGA,MidRange_FGA,LeftCorner3_FGA,RightCorner3_FGA,Totals_FGA,AboveBreak3_FGA;
    private int RestrictArea_FGM,Paint_FGM,MidRange_FGM,LeftCorner3_FGM,RightCorner3_FGM,AboveBreak3_FGM,Totals_FGM;
    private int pointsScored;
    private int twoPTM, twoPTA, threePTM, threePTA;

    public Player(String name, double RestrictArea_FGpercent, double Paint_FGpercent, double MidRange_FGpercent, double LeftCorner3_FGpercent, double RightCorner3_FGpercent, double AboveBreak3_FGpercent, int RestrictArea_FGA, int Paint_FGA, int MidRange_FGA, int LeftCorner3_FGA, int RightCorner3_FGA, int Totals_FGA, int AboveBreak3_FGA, int RestrictArea_FGM, int Paint_FGM,MidRange_FGM, int LeftCorner3_FGM, int RightCorner3_FGM, int AboveBreak3_FGM, int Totals_FGM) {

    }

    public void reset_score() {
        pointsScored = 0;
    }

    public int get_score() {
        return pointsScored;
    }

    public int[] get_splits() {
        return new int[]{twoPTM, twoPTA, threePTM, threePTA};
    }

    public void reset_splits() {
        
    }

    public boolean shoot2pt(int turn) {

    }

    public boolean shoot3pt(int turn) {
        
    }
}
