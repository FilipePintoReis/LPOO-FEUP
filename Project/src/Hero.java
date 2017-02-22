package gamelogic;
class Hero extends Entity {
	boolean hasKey, captured;
	
	public Hero(int x, int y) {
		super(x, y);
		hasKey = false;
		captured = false;
		symbol = 'H';
	}
	public void captureHero(){ captured = true; }
	public boolean isCaptured(){ return captured; }
	public void giveKey(){ hasKey = true; }
	public boolean hasKey(){ return hasKey; }
}