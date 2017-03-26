package dkeep.logic;

import java.util.*;

public class Level {
	// class attributes
	boolean levelOver = false;
	Map map;
	Hero hero;
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();    
	
	public Map getMap(){ return this.map; }
	public Hero getHero(){ return this.hero; }
	public ArrayList<Guard> getGuards(){ return this.guards; }
	public ArrayList<Ogre> getOgres(){ return this.ogres; }
	public ArrayList<Key> getKeys(){ return this.keys; }
	public ArrayList<Lever> getLevers(){ return this.levers; }
	public boolean isOver(){ return levelOver; }
	
	/**
	 * Level constructor, receives each element that constitutes a level
	 * @param hero
	 * @param map
	 * @param guards
	 * @param ogres
	 * @param levers
	 * @param keys
	 * @param clubs
	 */
	
	public Level(Hero hero, Map map, ArrayList<Guard> guards, ArrayList<Ogre> ogres, ArrayList<Lever> levers,
			ArrayList<Key> keys, ArrayList<Club> clubs) {
		this.hero = hero;
		this.map = map;
		this.guards = guards;
		this.ogres = ogres;
		this.levers = levers;
		this.keys = keys;
		this.clubs = clubs;
		uploadMap();
	}

	/**
	 * uploads each guard according to their behaviour
	 * moves each guard
	 */
	
	public void uploadGuards() {
		for (int i = 0; i < guards.size(); i++) {
			if(guards.get(i).getBehavior().getSleep()){
				guards.get(i).setSymbol('g');
			}
			else { guards.get(i).setSymbol('G'); }
			
			switch (guards.get(i).getBehavior().getType()) {
 
			case "drunk":
			guards.get(i).getBehavior().chanceOfSleep();
			guards.get(i).getBehavior().chanceOfInvertingPattern();
			break;
			 
			case "zealous":
			guards.get(i).getBehavior().chanceOfInvertingPattern();
			break;

			default:
				break;
			}
			guards.get(i).moveEntity(this);
		}
	}

	/**
	 * uploads the ogres state by checking if any ogre was stunned and moves each ogre
	 */
	
	public void uploadOgres() {
		for (int i = 0; i < ogres.size(); i++) {
			if(ogres.get(i).isStunned()){
				ogres.get(i).decStunCount();
				return;
			}
			ogres.get(i).moveEntity(this);
			while (!ogres.get(i).swingMace(i,this))
				ogres.get(i).swingMace(i, this);
		}
	}
	
	/**
	 * cleans the current map and puts each element (keys, levers, clubs, hero, ogres, guards, maces )
	 * on the cleansed current map
	 */
	
	public void uploadMap(){
		map.cleanCurrentMap();
		// put keys in map
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).isPickedUp())
				continue;
			else
				map.setSymbol(keys.get(i).getX(), keys.get(i).getY(), keys.get(i).getSymbol());
		}
		// put levers in map
		for (int i = 0; i < levers.size(); i++) {
			map.setSymbol(levers.get(i).getX(), levers.get(i).getY(), levers.get(i).getSymbol());
		}
		//put clubs in map
		for (int i = 0; i < clubs.size(); i++) {
			map.setSymbol(clubs.get(i).getX(), clubs.get(i).getY(), clubs.get(i).getSymbol());
		}
		// put hero in map
		map.setSymbol(hero.getX(), hero.getY(), hero.getSymbol());
		// put guards in map
		for (int i = 0; i < guards.size(); i++){
			map.setSymbol(guards.get(i).getX(), guards.get(i).getY(), guards.get(i).getSymbol());
		}
		// put ogres in map
		for (int i = 0; i < ogres.size(); i++) {
			map.setSymbol(ogres.get(i).getX(), ogres.get(i).getY(), ogres.get(i).getSymbol());
			// put maces in map
			map.setSymbol(ogres.get(i).getMace().getX(), ogres.get(i).getMace().getY(),
					ogres.get(i).getMace().getSymbol());
		}
	}
	
	/**
	 * checks if the hero was captured by any guards and sets its state accordingly
	 */
	
	public void checkCapturedByGuards() {
		for (int i = 0; i < guards.size(); i++)
			if (Math.abs(hero.getX() - guards.get(i).getX()) + Math.abs(hero.getY() - guards.get(i).getY()) < 2) {
				hero.captureHero();
				break;
			}
	}

	/**
	 * checks if the hero was captured by the ogres or hit by their maces and sets the heros state accordingly
	 * 
	 */
	public void checkCapturedByOgres() {
		for (int i = 0; i < ogres.size(); i++) {
			if (!hero.hasWeapon) {
				if (Math.abs(hero.getX() - ogres.get(i).getX()) + Math.abs(hero.getY() - ogres.get(i).getY()) < 2
						|| Math.abs(hero.getX() - ogres.get(i).getMace().getX())
								+ Math.abs(hero.getY() - ogres.get(i).getMace().getY()) < 2) {
					hero.captureHero();
					break;
				}
			} else {
				if (Math.abs(hero.getX() - ogres.get(i).getMace().getX())
						+ Math.abs(hero.getY() - ogres.get(i).getMace().getY()) < 2) {
					hero.captureHero();
					break;
				}
			}
		}
	}
	
	/**
	 * checks if any ogres were stunned and sets their states accordingly
	 */
	
	public void checkStunnedOgres(){
		for(int i=0; i < ogres.size(); i++){
		if(hero.hasWeapon())
			if (Math.abs(hero.getX() - ogres.get(i).getX()) + Math.abs(hero.getY() - ogres.get(i).getY()) < 2){
				ogres.get(i).setStunCount();
				ogres.get(i).checkStun();
			}
		}
	}
	
	/**
	 * checks if the hero reached the exit and sets the levels state accordingly
	 */

	public void checkHeroOnExit() {
		map.loadExits();
		for (int i = 0; i < map.getExits().size(); i++) {
			if (map.getExits().get(i).getX() == hero.getX() && map.getExits().get(i).getY() == hero.getY())
				levelOver = true;
		}
	}

	
	/**
	 * checks if the hero is on a lever and sets the map, hero and lever states accordingly
	 */
	
	public void checkHeroOnLever() {
		for (int i = 0; i < levers.size(); i++)
			if (levers.get(i).getX() == hero.getX() && levers.get(i).getY() == hero.getY()){
				map.openDoors();
				levers.get(i).activate();
			}
	}

	/**
	 * checks if the hero caught the key and sets the heros and keys states accordingly
	 */
	
	public void checkHeroOnKey() {
		for (int i = 0; i < keys.size(); i++)
			if (keys.get(i).getX() == hero.getX() && keys.get(i).getY() == hero.getY()) {
				this.hero.giveKey();
				keys.get(i).pickUp();
			}
	}
	
	/**
	 * checks if the hero was hit by a club and sets its state accordingly
	 */
	
	public void checkHeroOnClub(){
		for(int i = 0; i < clubs.size(); i++)
			if (clubs.get(i).getX() == hero.getX() && clubs.get(i).getY() == hero.getY()) {
				this.hero.giveWeapon();
				clubs.get(i).pickUp();
			}
	} 

	/**
	 * checks if the hero was captured
	 * returns the heros captured state
	 * @return
	 */
	
	public boolean checkHeroCaptured() {
		return hero.isCaptured();
	}

	/**
	 * checks if the key was picked up and sets its symbol and state accordingly
	 */
	
	public void checkKeyStatus() {
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).isPickedUp())
				keys.get(i).setSymbol(' ');
			if (!(keys.get(i).isPickedUp()))
				keys.get(i).setSymbol('k');
		}
	}
	
	/**
	 * checks if the club was picked up and sets its symbol and state accordingly
	 */
	
	public void checkClubStatus() {
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).isPickedUp())
				clubs.get(i).setSymbol(' ');
			if (!clubs.get(i).isPickedUp())
				clubs.get(i).setSymbol('C');
		}
	}
	
	/**
	 * makes a move given a user input
	 * moves the hero in the inputs direction and uploads the level
	 * @param userInput
	 */
	
	public void makeMove(String userInput){
		uploadMap();
		uploadGuards();
		uploadOgres();
		
		this.hero.moveEntity(userInput, this);

		checkHeroOnExit();
		checkHeroOnLever();
		checkHeroOnKey();
		checkHeroOnClub();

		checkClubStatus();
		checkKeyStatus();
		
		checkCapturedByGuards();
		checkCapturedByOgres();
		checkStunnedOgres();
		uploadMap();
	}
}
