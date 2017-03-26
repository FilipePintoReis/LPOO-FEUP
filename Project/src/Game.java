package dkeep.logic;

import java.util.*;

public class Game {
	ArrayList<Level> levels = new ArrayList<Level>();
	int currentLevel;
	boolean gameOver;
	
	/**
	 * return levels
	 * @return ArrayList<Level>
	 */
	public ArrayList<Level> getLevels(){ return levels; }
	/**
	 * returns currentlevel int
	 * @return int
	 */
	public int getCurrentLevelIndex(){ return currentLevel; }
	/**
	 * returns current level 
	 * @return Level
	 */
	public Level getCurrentLevel(){ return levels.get(currentLevel); }
	/**
	 * returns previous level
	 * @return Level
	 */
	public Level getPreviousLevel(){ 
		if(levels.size() == 1) return levels.get(0);
		else return levels.get(currentLevel - 1);
		}
	/**
	 * resets game
	 */
	public void resetGame(){
		levels.clear();
		gameOver = false;
		currentLevel = 0;
	}
	
	/**
	 * increments currentLevel
	 */
	public void incCurrentLevel(){
		currentLevel++;
		if(currentLevel > levels.size()-1)
			gameOver = true;
	}
	
	/**
	 * decrementsCurrentLevel
	 */
	public void decCurrentLevel(){
		currentLevel--;
		if(currentLevel < 0){
			currentLevel = 0;
		}
	}
	/**
	 * constructor
	 * @param level
	 */
	public Game(Level level){
		currentLevel = 0;
		gameOver = false;
		levels = new ArrayList<Level>();
		levels.add(level);
	}
	/**
	 * constructor
	 */
	public Game(){
		currentLevel = 0;
		gameOver = false;
		levels = new ArrayList();
	}
	/**
	 * function that receives user input and checks if the level ends after that move. Also increments level 
	 * @param userInput
	 */
	public void play(String userInput){ 
		levels.get(currentLevel).makeMove(userInput);
		if(levels.get(currentLevel).isOver()){
			incCurrentLevel();
			if(currentLevel > levels.size()-1)
				currentLevel--;
		}
	}
	/**
	 * runs throught every level to check if it is finished
	 * @return boolean
	 */
	public boolean checkLevelsFinished(){
		for(int i=0; i < levels.size(); i++)
			if(!levels.get(i).isOver())
				return false;
		return true;
	}
	/**
	 * returns true if hero was captured else false
	 * @return boolean
	 */
	public boolean checkHeroCaptured(){
		for(int i = 0; i < levels.size(); i++){
			if(levels.get(i).getHero().isCaptured())
				return true;
		}
		return false;
	}
	
	/**
	 * returns true if game is over else false
	 * @return boolean
	 */
	public boolean checkGameOver(){
		for(int i=0; i < levels.size(); i++)
			if(levels.get(i).checkHeroCaptured())
				return true;
		return false;
	}
	/**
	 * functions that creates correspondent string of the current map
	 * @return String
	 */
	public String getCurrentMapString() {
		if(currentLevel < 0 | currentLevel > levels.size()-1)
			return getPreviousMapString();
	
		String map = "";
		
		for (int i = 0; i < this.getCurrentLevel().getMap().getXMapLength(); i++) {
			for (int j = 0; j < this.getCurrentLevel().getMap().getYMapLength(); j++) {
				if (j == this.getCurrentLevel().getMap().getYMapLength() - 1)
					map += this.getCurrentLevel().getMap().getMapElement(i, j);
				else {
					map += this.getCurrentLevel().getMap().getMapElement(i, j);
					map += " ";
				}
			}
			if(i == getCurrentLevel().getMap().getXMapLength() - 1)
				continue;
			else
			map += "\n";
		}
		return map;
	}
	/**
	 * same as getCurrentMapString(), but uses previous map
	 * @return String
	 */
	public String getPreviousMapString() {
		String map = "";
		for (int i = 0; i < this.getPreviousLevel().getMap().getXMapLength(); i++) {
			for (int j = 0; j < this.getPreviousLevel().getMap().getYMapLength(); j++) {
				if (j == this.getPreviousLevel().getMap().getYMapLength() - 1)
					map += this.getPreviousLevel().getMap().getMapElement(i, j);
				else {
					map += this.getPreviousLevel().getMap().getMapElement(i, j);
					map += " ";
				}
			} 
			if(i == getPreviousLevel().getMap().getXMapLength() - 1)
				continue;
			else
			map += "\n";
		}
		return map;
	}

}
