package dkeep.logic;

import java.util.concurrent.ThreadLocalRandom;

import dkeep.logic.Entity;

public class Ogre extends Entity {

	Entity mace;
	int macePosition, stunCount;
	boolean isStunned;

	/**
	 * constructor for the ogre
	 * 
	 * @param x x position of the ogre
	 * @param y y position of the ogre
	 */
	
	public Ogre(int x, int y) {
		super(x, y);
		this.mace = new Entity(x, y + 1, '*');
		macePosition = 0;
		this.setSymbol('0');
		this.isStunned = false;
		this.stunCount = 0;
	}

	/**
	 * returns the mace of the ogre
	 * 
	 * @return the mace of the ogre
	 */
	
	public Entity getMace() {
		return mace;
	}
	
	/**
	 * updates the symbol of the ogre according to its current position on the map
	 * if the ogre is on top of a key, its symbol is $
	 * 
	 * @param symbol
	 */
	
	public void updateOgreSymbol(char symbol){
		if (symbol == 'k')
			this.setSymbol('$');
		else
			this.setSymbol('0');
	}
	
	/**
	 * updates the symbol of the mace of the ogre according to its current position on the map
	 * if the mace is on top of a key, its symbol is $
	 * 
	 * @param symbol symbol of the maces current position in the map
	 */
	
	public void updateMaceSymbol(char symbol){
		if (symbol == 'k')
			this.getMace().setSymbol('$');
		else
			this.getMace().setSymbol('*');
	}

	/**
	 * checks if the ogre is stunned
	 * 
	 * @return boolean true if the ogre is stunned, false otherwise
	 */
	
	public boolean isStunned() {
		this.checkStun();
		return isStunned;
	}

	/**
	 * sets the ogres state to stunned
	 */
	
	public void stunOgre() {
		isStunned = true;
	}

	/**
	 * resets the stun counter of the ogre
	 */
	
	public void setStunCount() {
		stunCount = 2;
	}

	/**
	 * decreases the stun counter of the ogre
	 */
	
	public void decStunCount() {
		stunCount--;
	}

	/**
	 * checks if the ogre is stunned and updates his symbol accordingly
	 */
	
	public void checkStun() {
		if (stunCount == 0) {
			isStunned = false;
			this.setSymbol('0');
		} else {
			isStunned = true;
			this.setSymbol('8');
		}
	}

	/**
	 * overload of the moveEntity function from the Entity class; Moves the ogre in a random direction
	 * (up, down, left, right)	
	 * 
	 * @param level level of the entity that is going to move
	 * @return boolean true on success, false otherwise
	 */
	
	public boolean moveEntity(Level level) {
		if (this.isStunned()) {
			this.decStunCount();
			return false; } 
		else {
			int dx = 0, dy = 0;
			
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 4);
			
			switch (randomNumber) {
			case 0:
				dx--;
				break;
			case 1:
				dy--;
				break;
			case 2:
				dx++;
				break;
			case 3:
				dy++;
				break;
			}

			int x = this.getX() + dx;
			int y = this.getY() + dy;

			char symbol = level.getMap().getMapElement(x, y);
			if (!(symbol == ' ' || symbol == 'k' || symbol == '0' || symbol == '*' || symbol == '8') || x < 0 
					|| x > level.getMap().getXMapLength() - 1 || y < 0 || y > level.getMap().getYMapLength() - 1)
				return false;
			// Verifica se esta em cima da chave
			this.updateOgreSymbol(symbol);
			this.setX(x);
			this.setY(y);
			return true;
		}
	}
	
	/**
	 * Swings the mace of the ogre in a random direction (up, down, left, right)
	 * 
	 * @param ogreIndex index of the ogre whose mace is to be swung, from the ogre vector
	 * @param level level of said ogre
	 * @return boolean - true on success, false otherwise
	 */
	
	public boolean swingMace(int ogreIndex, Level level) {
		int dx = 0, dy = 0;
		
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 4);

		switch (randomNumber) {
		case 0:
			dx--;
			break;
		case 1:
			dy--;
			break;
		case 2:
			dx++;
			break;
		case 3:
			dy++;
			break;
		}

		int x = this.getX() + dx;
		int y = this.getY() + dy;

		char symbol = level.getMap().getMapElement(x, y);
		if (!(symbol == ' ' || symbol == 'k') || x < 0 || x > level.getMap().getXMapLength() - 1 || y < 0 
				|| y > level.getMap().getYMapLength() - 1 || Math.abs(x - this.getX()) + Math.abs(y - this.getY()) > 1)
			return false;
		
		// Verifica se esta em cima da chave
		this.updateMaceSymbol(symbol);

		this.getMace().setX(x);
		this.getMace().setY(y);
		return true;
	}
}