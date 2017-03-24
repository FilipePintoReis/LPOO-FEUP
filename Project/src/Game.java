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
	
//	public Game(){
//		currentLevel = 0;
//		gameOver = false;
//		// nivel
//		// heroi
//		
//		//level 0
//		char empty_map0[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//							   { 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
//							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
//							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
//							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
//							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
//							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
//							   { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
//		char[] guard_pattern00 = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
//		'd', 'd', 'w', 'w', 'w', 'w', 'w' };
//		Map map0 = new Map(empty_map0);
//		Hero hero0 = new Hero(1,1);
//		ArrayList<Guard> guards0 = new ArrayList<Guard>();
//		ArrayList<Ogre> ogres0 = new ArrayList<Ogre>();
//		ArrayList<Key> keys0 = new ArrayList<Key>();
//		ArrayList<Lever> levers0 = new ArrayList<Lever>();
//		ArrayList<Club> clubs0 = new ArrayList<Club>();
//		//guards0.add(new Guard(1, 8, guard_pattern00, "zealous"));
//		guards0.add(new Guard(1, 8, guard_pattern00, "zealous"));
//		levers0.add(new Lever(8,7));
//		
//		Level level0 = new Level(hero0, map0, guards0, ogres0, levers0, keys0, clubs0);
//		levels.add(level0);
//		
//		//end level 0
//		
//		//level 1
//		char empty_map1[][] = {
//				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
//		Map map1 = new Map(empty_map1);
//		Hero hero1 = new Hero(1,1);
//		ArrayList<Guard> guards1 = new ArrayList<Guard>();
//		ArrayList<Ogre> ogres1 = new ArrayList<Ogre>();
//		ArrayList<Key> keys1 = new ArrayList<Key>();
//		ArrayList<Lever> levers1 = new ArrayList<Lever>();
//		ArrayList<Club> clubs1 = new ArrayList<Club>();
//		ogres1.add(new Ogre(5, 5));
//		ogres1.add(new Ogre(5,5));
//		ogres1.add(new Ogre(5,5));
//		keys1.add(new Key(8,7));
//		clubs1.add(new Club(1,2));
//		//level 1
//		
//		Level level1 = new Level(hero1, map1, guards1, ogres1, levers1, keys1, clubs1);
//		levels.add(level1); 
//	}
	
	
	
	
	
	
	
	public void play(String userInput){ 
		levels.get(currentLevel).makeMove(userInput);
		if(levels.get(currentLevel).isOver()){
			incCurrentLevel();
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

}
