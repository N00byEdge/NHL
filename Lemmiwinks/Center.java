package Lemmiwinks;

import hockey.api.Util;
import java.awt.Color;

public class Center extends BasePlayer {
	
	int firedtick;
	boolean fired;
	
	public Center ( ) {
		
		firedtick = 0;
		fired = false;
		
	}
	
    // Number of center player
    public int getNumber() {
		return 55;
		
	}

    // Name of center player
    public String getName() { return "Femmor"; }

    // Center player's intelligence
    public void step() {
		if ( firedtick == 0 ) fired = false;
		-- firedtick;
		int debX, debY;
		if ( fired ) {
			
			skate ( GOAL_POSITION, 20 );
			debX = GOAL_POSITION.getX();
			debY = GOAL_POSITION.getY();
			
		} else if (hasPuck()&&
		(Util.dist(GOAL_POSITION, this) < 800 )) {
			debX = GOAL_POSITION.getX();
			debY = GOAL_POSITION.getY();
			setAimOnStick(true);
			shoot(GOAL_POSITION, MAX_SHOT_SPEED);
			fired = true;
			firedtick = 20;
		}
		else if (hasPuck()){
			debX = GOAL_POSITION.getX();
			debY = GOAL_POSITION.getY();
			setAimOnStick(false);
			skate(GOAL_POSITION, MAX_SPEED);
		}
		else {
			debX = getPuck().getX();
			debY = getPuck().getY();
			setAimOnStick(true);
			skate(getPuck(), MAX_SPEED);
		}
		
		setMessage ( "has no idea what it's doing." );
		
		//if (abs(getTargetHeading-))
		
		setDebugPoint ( debX, debY, Color.BLUE );
		showDebugPoint(true);
    }
}
