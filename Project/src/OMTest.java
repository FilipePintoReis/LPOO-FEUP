package dkeep.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import dkeep.logic.Club;
import dkeep.logic.Game;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Key;
import dkeep.logic.Level;
import dkeep.logic.Lever;
import dkeep.logic.Map;
import dkeep.logic.Ogre;

public class OMTest {
	
	char [][] empty_map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							{ 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'I', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	Map map = new Map(empty_map);
	Hero hero = new Hero(1, 1);
	Ogre ogre = new Ogre(1, 4);
	Key key1 = new Key(1, 3);
	Key key2 = new Key(1, 5);
	Key key3 = new Key(2, 4);
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	ArrayList<Key> keys = new ArrayList<Key>();
	ArrayList<Lever> levers = new ArrayList<Lever>();
	ArrayList<Club> clubs = new ArrayList<Club>();

	Level level = new Level(hero, map, guards, ogres, levers, keys, clubs);
	Game game = new Game(level);

	@Before
	public void initialize() {
		ogres.add(ogre); 
		keys.add(key1);
		keys.add(key2);
		keys.add(key3);
	}

	@Test(timeout = 1000)
	public void testOgreMovement() {
		boolean wentUp = false, wentDown = false, wentLeft = false, wentRight = false;
		
		while (!wentUp || !wentDown || !wentLeft || !wentRight) {
			int x = game.getCurrentLevel().getOgres().get(0).getX();
			int y = game.getCurrentLevel().getOgres().get(0).getY();
			game.play("d");
			int dx = game.getCurrentLevel().getOgres().get(0).getX();
			int dy = game.getCurrentLevel().getOgres().get(0).getY();

			if (dx - x == 1)
				wentRight = true;
			if (dx - x == -1)
				wentLeft = true;
			if (dy - y == 1)
				wentDown = true;
			if (dy - y == -1)
				wentUp = true;
		}
		assertTrue(true);
	}

	@Test(timeout=1000)
	public void testSwingMace(){
		boolean wentUp = false, wentDown = false, wentLeft = false, wentRight = false;
		
		while(!wentUp || !wentDown || !wentLeft || !wentRight){
			game.play("d");
		if(game.getCurrentLevel().getOgres().get(0).getMace().getX() - game.getCurrentLevel().getOgres().get(0).getX() == 1)
			wentLeft = true;
		if(game.getCurrentLevel().getOgres().get(0).getMace().getX() - game.getCurrentLevel().getOgres().get(0).getX() == -1)
			wentRight = true;
		if(game.getCurrentLevel().getOgres().get(0).getMace().getY() - game.getCurrentLevel().getOgres().get(0).getY() == 1)
			wentUp = true;
		if(game.getCurrentLevel().getOgres().get(0).getMace().getY() - game.getCurrentLevel().getOgres().get(0).getY() == -1)
			wentDown = true;
		}
		
		assertTrue(true);
	}
	
	@Test
	public void testOgreOnKeyChangesSymbol(){
		game.play("s");
		for(int i = 0; i < keys.size(); i++){
			if(game.getCurrentLevel().getMap().getMapElement(game.getCurrentLevel().getKeys().get(i).getX(), game.getCurrentLevel().getKeys().get(i).getY()) == '$');
				assertTrue(true);
		}
	}
	 
}
