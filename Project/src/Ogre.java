package gamelogic;
import java.util.concurrent.ThreadLocalRandom;

import gamelogic.Entity;

class Ogre extends Entity {
	
	Entity mace;
	int macePosition;
	
	public Ogre(int x, int y) {
		super(x, y);
		this.mace = new Entity(x+1, y, '*');
		macePosition = 0;
		this.setSymbol('0');
	}
	
	public Entity getMace(){ return mace; }
}