package Lemmiwinks;

import java.util.Random;

public class Defender extends BasePlayer {
	Random random; //Random number generator
	// Number of defender
	public int getNumber() {
		if (random == null) random = new Random();
		return random.nextInt(70);
	}

	// Name of defender
	public String getName() { 
		if (getIndex() == 1) return "Left Defender";
		else return "Right Defender";
	}

	// Make left defender left handed, right defender right handed.
	public boolean isLeftHanded() { return getIndex() == 1; }

	// Initiate
	public void init() {
	setAimOnStick(false);
	}

	// Defender intelligence
	public void step() {
		if (random == null) random = new Random();

		if (getPuck().isHeld())
			skate(getPuck().getHolder(), MAX_SPEED);
		else
			if (getIndex() == 1) skate(-20000, -10000, 1000);
			else skate(-20000, 10000, 1000);
	}
}
