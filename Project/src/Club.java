package dkeep.logic;

public class Club extends Entity {
	boolean pickedUp;
	
	/**
	 *Constructor 
	 * 
	 * @param x
	 * @param y
	 */
	public Club(int x, int y){ 
		super(x, y);
		this.setSymbol('C');
		this.pickedUp = false;
	}
	/**
	 * sets boolean pickedUp true
	 */
	public void pickUp(){ this.pickedUp = true; }
	
	/**
	 * returns boolean pickedUp
	 * 
	 * @return pickedUp
	 */
	public boolean isPickedUp(){ return this.pickedUp; }

	
	
} 
