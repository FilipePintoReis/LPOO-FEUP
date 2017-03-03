package gamelogic;
import gamelogic.Entity;

class Guard extends Entity {
	
	char pattern[];
	int currentPosition;

	public Guard(int x, int y, char[] pattern) {
		super(x, y);
		this.setSymbol('G');
		this.currentPosition = 0;
		this.pattern = new char[pattern.length];
		for(int i=0; i < this.pattern.length; i++){
			this.pattern[i] = pattern[i];
		}
	}
	
	public Guard(int x, int y) {
		super(x, y);
		this.setSymbol('G');
		this.currentPosition = 0;
		pattern = new char[24];
	}
	
	public void setPattern(char[] pattern){
		for(int i=0; i < pattern.length; i++){
			this.pattern[i] = pattern[i];
		}
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
	//	this.currentPosition = (this.currentPosition + 1) % pattern.length;
	}
}