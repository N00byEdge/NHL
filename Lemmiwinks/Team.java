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
    public String getShortName() { return "___"; }

    // Team Name
    public String getTeamName() { return "Lemmiwinks"; }

    // Team color; body color
    public Color getTeamColor() { return RAND_COLOR; }

    // Team color; helmet color.
    public Color getSecondaryTeamColor() { return RAND_COLOR; }

    // The team's LUCKY NUMBER!!
    public int getLuckyNumber() { throw new UnsupportedOperationException(); } //This isn't ever called, so...

    // Get the goal keeper of the team.
    public GoalKeeper getGoalKeeper() { return new Goalie(); }

    // Get the other five players of the team.
    public Player getPlayer(int index) {
	switch (index) {
	case 1: return new Defender(); // Left defender
	case 2: return new Defender(); // Right defender
	case 3: return new Forward(); // Left forward
	case 4: return new Forward(); // Right forward
	case 5: return new Center(); // Center
	}
	return null;
    }
}
