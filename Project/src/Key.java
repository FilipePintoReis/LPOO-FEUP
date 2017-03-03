package gamelogic;
import gamelogic.Entity;

class Key extends Entity {
	
	boolean pickedUp;
	boolean isSteppedOnByEnemy;
	
	public Key(int x, int y){
		super(x, y);
		pickedUp = false;
		isSteppedOnByEnemy = false;
	}
	public boolean isPickedUp(){ return pickedUp; }
	public void pickUp(){ pickedUp = false; }
	public void drop(){ pickedUp = true; }
	public void setSteppedOnByEnemy(){ isSteppedOnByEnemy = true; }

}
