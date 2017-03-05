package dkeep.logic;

import dkeep.logic.Entity;

class Ogre extends Entity {

	Entity mace;
	int macePosition, stunCount;
	boolean isStunned;

	public Ogre(int x, int y) {
		super(x, y);
		this.mace = new Entity(x + 1, y, '*');
		macePosition = 0;
		this.setSymbol('0');
		this.isStunned = false;
		this.stunCount = 0;
	}

	public Entity getMace() {
		return mace;
	}

	public boolean isStunned() {
		this.checkStun();
		return isStunned;
	}

	public void stunOgre() {
		isStunned = true;
	}

	public void setStunCount() {
		stunCount = 2;
	}

	public void decStunCount() {
		stunCount--;
	}

	public void checkStun() {
		if (stunCount == 0) {
			isStunned = false;
			this.setSymbol('0');
		} else if (stunCount > 0) {
			isStunned = true;
			this.setSymbol('8');
		} else
			System.out.println("Error: Ogre stun count is negative");
	}
}