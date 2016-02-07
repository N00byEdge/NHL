package Lemmiwinks;

import hockey.api.*;

public class Forward extends BasePlayer {
    int idx;
    IPlayer other;
	private int tick;

    public Forward(int i) {
    	idx = i;
	}
    @Override public void init() {
    	other = getPlayer(6-idx);
    }

	public int getNumber() { return 5; }
    public String getName() { return "Forward"; }
    @Override public boolean isLeftHanded() {
    	return idx == 0;
    }
    public void step() {
    	if(hasPuck() && Util.dist2(this, new Position(2000,-500)) < 1000) {
    		shoot(new Position(2600,0), 4444);
    	} else if(hasPuck() || other.hasPuck()) {
    		setAimOnStick(true);
    		skate(new Position(2000, -500), MAX_SPEED);
    	} else {
    		setAimOnStick(true);
    		int dist = (int)Util.dist(this, getPuck());
    		int spd = 1000;
    		if(dist < 200) spd = 300;
    		if(dist < 500) spd = 800;
    		if(dist > 2000) spd = MAX_SPEED;
    		skate(getPuck(), spd);
    	}
    	
    }
}