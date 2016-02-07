package Lemmiwinks;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Team implements ITeam {
	static int n = 0;
	public static final Color RAND_COLOR = new Color(0,0,0,0) {
		@Override public int getRGB() {
			n++;
			return Color.HSBtoRGB((float)Math.random(), 1, 1) | 0xFF000000;
//			return new Random().nextInt() | 0xFF000000;
		}
	};
	public static final Color RAND_COLOR_2 = new Color(0,0,0,0) {
		public int getRGB() {
			return RAND_COLOR.getRGB() ^ 0xFFFFFF;
		}
	};
    // Team Short Name.  Max 4 characters.
    public String getShortName() { return "5"; }

    // Team Name
    public String getTeamName() { return "Lemmiwinks"; }

    // Team color; body color
    public Color getTeamColor() { return RAND_COLOR; }

    // Team color; helmet color.
    public Color getSecondaryTeamColor() { return RAND_COLOR_2; }

    // The team's LUCKY NUMBER!!
    public int getLuckyNumber() { throw new UnsupportedOperationException(); } //This isn't ever called, so...

    // Get the goal keeper of the team.
    public GoalKeeper getGoalKeeper() { return (GoalKeeper)players[0]; }

    public static Player[] players = {new Goalie(), new Defender(), new Defender(), new Forward(0), new Forward(1), new Center()};
    // Get the other five players of the team.
    public Player getPlayer(int index) {
    	return players[index];
    }
}
