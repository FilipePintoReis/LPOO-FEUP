package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class StunTest {
	
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
	Club club = new Club(1,2);
	Ogre ogre = new Ogre(1,4);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();
	
	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);
	
	@Before public void initialize() {
		clubs.add(club);
		ogres.add(ogre);
	} 
	
	@Test
	public void testHeroChangeSymbol(){
		assertSame(game.getCurrentLevel().getHero().getSymbol(), 'H');
		makePlayWithStillOgre(game, "d");
		assertSame(game.getCurrentLevel().getHero().getSymbol(), 'A');
	}
	
	@Test 
	public void testHeroStunsOgre(){
		assertSame(game.getCurrentLevel().getOgres().get(0).getSymbol(), '0');
		makePlayWithStillOgre(game, "d");
		makePlayWithStillOgre(game, "d");
		assertSame('8', game.getCurrentLevel().getOgres().get(0).getSymbol());
	}
	
	@Test
	public void testHeroLosesWithWeapon(){
		assertFalse(game.getCurrentLevel().checkHeroCaptured());
		makePlayWithStillOgre(game, "s");
		makePlayWithStillOgre(game, "d");
		makePlayWithStillOgre(game, "d");
		makePlayWithStillOgre(game, "d");
		makePlayWithStillOgre(game, "d");
		assertTrue(game.getCurrentLevel().checkHeroCaptured());

	}
}