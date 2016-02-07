package Lemmiwinks;

import java.util.Random;

import hockey.api.GoalKeeper;
import hockey.api.Position;
import hockey.api.Util;

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
    public void faceOff() {
    	facePuck();
    }

    // Called when the goalie is about to receive a penalty shot
    public void penaltyShot() { }

    // Intelligence of goalie.
    public void step() {
    	if(random == null){
    		random = new Random();
    	}
    	//skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	
    	//turn(getPuck(), MAX_TURN_SPEED);
    	if(hasPuck()){
    		shoot(3000, random.nextInt(1000) - 500);
    	}else if(getPuck().getX() > -2650){
    		//Goalie should be inbetween the puck and the goal and act as our brick wall
    		facePuck();
    	}else{
    		//The puck is behind us.
    		//Get in front of the goal
        	skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	}
    }
    public int getGoalX(){
    	return -2600;
    }
    public int getGoalY(){
    	return 0;
    }
    
    
    public void facePuck(){
    	//turn(getPuck(), MAX_TURN_SPEED);
    	//Glide in a clever way here
    	
    	//skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	//skate(-2550, 0, 200);
    	//turn(getPuck(), MAX_TURN_SPEED);
    	//glide((getY() - getPuck().getY()));
    	Position dir = new Position(getPuck().getX() - getGoalX(), getPuck().getY() - getGoalY());
    	float dirx = getPuck().getX() - getGoalX(), diry = getPuck().getY() - getGoalY();
    	if(dirx == 0){
    		dirx = 1;
    	}
    	double alpha = Math.atan(diry / dirx);
    	double y = Math.sin(alpha) * 100 + getGoalY(), x = Math.cos(alpha) * 100 + getGoalX();
    	//int speed = Util.solve(-2, 2, 0, false);
    	//int speed = (int)(2 * Math.pow(Util.dist(new Position((int)x, (int)y), this), 2));
    	int speed = (int)Util.dist(new Position((int)x, (int)y), this) * 3;
    	skate((int)(x), (int)(y), speed);
    	/*setDebugPoint((int)(x), (int)(y), java.awt.Color.GREEN);
    	showDebugPoint(true);
    	setMessage(Integer.toString(speed));*/
    	/*
    	int xdir = getPuck().getX() - getGoalX(), ydir = getPuck().getY() - getGoalY(), size = Math.max((int)Math.sqrt(xdir * xdir + ydir * ydir), 1);
    	int normx = xdir / size, normy = ydir / size;
    	int wantedx = getGoalX() + 180 * Math.abs(normx), wantedy = getGoalY() + 180 * normy;
    	int speed = Util.dist2(this, new Position(wantedx, wantedy)) / 4;
    	speed = 200;
    	skate(wantedx, wantedy, speed);
*/
    }
}
