package dkeep.logic;
import dkeep.logic.Entity;

public class Lever extends Entity {
	boolean activated;
	
	/**
	 * Lever constructor given its (x, y) position
	 * @param x
	 * @param y
	 */
	
	public Lever(int x, int y){
		super(x, y);
		setSymbol('k');
		activated = false;
	}
	
	/**
	 * returns the lever state
	 * @return true if lever is activated, false otherwise
	 */
	
	public boolean getState(){ return activated; }
	
	/**
	 * activates lever, sets its state to activated
	 */
	
	public void activate(){ activated = true; }
}	
 