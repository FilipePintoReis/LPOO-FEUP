package dkeep.logic;
class Hero extends Entity {
	boolean hasKey, captured, hasWeapon;
	
	public Hero(int x, int y) {
		super(x, y);
		hasKey = false;
		captured = false;
		symbol = 'H';
		hasWeapon = false;
	}
	public void captureHero(){ captured = true; }
	public boolean isCaptured(){ return captured; }
	public void giveKey(){ hasKey = true; }
	public boolean hasKey(){ return hasKey; }
	public boolean hasWeapon() { return hasWeapon; }
	public void giveWeapon() { 
		hasWeapon = true; 
		this.setSymbol('A');
	}
}