package Lemmiwinks;

import java.util.Random;

import hockey.api.GoalKeeper;
import hockey.api.Position;
import hockey.api.Util;

public class Goalie extends GoalKeeper {
	Random random; //Random number generator
	int lastx, lasty;
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
    public void penaltyShot() {
    	facePuck();
    }

    // Intelligence of goalie.
    public void step() {
    	if(random == null){
    		random = new Random();
    	}
    	//skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), 200);
    	
    	turn(getPuck(), MAX_TURN_SPEED);
    	if(hasPuck()){
    		shoot(3000, random.nextInt(1000) - 500);
    	}else if(getPuck().getX() > -2620){
    		//Goalie should be inbetween the puck and the goal and act as our brick wall
    		facePuck();
    	}else{
    		//The puck is behind us.
    		//Get in front of the goal
        	skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), calcSpeed(new Position(getX(), getY()), new Position(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY()), 4));
    	}
    }
    public int getGoalX(){
    	return -2600;
    }
    public int getGoalY(){
    	return 0;
    }
    
    public int calcSpeed(Position current, Position wanted, int modifier){
    	return (int)(Util.dist(current, wanted) * modifier);
    }
    
    public void facePuck(){
    	//Glide in a clever way here
    	
    	Position dir = new Position(getPuck().getX() - getGoalX(), getPuck().getY() - getGoalY());
    	float dirx = getPuck().getX() - getGoalX(), diry = getPuck().getY() - getGoalY();
    	if(dirx == 0){
    		dirx = 1;
    	}
    	double alpha = Math.atan(diry / dirx);
    	double y = Math.sin(alpha) * 105 + getGoalY(), x = Math.cos(alpha) * 105 + getGoalX();
    	int speed = calcSpeed(new Position(getX(), getY()), new Position((int)x, (int)y), 4);
    	skate((int)(x), (int)(y), speed);
    }
    /*
    public boolean puckInGoal(){
    	if(getPuck())
    }*/
}
