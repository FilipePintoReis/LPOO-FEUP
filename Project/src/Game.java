package dkeep.logic;

import java.util.*;

import dkeep.logic.Map;

public class Game {
	ArrayList<Level> levels = new ArrayList<Level>();
	int currentLevel;
	boolean gameOver;
	
	
	public ArrayList<Level> getLevels(){ return levels; }
	public int getCurrentLevelIndex(){ return currentLevel; }
	public Level getCurrentLevel(){ return levels.get(currentLevel); }
	public Level getPreviousLevel(){ 
		if(levels.size() == 1) return levels.get(0);
		else return levels.get(currentLevel - 1);
		}
	
	public void resetGame(){
		levels.clear();
		gameOver = false;
		currentLevel = 0;
	}
	public void incCurrentLevel(){
		currentLevel++;
		if(currentLevel > levels.size()-1)
			gameOver = true;
	}
	
	public void decCurrentLevel(){
		currentLevel--;
		if(currentLevel < 0){
			currentLevel = 0;
		}
	}

	public Game(Level level){
		currentLevel = 0;
		gameOver = false;
		levels = new ArrayList<Level>();
		levels.add(level);
	}
	
	public Game(){
		currentLevel = 0;
		gameOver = false;
		levels = new ArrayList();
	}
	
	public void play(String userInput){ 
		levels.get(currentLevel).makeMove(userInput);
		if(levels.get(currentLevel).isOver()){
			incCurrentLevel();
			if(currentLevel > levels.size()-1)
				currentLevel--;
		}
	}
	
	public boolean checkLevelsFinished(){
		for(int i=0; i < levels.size(); i++)
			if(!levels.get(i).isOver())
				return false;
		return true;
	}
	
	public boolean checkHeroCaptured(){
		for(int i = 0; i < levels.size(); i++){
			if(levels.get(i).getHero().isCaptured())
				return true;
		}
		return false;
	}
	
	
	public boolean checkGameOver(){
		for(int i=0; i < levels.size(); i++)
			if(levels.get(i).checkHeroCaptured())
				return true;
		return false;
	}

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
