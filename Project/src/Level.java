package gamelogic;

import userinteraction.Input;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Level {
	//class attributes
	boolean levelOver = false;
	Input userInput = new Input();
	Map map;
	Hero hero;
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	String levelOverMessage = "Venho por este meio parabeniza-lo(a) pelo desempenho que demonstrou neste jogo.\n";
	
	public Level() {
		char empty_map[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							   { 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
							   { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		char empty_map2[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							    { 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'k', ' ', 'X' },
							    { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		char[] guard_pattern = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
				'd', 'd', 'w', 'w', 'w', 'w', 'w' };
		hero = new Hero(1, 1);
		//map = new Map(empty_map);
		map = new Map(empty_map2);
		//guards.add(new Guard(1, 8, guard_pattern));
		ogres.add(new Ogre(5, 5));
		userInput = new Input();
	}
	
	public Level(Hero hero, Map map, ArrayList<Guard> guards, ArrayList<Ogre> ogres){
		this.hero = hero;
		this.map = map;
		this.guards = guards;
		this.ogres = ogres;
	}

	public boolean moveHero(Hero hero) {
		int dx = 0, dy = 0;

		switch (userInput.getUserInput()) {
		case "w":
			dx--;
			break;
		case "a":
			dy--;
			break;
		case "s":
			dx++;
			break;
		case "d":
			dy++;
			break;
		default:
			break;
		}

		int x = hero.getX() + dx;
		int y = hero.getY() + dy;

		char symbol = map.getMapElement(x, y);
		if (symbol != ' ')
			return false;

		/*if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;*/

		hero.setX(x);
		hero.setY(y);
		return true;
	}

	//moves Guard according to its pattern
	public boolean moveGuard(Guard guard) {
		int dx = 0, dy = 0;

		switch (guard.getPattern()[guard.currentPosition]) {
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

		int x = guard.getX() + dx;
		int y = guard.getY() + dy;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		guard.setX(x);
		guard.setY(y);

		guard.incCurrentPosition();
		return true;
	}
	
	public boolean moveOgre(Ogre ogre) {
		int dx = 0, dy = 0;

		int randomNumber = ThreadLocalRandom.current().nextInt(0, 4);
		
		switch (randomNumber) {
		case 0:
			dx--;
			break;
		case 1:
			dy--;
			break;
		case 2:
			dx++;
			break;
		case 3:
			dy++;
			break;
		}

		int x = ogre.getX() + dx;
		int y = ogre.getY() + dy;
		
		char symbol = map.getMapElement(x, y);
		if (symbol != ' ')
			return false;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		ogre.setX(x);
		ogre.setY(y);
		return true;
	}
	
	public boolean swingMace(int ogreIndex){
		int dx = 0, dy = 0;
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 4);
		
		switch (randomNumber) {
		case 0:
			dx--;
			break;
		case 1:
			dy--;
			break;
		case 2:
			dx++;
			break;
		case 3:
			dy++;
			break;
		}

		int x = ogres.get(ogreIndex).getX() + dx;
		int y = ogres.get(ogreIndex).getY() + dy;
		
		char symbol = map.getMapElement(x, y);
		if (symbol != ' ')
			return false;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		if(Math.abs(x - ogres.get(ogreIndex).getX()) + Math.abs(y - ogres.get(ogreIndex).getY()) > 1)
		return false;
		
		ogres.get(ogreIndex).getMace().setX(x);
		ogres.get(ogreIndex).getMace().setY(y);
		return true;
	}

	

	public void printMap() {
		map.cleanCurrentMap();
        //put hero in map
		map.setSymbol(hero.getX(), hero.getY(), hero.getSymbol());
        //put guards in map
		for (int i = 0; i < guards.size(); i++)
			map.setSymbol(guards.get(i).getX(), guards.get(i).getY(), guards.get(i).getSymbol());
		//put ogres in map
		for (int i = 0; i < ogres.size(); i++){
			map.setSymbol(ogres.get(i).getX(), ogres.get(i).getY(), ogres.get(i).getSymbol());
			//put maces in map
			map.setSymbol(ogres.get(i).getMace().getX(), ogres.get(i).getMace().getY(), ogres.get(i).getMace().getSymbol());
		}
		
        //print map
		for (int i = 0; i < map.getXMapLength(); i++) {
			for (int j = 0; j < map.getYMapLength(); j++) {
				System.out.print(map.getMapElement(i, j) + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void uploadGuards(){
		for (int i = 0; i < guards.size(); i++) {
			moveGuard(guards.get(i));
		}
	}
	public void uploadOgres(){
		for (int i = 0; i < ogres.size(); i++) {
			moveOgre(ogres.get(i));
			while(!swingMace(i))
				swingMace(i);
		}
	}
	public void checkCapturedByGuards(){
		for (int i = 0; i < guards.size(); i++)
			if (Math.abs(hero.getX() - guards.get(i).getX()) + Math.abs(hero.getY() - guards.get(i).getY()) < 2) {
				hero.captureHero();
				levelOver = true;
				levelOverMessage = "Demonstracao de habilidade insuficiente relativamente aos objetivos a cumprir.\n";
				break;
			}
	}
	//checks if Hero was captured by a Ogre or hit by a Mace
	public void checkCapturedByOgres(){
		for (int i = 0; i < ogres.size(); i++)
			if (Math.abs(hero.getX() - ogres.get(i).getX()) + Math.abs(hero.getY() - ogres.get(i).getY()) < 2 ||
					Math.abs(hero.getX() - ogres.get(i).getMace().getX()) + Math.abs(hero.getY() - ogres.get(i).getMace().getY()) < 2) {
				hero.captureHero();
				levelOver = true;
				levelOverMessage = "Demonstracao de habilidade insuficiente relativamente aos objetivos a cumprir.\n";
				break;
			}
	}
	public void checkHeroNearExit(){
		if (map.getMapElement(hero.getX() + 1, hero.getY()) == 'S' || map.getMapElement(hero.getX() - 1, hero.getY()) == 'S'
				|| map.getMapElement(hero.getX(), hero.getY() + 1) == 'S' || map.getMapElement(hero.getX(), hero.getY() - 1) == 'S') {
			levelOver = true;
		}
	}
	public void checkHeroOnExit(){
		map.loadExits();
		for(int i=0; i < map.getExits().size(); i++){
			if(map.getExits().get(i).getX() == hero.getX() &&
			   map.getExits().get(i).getY() == hero.getY())
			levelOver = true;
		}
	}
	public boolean play() {
		while (!levelOver) {
			printMap();
			System.out.print("Direction[wasd]: ");

			moveHero(hero);

			int x = hero.getX();
			int y = hero.getY();

			checkHeroNearExit();
			//checkHeroOnExit();
			
			uploadGuards();
			uploadOgres();
            
			checkCapturedByGuards();
			checkCapturedByOgres();

			if (levelOver)
				continue;
			
            //check if Hero is near the lever
			if (map.getMapElement(x + 1, y) == 'k' || 
				map.getMapElement(x - 1, y) == 'k' || 
				map.getMapElement(x, y + 1) == 'k' ||
				map.getMapElement(x, y - 1) == 'k') 
			{
				map.openDoors();
			}
		}
		printMap();
		System.out.print(levelOverMessage);
		return levelOver;
	}
}
