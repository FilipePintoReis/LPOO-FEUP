package dkeep.logic;

public class Club extends Entity {
	boolean pickedUp;
	
	public Club(int x, int y){ 
		super(x, y);
		this.setSymbol('C');
		this.pickedUp = false;
	}
	
	public void pickUp(){ this.pickedUp = true; }
	public boolean isPickedUp(){ return this.pickedUp; }

	
	
} 
