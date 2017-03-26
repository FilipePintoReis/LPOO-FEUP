package dkeep.logic;
import dkeep.logic.Entity;

public class Key extends Entity {
	
	boolean pickedUp;
	boolean isSteppedOnByEnemy;
	
	/**
	 * Key constructor given its (x, y) position
	 * @param x
	 * @param y
	 */
	
	public Key(int x, int y){
		super(x, y);
		setSymbol('k');
		pickedUp = false;
		isSteppedOnByEnemy = false;
	}
	
	/**
	 * checks if the key is picked up, returns its state
	 * @return true if key is picked up, false otherwise
	 */
	
	public boolean isPickedUp(){ return pickedUp; }
	
	/**
	 * sets the key state to picked up
	 */
	
	public void pickUp(){ pickedUp = true; }
}
 