package dkeep.logic;
import dkeep.logic.Entity;

public class Lever extends Entity {
	boolean activated;
	boolean isSteppedOnByEnemy;
	
	public Lever(int x, int y){
		super(x, y);
		setSymbol('k');
		activated = false;
		isSteppedOnByEnemy = false;
	}
	
	public boolean getState(){ return activated; }
	public void activate(){ activated = true; }
	public void unactivate(){ activated = false; }
	public void setSteppedOnByEnemy(){ isSteppedOnByEnemy = true; }
}	
 