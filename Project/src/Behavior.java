package dkeep.logic;

import java.util.concurrent.ThreadLocalRandom;

public class Behavior {
	boolean sleep;
	boolean patternIsInverted;
	String type;
	/**
	 *Constructor
	 *
	 *@param type
	 */
	public Behavior(String type){
		if(!type.equals("rookie") & !type.equals("drunk") & !type.equals("zealous"))
			return;
	
		this.type = type;
		this.sleep = false;
		this.patternIsInverted = false;
	}
	/**
	 * returns boolean sleep
	 * 
	 * @return sleep
	 */
	public boolean getSleep(){ return sleep; }
	
	/**
	 *returns boolean type
	 *
	 *@return type
	 */
	public String getType(){ return type; }
	
	/**
	 *returns boolean patternIsInverted
	 *
	 *@return patternIsInverted
	 */
	public boolean isPatternInverted(){ return patternIsInverted; }
	
	/**
	 * function that decides if the guard's gonna sleep or not
	 */
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
		
	/**
	 * function that decides if the guard's gonna invert the pattern or not
	 */
	public void chanceOfInvertingPattern(){
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
		
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
