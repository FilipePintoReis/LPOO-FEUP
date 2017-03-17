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
	
	public boolean moveEntity(String userInput, Level level) {
		int dx = 0, dy = 0;

		switch (userInput) {
		case "w":
			dx--;
			break;
		case "a":
			dy--;
			break;
		case "s":
			dx++;
			break;
		case "d":
			dy++;
			break;
		default:
			break;
		}

		int x = this.getX() + dx;
		int y = this.getY() + dy;

		char symbol = level.getMap().getMapElement(x, y);

		if (this.hasKey() && symbol == 'I') {
			level.getMap().openDoors();
			return false;
		}

		if (symbol != ' ' && symbol != 'k' && symbol != 'S' && symbol!= 'C')
			return false;

		this.setX(x);
		this.setY(y);
		return true;
	}
}