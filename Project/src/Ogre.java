package dkeep.logic;

import java.util.concurrent.ThreadLocalRandom;

import dkeep.logic.Entity;

public class Ogre extends Entity {

	Entity mace;
	int macePosition, stunCount;
	boolean isStunned;

	public Ogre(int x, int y) {
		super(x, y);
		this.mace = new Entity(x + 1, y, '*');
		macePosition = 0;
		this.setSymbol('0');
		this.isStunned = false;
		this.stunCount = 0;
	}

	public Entity getMace() {
		return mace;
	}

	public boolean isStunned() {
		this.checkStun();
		return isStunned;
	}

	public void stunOgre() {
		isStunned = true;
	}

	public void setStunCount() {
		stunCount = 2;
	}

	public void decStunCount() {
		stunCount--;
	}

	public void checkStun() {
		if (stunCount == 0) {
			isStunned = false;
			this.setSymbol('0');
		} else {
			isStunned = true;
			this.setSymbol('8');
		}
	}

	public boolean moveEntity(Level level) {
		if (this.isStunned()) {
			this.decStunCount();
			return false;
		} else {
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
			if (!(symbol == ' ' || symbol == 'k' || symbol == '0' || symbol == '*' || symbol == '8'))
				return false;

			if (x < 0 || x > level.getMap().getXMapLength() - 1)
				return false;
			if (y < 0 || y > level.getMap().getYMapLength() - 1)
				return false;
			// Verifica se esta em cima da chave
			if (symbol == 'k')
				this.setSymbol('$');
			else
				this.setSymbol('0');

			this.setX(x);
			this.setY(y);
			return true;
		}
	}
	
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
		int y =this.getY() + dy;

		char symbol = level.getMap().getMapElement(x, y);
		if (!(symbol == ' ' || symbol == 'k'))
			return false;

		if (x < 0 || x > level.getMap().getXMapLength() - 1)
			return false;
		if (y < 0 || y > level.getMap().getYMapLength() - 1)
			return false;

		if (Math.abs(x - this.getX()) + Math.abs(y - this.getY()) > 1)
			return false;
		// Verifica se esta em cima da chave
		if (symbol == 'k')
			this.getMace().setSymbol('$');
		else
			this.getMace().setSymbol('*');

		this.getMace().setX(x);
		this.getMace().setY(y);
		return true;
	}
}