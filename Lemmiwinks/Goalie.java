package Lemmiwinks;

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
    	}
    	if(getPuck().getX() > -2600){
    		//Goalie should be inbetween the puck and the goal and act as our brick wall
    		facePuck();
    	}else{
    		//The puck is behind us.
    		//Get in front of the goal
        	skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	}
    }
    public void facePuck(){
    	//turn(getPuck(), MAX_TURN_SPEED);
    	//Glide in a clever way here
    	
    	//skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	int yPos = GOAL_POSITION.getY();
    	if(getPuck().getY() < 0){
    		yPos = Math.max(getPuck().getY(), GOAL_POSITION.getY() - 100);
    	}else{
    		yPos = Math.min(getPuck().getY(), GOAL_POSITION.getY() + 100);
    	}
    	skate(GOAL_POSITION.getX() + 50, yPos, 200);
    	//glide(getY() - getPuck().getY());
/*		int xdir = getPuck().getX() - GOAL_POSITION.getX(), ydir = getPuck().getY() - GOAL_POSITION.getY(), size = Math.max((int)Math.sqrt((double)xdir*xdir + ydir * ydir), 1);
		int normalizedx = xdir / size, normalizedy = ydir / size;
		skate(GOAL_POSITION.getX() + normalizedx * 50, GOAL_POSITION.getY() + normalizedy * 50, 200);
  */  	//System.out.print(normalizedx);
		/*xdir = getX() - GOAL_POSITION.getX() + normalizedx * 50;
		ydir = getY() - GOAL_POSITION.getY() + normalizedy * 50;
		size = Math.max((int)Math.sqrt((double)xdir*xdir + ydir * ydir), 1);
		normalizedx = xdir / size;
		normalizedy = ydir / size;
		skate(normalizedx, normalizedy, MAX_SPEED);*/

    }
}
