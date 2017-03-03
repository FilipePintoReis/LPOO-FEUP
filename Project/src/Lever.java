package gamelogic;
import gamelogic.Entity;

class Lever extends Entity {
	boolean activated;
	boolean isSteppedOnByEnemy;
	
	public Lever(int x, int y, char s){
		super(x, y, s);
		activated = false;
		isSteppedOnByEnemy = false;
	}
	
	public boolean getState(){ return activated; }
	public void activate(){ activated = true; }
	public void unactivate(){ activated = false; }
	public void setSteppedOnByEnemy(){ isSteppedOnByEnemy = true; }
}	
