package dkeep.logic;

import dkeep.logic.Entity;

public class Guard extends Entity {
	
	char pattern[];
	char inverted_pattern[];
	int currentPosition;
	Behavior behavior;

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
	
	public Guard(int x, int y) {
		super(x, y);
		this.behavior = new Behavior("rookie");
		this.setSymbol('G');
		this.currentPosition = 0;
		pattern = new char[24];
		inverted_pattern = new char[24];
	}
	
	public void incCurrentPosition() {
		this.currentPosition++;
		if (currentPosition > pattern.length - 1)
			this.currentPosition = 0;
	}
	public void decCurrentPosition() {
		this.currentPosition--;
		if (currentPosition < 0)
			this.currentPosition = pattern.length - 1;
	}

	
	public String getPatternString(){
		String patternString = "";
		for(int i = 0; i < this.pattern.length; i++)
			patternString += pattern[i];
		return patternString;
	}
	public String getInvertedPatternString(){
		String patternString = "";
		for(int i = 0; i < this.inverted_pattern.length; i++)
			patternString += inverted_pattern[i];
		return patternString;
	}
	
	
	
	public char[] getPattern() { return this.pattern; }
	public char[] getInvertedPattern(){ return this.inverted_pattern; }
	public int getCurrentPosition() { return this.currentPosition; }
	public Behavior getBehavior(){ return this.behavior; }
	
	
	public boolean moveEntity(Level level) {
		if(this.getBehavior().getSleep()) return false;
		
		int dx = 0, dy = 0;
		
		char[] patternInUse;
		if(this.getBehavior().getInvertPattern())
			patternInUse = this.getInvertedPattern(); //should only take pattern, should do this inside guard
		else patternInUse = this.getPattern();

		//switch (guard.getPattern()[guard.currentPosition]) {
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

		if (this.getBehavior().getInvertPattern()) {
			this.decCurrentPosition();
		} else {
			this.incCurrentPosition();
		}
		return true;
	}
	
}