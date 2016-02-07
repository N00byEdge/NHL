package Lemmiwinks;

import java.awt.Color;
import java.util.Random;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Team implements ITeam {
	public static final Color RAND_COLOR = new Color(0,0,0,0) {
		@Override public int getRGB() {
			return new Random().nextInt() | 0xFF000000;
		}
	};
    // Team Short Name.  Max 4 characters.
    public String getShortName() { return "5"; }

    // Team Name
    public String getTeamName() { return "Lemmiwinks"; }

    // Team color; body color
    public Color getTeamColor() { return RAND_COLOR; }

    // Team color; helmet color.
    public Color getSecondaryTeamColor() { return RAND_COLOR; }

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
