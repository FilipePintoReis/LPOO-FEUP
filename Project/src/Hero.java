package dkeep.logic;
public class Hero extends Entity {
	boolean hasKey, captured, hasWeapon;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public Hero(int x, int y) {
		super(x, y);
		hasKey = false;
		captured = false;
		symbol = 'H';
		hasWeapon = false;
	}
	/**
	 * sets captured boolean true
	 */
	public void captureHero(){ captured = true; }
	/**
	 * returns boolean captured
	 * @return boolean
	 */
	public boolean isCaptured(){ return captured; }
	/**
	 * sets boolean hasKey true and if the hero.hasWeapon is false also sets symbol to k
	 */
	public void giveKey(){ 
		hasKey = true;
		if(!this.hasWeapon)
			this.setSymbol('K');
		} 
	/**
	 * returns boolean hasKey
	 * @return boolean
	 */
	public boolean hasKey(){ return hasKey; }
	/**
	 * returns boolean hasWeapon
	 * @return boolean
	 */
	public boolean hasWeapon() { return hasWeapon; }
	/**
	 * sets hasWeapon true
	 */
	public void giveWeapon() { 
		hasWeapon = true; 
		this.setSymbol('A'); 
	}
	
	/**
	 * moving function for hero. creates a delta dx and dy so as to check if hero can move to certain position on the map
	 * @param userInput
	 * @param level
	 * @return boolean
	 */
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