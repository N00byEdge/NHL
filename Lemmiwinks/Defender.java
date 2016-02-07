package Lemmiwinks;

import java.util.Random;
import hockey.api.Util;

public class Defender extends BasePlayer {
	Random random; // Random number generator

	// Index 1 Left Defender
	// Index 2 Right Defender

	// Number of defender
	public int getNumber() {
		// Fixa random numbers
		if (random == null) random = new Random();
		// Returnera slumptal
		return random.nextInt(70);
	}

	// Name of defender
	public String getName() { 
		// De får sina positioner som namn
		if (getIndex() == 1) return "Left Defender";
		else return "Right Defender";
	}

	// Make left defender left handed, right defender right handed.
	public boolean isLeftHanded() { return getIndex() == 1; }

	// Initiate
	public void init() {
		// The aimOnStick property controls whether the endpoint of the stick or the body position should used when moving to a target position. 
		// Antar att false är body position
		setAimOnStick(false);
	}

	// Defender intelligence
	public void step() {
		// Fixa random numbers
		if (random == null) random = new Random();

		// Koordinaterna för vårt mål
		int goalX = -2600;
		int goalY = 0;
		int puckX = getPuck().getX();
		int puckY = getPuck().getY();

		// Om spelaren har pucken
		if (hasPuck()){
			// Beräkna avståndet till närmaste fiende
			double enemyDistance = 10000;
			for (int i = 6; i < 12; ++i) {
				// Go through all enemy players
				double dist = Math.pow(Math.pow(getPlayer(i).getX()-getX(), 2)+Math.pow(getPlayer(i).getY()-getY(), 2), 0.5);
				if (dist < enemyDistance) enemyDistance = dist;
			}
			// Hitta till närmaste forward/center
			double bestDistance = 10000;
			int bestPlayer = 5;
			for (int i = 3; i < 6; ++i) {
				// Go through all offensive friendly players
				double dist = Math.pow(Math.pow(getPlayer(i).getX()-getX(), 2)+Math.pow(getPlayer(i).getY()-getY(), 2), 0.5);
				if (dist < enemyDistance) {
					bestDistance = dist;
					bestPlayer = i;
				}
			}
			shoot(getPlayer(bestPlayer), 800);



			// 	// Om vi är närmast, gå på med den närmaste och retirera med den andra
			// 	// Hitta den närmaste spelaren i vårt lag
			// 	int bestPlayer = getIndex();
			// 	double bestDistance = 10000;
			// 	for (int i = 0; i < 6; ++i) {
			// 		// Go through all players
			// 		double dist = Math.pow(Math.pow(getPlayer(i).getX()-puckX, 2)+Math.pow(getPlayer(i).getY()-puckY, 2), 0.5);
			// 		if (dist < bestDistance) {
			// 			bestDistance = dist;
			// 			bestPlayer = i;
			// 		}
			// 	}
			// 	// Om vi är närmast
			// 	if (bestPlayer == getIndex()) skate(getPuck(), MAX_SPEED);
			// // Vem ska vi passa till
			// IPlayer best = null;
			// for(int i = 0; i < 12; ++i){
			// 	IPlayer cur = getPlayer(i);
			// 	if(!cur.isOpponent()){
					
			// 	}
			// }
		}


		// Om pucken finns på vår sida






		if (getPuck().isHeld() & puckX < 0)
			skate(getPuck().getHolder(), MAX_SPEED);

		// else if (puckY < getY())

		// dist(this, getPuck())
		// Om 0 < puckens x-koord < 1000
		else if (puckX < 1000) {
			// Om vår x-koord > 1000, spring tillbaks
			if (getX() > 1000) {
				// Om den är på vår sida
				if (puckY * getY() >= 0) skate (0, puckY, MAX_SPEED);
				// Om den är på andra sidan, retirera längre
				else skate (-500, 0, MAX_SPEED);
			}
			// Om någon har den
			else if (getPuck().isHeld()) {
				// Om vi är närmast, gå på med den närmaste och retirera med den andra
				// Hitta den närmaste spelaren i vårt lag
				int bestPlayer = getIndex();
				double bestDistance = 10000;
				for (int i = 0; i < 6; ++i) {
					// Go through all players
					double dist = Math.pow(Math.pow(getPlayer(i).getX()-puckX, 2)+Math.pow(getPlayer(i).getY()-puckY, 2), 0.5);
					if (dist < bestDistance) {
						bestDistance = dist;
						bestPlayer = i;
					}
				}
				// Om vi är närmast
				if (bestPlayer == getIndex()) skate(getPuck(), MAX_SPEED);
				// Annars om den är på vår sida, retirera
				else if (puckY * getY() >= 0) skate (-500, puckY, 1000);
				// Om den är på andra sidan, retirera längre
				else skate (-1000, 0, 1000);
			}
			// Om ingen har den, ta den!
			else skate(getPuck(), MAX_SPEED);

		}


		// Om 1000 < puckens x-koord < 2000
		else if (puckX < 2000) {
			// Om vår x-koord > 2000, spring tillbaks
			if (getX() > 2000) {
				// Om den är på vår sida
				if (puckY * getY() >= 0) skate (1000, puckY, MAX_SPEED);
				// Om den är på andra sidan, retirera längre
				else skate (1000, 0, MAX_SPEED);
			}
			// Om någon har den
			else if (getPuck().isHeld()) {
				// Om vi är närmast, gå på med den närmaste och retirera med den andra
				// Hitta den närmaste spelaren i vårt lag
				int bestPlayer = getIndex();
				double bestDistance = 10000;
				for (int i = 0; i < 6; ++i) {
					// Go through all players
					double dist = Math.pow(Math.pow(getPlayer(i).getX()-puckX, 2)+Math.pow(getPlayer(i).getY()-puckY, 2), 0.5);
					if (dist < bestDistance) {
						bestDistance = dist;
						bestPlayer = i;
					}
				}
				// Om vi är närmast
				if (bestPlayer == getIndex()) skate(getPuck(), MAX_SPEED);
				// Annars om den är på vår sida, retirera
				else if (puckY * getY() >= 0) skate (0, puckY, 1000);
				// Om den är på andra sidan, retirera längre
				else skate (-500, 0, 1000);
			}
			// Om ingen har den, ta den!
			else skate(getPuck(), MAX_SPEED);

		}
		


		// Om puckens x-koord är > 2000
		// Åk till 500, följ pucken på ett ungefär
		// Stirra sedan mot pucken
		// Den försvarare som är på motsatta sidan från pucken hänger lite längre bak

		else {
			if (getX() > 500) {
				if (puckY * getY() >= 0) skate (400, puckY, 1000);
				else skate (400, 0, 1000);
			}
			else turn(getPuck(), 500);
			// if (puckY < 0) {
			// 	if (puckY * getY() >= 0) 
			// 	if (getIndex() == 1) {
			// 		if (getX() < 450) skate (500, puckY, 500);
			// 		else turn(getPuck(), 500);
			// 	}
			// 	else {
			// 		if (getX() < 450 - 500) skate (500 - 500, 0, 500);
			// 		else turn(getPuck(), 500);
			// 	}
			// }
			// else {
			// 	if (getIndex() == 1) {
			// 		if (getX() < 450 - 500) skate (500 - 500, 0, 500);
			// 		else turn(getPuck(), 500);
			// 	}
			// 	else {
			// 		if (getX() < 450) skate (500, puckY, 500);
			// 		else turn(getPuck(), 500);
			// 	}
			// }
		}
	}
}
