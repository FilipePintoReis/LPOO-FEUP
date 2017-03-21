package dkeep.logic;

import java.util.concurrent.ThreadLocalRandom;

public class Behavior {
	boolean sleep;
	boolean patternIsInverted;
	String type;
	
	public Behavior(String type){
		if(!type.equals("rookie") & !type.equals("drunk") & !type.equals("zealous"))
			return;
	
		this.type = type;
		this.sleep = false;
		this.patternIsInverted = false;
	}
	
	public boolean getSleep(){ return sleep; }
	public String getType(){ return type; }
	public boolean isPatternInverted(){ return patternIsInverted; }
	public void setSleep(){ sleep = true; }
	public void invertPattern(){ patternIsInverted = true; }
	public void setType(String type){ this.type = type; }
	
	public void chanceOfSleep(){
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
		
		switch(randomNumber){
		
		case 0:
		sleep = false;
		break;
		
		case 1:
		sleep = true;
		break;
		
		default:
		break;
		}
	}
		
	public void chanceOfInvertingPattern(){
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
		//int randomNumber = 0;
		
		switch(randomNumber){
		
		case 0:
		patternIsInverted = false;
		break;
		
		case 1:
		patternIsInverted = true;
		break;
		
		default:
		break;
		}
	}
	
	
	
}
