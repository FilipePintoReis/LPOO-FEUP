package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ActualGameClassTest {

	
	char [][] empty_map = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
};
	
	char[] g1Pattern = { 'd', 's', 'a', 'w' };
	Map map = new Map(empty_map);
	Hero hero = new Hero(1, 1);
	Guard guard = new Guard(1, 3);
	Lever lever = new Lever(3, 1);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();

	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Level level2 = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);

	@Before
	public void initialize() {
		guards.add(guard);
		levers.add(lever);
		game.getLevels().add(level2);
	}
	@Test
	public void testStringMap(){
		String stringMap = game.getCurrentMapString();
		String test = "X X X X X X X X X X"
			  +"\n" + "X H               X" 
			  +"\n" + "I                 X" 
			  +"\n" + "X                 X"
			  +"\n" + "X                 X"
			  +"\n" + "X                 X"
			  +"\n" + "X X X X X X X X X X";
		assertEquals(test,stringMap);
		
		game.play("s");
		game.play("s");
		game.play("w");
		game.play("a");
		
		String lastMap = game.getPreviousMapString();
		String test1 =    "X X X X X X X X X X"
				  +"\n" + "X     G           X" 
				  +"\n" + "H                 X" 
				  +"\n" + "X k               X"
				  +"\n" + "X                 X"
				  +"\n" + "X                 X"
				  +"\n" + "X X X X X X X X X X";
		assertEquals(test1,lastMap);
	}
}
