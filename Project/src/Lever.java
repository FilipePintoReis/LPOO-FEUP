package dkeep.logic;
import dkeep.logic.Entity;

public class Lever extends Entity {
	boolean activated;
	
	public Lever(int x, int y){
		super(x, y);
		setSymbol('k');
		activated = false;
	}
	
	public boolean getState(){ return activated; }
	public void activate(){ activated = true; }
}	
 