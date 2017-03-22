package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class KeepTest {
	
	public void makePlayWithStillOgre(Game game, String input){
		game.getCurrentLevel().uploadMap();
		game.getCurrentLevel().uploadGuards();
		
		game.getCurrentLevel().getHero().moveEntity(input, game.getCurrentLevel());
		game.getCurrentLevel().checkHeroOnExit();
		game.getCurrentLevel().checkHeroOnLever();
		game.getCurrentLevel().checkHeroOnKey();
		game.getCurrentLevel().checkHeroOnClub();

		game.getCurrentLevel().checkClubStatus();
		game.getCurrentLevel().checkKeyStatus();
		
		game.getCurrentLevel().checkCapturedByGuards();
		game.getCurrentLevel().checkCapturedByOgres();
		game.getCurrentLevel().checkStunnedOgres();
		game.getCurrentLevel().uploadMap();
	}

	//@Before public void initialize() {
	char [][] empty_map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			   				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			    };
	
	Map map = new Map(empty_map);
	Hero hero = new Hero(1,1);
	Ogre ogre = new Ogre(1, 3);
	Ogre ogre1 = new Ogre(1, 4);
	Key key2 = new Key(1, 4);
	Key key1 = new Key(3, 1);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();
	
	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);
	
	@Before public void initialize() {
		ogres.add(ogre);
		ogres.add(ogre1);
		keys.add(key1);
		keys.add(key2);
	} 
	
	//Keep Level Tests
	/* Hero moves into an adjacent position to the Ogre and the game ends with defeat
	 * Hero moves into the Keep's exit door key cell and changes its representation to "K"
	 * Hero moves into the closed Keep's exit door, without the key and fails to open it
	 * Hero moves into the closed Keep's exit door, with the key and the the door opens
	 * Hero moves into the open Keep's exit door and the game ends with victory
	 */
	 
	@Test
	public void testHeroGetsCapturebyOgre() {
		makePlayWithStillOgre(game, "d");
		assertTrue(game.getPreviousLevel().getHero().isCaptured());
	}

	@Test
	public void testHeroSymbolTurnsK() {
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "s");
		assertTrue(game.getCurrentLevel().getHero().getSymbol() == 'K');
	}

	@Test
	public void testHeroFailsToExit() {
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "a");
		assertFalse(game.getCurrentLevel().getMap().getMapElement(2, 0) == 'S');
	}

	@Test
	public void testHeroOpensDoor() {
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "w");
		makePlayWithStillOgre(game, "a");
		assertTrue(game.getCurrentLevel().getMap().getMapElement(2, 0) == 'S');
	}

	@Test
	public void testHeroWinsLevel() {
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "w");
		makePlayWithStillOgre(game, "a");
		makePlayWithStillOgre(game, "a");
		assertTrue(game.getPreviousLevel().isOver());
		assertFalse(game.getPreviousLevel().getHero().isCaptured());
	}
	
}