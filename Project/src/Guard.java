package gamelogic;

import gamelogic.Entity;

class Guard extends Entity {
	
	char pattern[];
	int currentPosition;
	Behavior behavior;

	public Guard(int x, int y, char[] pattern, String behavior) {
		super(x, y);
		this.behavior = new Behavior(behavior);
		this.setSymbol('G');
		this.currentPosition = 0;
		this.pattern = new char[pattern.length];
		for(int i=0; i < this.pattern.length; i++){
			this.pattern[i] = pattern[i];
		}
	}
	
	public Guard(int x, int y, char[] pattern) {
		super(x, y);
		this.behavior = new Behavior("rookie");
		this.setSymbol('G');
		this.currentPosition = 0;
		this.pattern = new char[pattern.length];
		for(int i=0; i < this.pattern.length; i++){
			this.pattern[i] = pattern[i];
		}
	}
	
	public Guard(int x, int y) {
		super(x, y);
		this.behavior = new Behavior("rookie");
		this.setSymbol('G');
		this.currentPosition = 0;
		pattern = new char[24];
	}
	
	public void setPattern(char[] pattern){
		for(int i=0; i < pattern.length; i++){
			this.pattern[i] = pattern[i];
		}
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
//	public void invertPattern(){
//		//ArrayUtils.reverse(this.pattern);
//		Collections.reverse(Arrays.asList(this.pattern));
//	}
	
	public void invertPattern(){
		for (int i = 0; i < pattern.length / 2; i++) {
			  char temp = pattern[i];
			  pattern[i] = pattern[pattern.length - 1 - i];
			  pattern[pattern.length - 1 - i] = temp;
			}
	}
	
	public char[] getPattern() { return this.pattern; }
	public int getCurrentPosition() { return this.currentPosition; }
	public Behavior getBehavior(){ return this.behavior; }
	
}