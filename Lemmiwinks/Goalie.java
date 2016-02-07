package teamTemplate;

import java.util.Random;

import hockey.api.GoalKeeper;
import hockey.api.Position;

public class Goalie extends GoalKeeper {
	Random random; //Random number generator
    // Middle of our own goalcage, on the goal line
    protected static final Position GOAL_POSITION = new Position(-2600, 0);

    // Number of the goalie.
    public int getNumber() { return 5; }

    // Name of the goalie.
    public String getName() { return "The Goalie"; }

    // Left handed goalie
    public boolean isLeftHanded() { return true; }

    // Initiate
    public void init() { }

    // Face off
    public void faceOff() { }

    // Called when the goalie is about to receive a penalty shot
    public void penaltyShot() { }

    // Intelligence of goalie.
    public void step() {
    	if(random == null){
    		random = new Random();
    	}
    	skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	
    	turn(getPuck(), MAX_TURN_SPEED);
    	if(hasPuck()){
    		shoot(3000, random.nextInt(1000) - 500);
    		/*
    		IPlayer best = null;
    		for(int i = 0; i < 12; ++i){
    			IPlayer cur = getPlayer(i);
    			if(!cur.isOpponent()){
    				
    			}
    		}*/
    	}
    }
}
