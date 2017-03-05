package gamelogic;

import java.util.*;
import gamelogic.Map;

public class Game {
	ArrayList<Level> levels = new ArrayList<Level>();

	public Game(){
		
		//level 0
		char empty_map0[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
							   { 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
							   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
							   { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		char[] guard_pattern00 = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
		'd', 'd', 'w', 'w', 'w', 'w', 'w' };
		Map map0 = new Map(empty_map0);
		Hero hero0 = new Hero(1,1);
		ArrayList<Guard> guards0 = new ArrayList<Guard>();
		ArrayList<Ogre> ogres0 = new ArrayList<Ogre>();
		ArrayList<Key> keys0 = new ArrayList<Key>();
		ArrayList<Lever> levers0 = new ArrayList<Lever>();
		//guards0.add(new Guard(1, 8, guard_pattern00));
		guards0.add(new Guard(1, 8, guard_pattern00, "zealous"));
		levers0.add(new Lever(8,7));
		//end level 0
		
		//level 1
		char empty_map1[][] = {
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		Map map1 = new Map(empty_map1);
		Hero hero1 = new Hero(1,1);
		ArrayList<Guard> guards1 = new ArrayList<Guard>();
		ArrayList<Ogre> ogres1 = new ArrayList<Ogre>();
		ArrayList<Key> keys1 = new ArrayList<Key>();
		ArrayList<Lever> levers1 = new ArrayList<Lever>();
		ogres1.add(new Ogre(5, 5));
		keys1.add(new Key(8,7));
				
		//level 1
		
		
//	public Level(Hero hero, Map map, ArrayList<Guard> guards, ArrayList<Ogre> ogres, ArrayList<Lever> levers, ArrayList<Key> keys)
		Level level0 = new Level(hero0, map0, guards0, ogres0, levers0, keys0);
		Level level1 = new Level(hero1, map1, guards1, ogres1, levers1, keys1);
		levels.add(level0);
		levels.add(level1);
	}

	public void play() {
		for (int i = 0; i < levels.size(); i++) {
			levels.get(i).play();
			if (levels.get(i).checkHeroCaptured()) {
				System.out.println("Voce foi capturado.");
				return;
			}
		}
		System.out.println("Chegou ao fim desta demonstracao virtual.");
	}
	// char empty_map[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'
	// },
	// { 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
	// { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
	// { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
	// { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
	// { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
	// { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
	// { 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
	// { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
	// { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	//
	// char[] guard_pattern = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a',
	// 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
	// 'd', 'd', 'w', 'w', 'w', 'w', 'w' };
	// hero = new Hero(1, 1);
	// guards.add(new Guard(1, 8, guard_pattern));
	// ogres.add(new Ogre(8, 1, guard_pattern));
	// userInput = new Input();
}
