package Lemmiwinks;

import hockey.api.GoalKeeper;

public class Fleer extends GoalKeeper {
	
	@Override public String getName() {
		return "Run!!!";
	}
	
	@Override public int getNumber() {
		return 0;
	}
	
	@Override public void step() {
//		skate(0,0,9999);
		skate(getX() + (getX() - getPuck().getX()), getY() + (getY() - getPuck().getY()), 99999);
	}
	
	@Override public boolean isLeftHanded() {
		return false;
	}
}
