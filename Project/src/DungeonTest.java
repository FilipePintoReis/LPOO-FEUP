package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DungeonTest {
	
	//@Before public void initialize() {
	char [][] empty_map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			   				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			    };
	char [] g1Pattern = {'d', 's', 'a', 'w'};
	Map map = new Map(empty_map); 
	Hero hero = new Hero(1,1);
	Guard guard = new Guard(1, 3);
	Guard guard1 = new Guard(4, 7, g1Pattern, "drunk");
	Lever lever = new Lever(3, 1);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();
	
	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Level level2 = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);
	
	@Before public void initialize() {
		guards.add(guard);
		levers.add(lever);
		guards.add(guard1);
		game.getLevels().add(level2);
	}
	
	//Tests:
	/*Hero moves successfully into a free cell
	 * Hero tries to unsuccessfully move into a wall
	 * Hero moves into an adjacent position to the guard and the game ends with defeat
	 * Hero moves towards the closed exit doors and fails to leave
	 * Hero moves into the lever cell and the Dungeon exit doors open
	 * Hero moves into the open Dungeon exit doors and progresses into the keep
	 * Drunk guard tests inverted pattern and sleep functions
	 */
	
	@Test
	public void testMoveHeroIntoFreeCell(){
		assertEquals(hero.getX(), 1);
		assertEquals(hero.getY(), 1);
		game.getCurrentLevel().getHero().moveEntity("s", game.getCurrentLevel());
		assertEquals(hero.getX(), 2);
		assertEquals(hero.getY(), 1);		
	}
	
	@Test
	public void testMoveHeroIntoWall(){
		assertEquals(hero.getX(), 1);
		assertEquals(hero.getY(), 1);
		hero.moveEntity("w", game.getCurrentLevel());
		assertEquals(hero.getX(), 1);
		assertEquals(hero.getY(), 1);
	}
	
	@Test 
	public void testHeroCapturedByGuard(){
		game.play("d");
		assertTrue(game.checkHeroCaptured());
		assertTrue(game.checkGameOver());
		}
	
	@Test
	public void testMoveHeroIntoClosedExit(){
		game.play("s");
		game.play("a");
		assertFalse(game.getCurrentLevel().isOver());
	}
	
	@Test
	public void testMoveHeroIntoLever(){
		game.play("s");
		game.play("s");
		assertEquals('S', game.getCurrentLevel().getMap().getMapElement(2, 0));
	}
	 
	@Test
	public void testHeroAdvancesLevel(){
		game.play("s");
		game.play("s");
		game.play("w");
		game.play("a");
		assertSame(level2, game.getCurrentLevel());
	}
	
	@Test(timeout=1000)
	public void testGuardPattern(){
		boolean changedPattern = false, slept = false;
		while(!(changedPattern && slept)){
			game.play("w");
			if(game.getCurrentLevel().getGuards().get(1).getBehavior().getSleep())
				slept = true;
			else if(game.getCurrentLevel().getGuards().get(1).getBehavior().isPatternInverted())
				changedPattern = true;
		}
	}
	
}
