package dkeep.logic;
import dkeep.logic.Entity;

public class Key extends Entity {
	
	boolean pickedUp;
	boolean isSteppedOnByEnemy;
	
	public Key(int x, int y){
		super(x, y);
		setSymbol('k');
		pickedUp = false;
		isSteppedOnByEnemy = false;
	}
	public boolean isPickedUp(){ return pickedUp; }
	//public boolean isSteppedOnByEnemy(){ return isSteppedOnByEnemy; }
	public void pickUp(){ pickedUp = true; }
	//public void setSteppedOnByEnemy(){ isSteppedOnByEnemy = true; }
}
 