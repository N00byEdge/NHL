package Lemmiwinks;

import hockey.api.*;

public class Forward extends BasePlayer {
    int idx;
    IPlayer other;

    public Forward(int i) {
    	idx = i;
	}
    @Override public void init() {
    	other = getPlayer(6-idx);
    }

	public int getNumber() { return Integer.MAX_VALUE; }
    public String getName() { return "Forward"; }
    @Override public boolean isLeftHanded() {
    	return idx == 0;
    }
    public void step() {
    	if(hasPuck() && getX() < 1000) {
    		setAimOnStick(false);
    		shoot(GOAL_POSITION, 4444);
    		setMessage("Shooting");
    	} else if(hasPuck()) {
    		setAimOnStick(true);
    		skateTo(new Position(getX(),-1500));
    		setMessage("Getting into position");
    	} else {
    		setAimOnStick(true);
    		skateTo(getPuck());
    		setMessage("Chasing puck");
    	}
    }
	private void skateTo(IObject goal) {
		int dist = (int)Util.dist(this, goal);
		int spd = 1000;
		if(dist < 200) spd = 300;
		if(dist < 500) spd = 800;
		if(dist > 2000) spd = MAX_SPEED;
		skate(goal, spd);
	}
}