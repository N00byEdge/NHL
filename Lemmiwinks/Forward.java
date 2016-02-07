package Lemmiwinks;

import hockey.api.*;

public class Forward extends BasePlayer {
    int idx;

    public Forward(int i) {
    	idx = i;
	}

	public int getNumber() { return 0; }
    public String getName() { return "Forward"; }
    @Override public boolean isLeftHanded() { return idx == 0; }
    public void step() {
    	setAimOnStick(true);
    	if(hasPuck() && Util.dist(this, getPlayer(5)) < 1000) {
    		setMessage("Passing");
    		shoot(getPlayer(5), 700);
    	} else if(hasPuck()) {
    		setMessage("Getting into position");
    		skateTo(getPlayer(5));
    	} else {
    		setMessage("Chasing puck");
    		skateTo(getPuck());
    	}
    }
	private void skateTo(IObject goal) {
		int totDist = 0;
		for(int i = 0; i < 12; i++) {
			double dst = Util.dist(this, getPlayer(i));
			if(dst != 0) totDist += (int)(1000/dst);
		}
		totDist *= totDist;
		totDist /= 100;
		setMessage(""+totDist);
		int dist = (int)Util.dist(this, goal);
		int spd = 1000;
		if(dist < 200) spd = 300;
		if(dist < 500) spd = 800;
		if(dist > 2000) spd = MAX_SPEED;
		skate(goal, spd);
	}
}
