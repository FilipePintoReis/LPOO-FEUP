package gamelogic;
import gamelogic.Entity;

class Guard extends Entity {
	/**
	 * 
	 */
	private final Game Guard;
	char pattern[] = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
			'd', 'w', 'w', 'w', 'w', 'w' };
	int currentPosition;

	public Guard(Game game, int x, int y) {
		super(x, y);
		Guard = game;
		this.setSymbol('G');
		this.currentPosition = 0;
	}

	public char[] getPattern() {
		return this.pattern;
	}

	public int getCurrentPosition() {
		return this.currentPosition;
	}

	public void incCurrentPosition() {
		this.currentPosition++;
		if (currentPosition > pattern.length - 1)
			this.currentPosition = 0;
	}
}