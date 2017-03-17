package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DungeonTest {

	
	@Before public void initialize() {
	char [][] empty_map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							{ 'X', 'H', ' ', 'G', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			   				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			    };
	
	
	
	Map map = new Map(empty_map);
	Hero hero = new Hero(1,1);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();
	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);
	}
	

}
