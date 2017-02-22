package gamelogic;
import gamelogic.Entity;

class Ogre extends Entity {
	
	Entity mace;
	int macePosition;
	
	public Ogre(int x, int y) {
		super(x, y);
		this.mace = new Entity(0, 0, '*');
		macePosition = 0;
		this.setSymbol('0');
	}
}