package dkeep.logic;

import java.util.concurrent.ThreadLocalRandom;

public class Behavior {
	boolean sleep;
	boolean invertPattern;
	String type;
	
	public Behavior(String type){
		if(!type.equals("rookie") & !type.equals("drunk") & !type.equals("zealous"))
			return;
	
		this.type = type;
		this.sleep = false;
		this.invertPattern = false;
	}
	
	public boolean getSleep(){ return sleep; }
	public String getType(){ return type; }
	public boolean getInvertPattern(){ return invertPattern; }
	public void setSleep(){ sleep = true; }
	public void invertPattern(){ invertPattern = true; }
	public void setType(String type){ this.type = type; }
	
	public void toggleSleep(){
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
		
	public void toggleInvertPattern(){
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
		//int randomNumber = 0;
		
		switch(randomNumber){
		
		case 0:
		invertPattern = false;
		break;
		
		case 1:
		invertPattern = true;
		break;
		
		default:
		break;
		}
	}
	
	
	
}
