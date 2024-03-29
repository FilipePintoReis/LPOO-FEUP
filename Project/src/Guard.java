package dkeep.logic;

import dkeep.logic.Entity;

public class Guard extends Entity {
	
	char pattern[];
	char inverted_pattern[];
	int currentPosition;
	Behavior behavior;
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param pattern
	 * @param behavior
	 */
	public Guard(int x, int y, char[] pattern, String behavior) {
		super(x, y);
		this.behavior = new Behavior(behavior);
		this.setSymbol('G');
		this.currentPosition = 0;
		this.pattern = new char[pattern.length];
		this.inverted_pattern = new char[pattern.length];
		for(int i=0; i < this.pattern.length; i++){
			this.pattern[i] = pattern[i];
			switch(this.pattern[i]){
			case 'w': 
				inverted_pattern[i+1>pattern.length-1?0:i+1] = 's';
				break;
			case 's':
				inverted_pattern[i+1>pattern.length-1?0:i+1] = 'w';
				break;
			case 'a':
				inverted_pattern[i+1>pattern.length-1?0:i+1] = 'd';
				break;
			case 'd':
				inverted_pattern[i+1>pattern.length-1?0:i+1] = 'a';
				break;
			}
		}
	}
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public Guard(int x, int y) {
		super(x, y);
		this.behavior = new Behavior("rookie");
		this.setSymbol('G');
		this.currentPosition = 0;
		pattern = new char[24];
		inverted_pattern = new char[24];
	}
	/**
	 * increments currentPosition variable
	 */
	public void incCurrentPosition() {
		this.currentPosition++;
		if (currentPosition > pattern.length - 1)
			this.currentPosition = 0;
	}
	/**
	 * decrements currentPosition variable
	 */
	public void decCurrentPosition() {
		this.currentPosition--;
		if (currentPosition < 0)
			this.currentPosition = pattern.length - 1;
	}
	
	
	/**
	 * returns pattern
	 * @return char[]
	 */
	public char[] getPattern() { return this.pattern; }
	/**
	 * returns inverted_pattern
	 * @return char[]
	 */
	public char[] getInvertedPattern(){ return this.inverted_pattern; }
	/**
	 * retuns behavior
	 * @return Behavior
	 */
	public Behavior getBehavior(){ return this.behavior; }
	
	/**
	 * move function for the guard, creates a delta dx and dy so as to check if guard can move to certain position on the map
	 * @param level
	 * @return boolean
	 */
	public boolean moveEntity(Level level) {
		if(this.getBehavior().getSleep()) return false;
		
		int dx = 0, dy = 0;
		
		char[] patternInUse;
		
		if(this.getBehavior().isPatternInverted()) patternInUse = this.getInvertedPattern(); 
		else patternInUse = this.getPattern();


		  switch (patternInUse[this.currentPosition]){
		case 'w':
			dx--;	
			break;
		case 'a':
			dy--;
			break;
		case 's':
			dx++;
			break;
		case 'd':
			dy++;
			break;
		}

		int x = this.getX() + dx;
		int y = this.getY() + dy;

		char symbol = level.getMap().getMapElement(x, y);
		if (symbol != ' ')
			return false;

		this.setX(x);
		this.setY(y);

		if (this.getBehavior().isPatternInverted()) {
			this.decCurrentPosition();
		} else {
			this.incCurrentPosition();
		}
		return true;
	}
	
}