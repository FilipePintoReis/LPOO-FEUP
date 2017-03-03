package gamelogic;
import java.util.*;

import gamelogic.*;
import userinteraction.Input;

public class Game {
	Hero hero;
	ArrayList<Level> levels = new ArrayList<Level>();
	
	public Game(){
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
		
		char[] guard_pattern = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
		'd', 'd', 'w', 'w', 'w', 'w', 'w' };
		this.hero = new Hero(1, 1);
		Map zero_map = new Map(empty_map);
		ArrayList<Guard> guards = new ArrayList<Guard>();
		guards.add(new Guard(1, 8, guard_pattern));
		ArrayList<Ogre> ogres = new ArrayList<Ogre>();
		//Input userInput = new Input();
		
//Level(Hero hero, Map map, ArrayList<Guard> guards, ArrayList<Ogre> ogres)
		Level level0 = new Level(this.hero, zero_map, guards, ogres);
		Level level1 = new Level();
		levels.add(level0);
		levels.add(level1);
	}
	
	public void play(){
		for(int i=0; i < levels.size(); i++){
			levels.get(i).play();
			if(this.hero.isCaptured()){
				System.out.println("Voce foi capturado. Seu inergumero.");
				return;
			}
		}
		System.out.println("Chegou ao fim desta demonstracao virtual.");
	}
//	char empty_map[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//						{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
//						{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
//						{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
//						{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
//						{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//						{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//						{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
//						{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
//						{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
//	
//	char[] guard_pattern = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
//			'd', 'd', 'w', 'w', 'w', 'w', 'w' };
//	hero = new Hero(1, 1);
//	guards.add(new Guard(1, 8, guard_pattern));
//	ogres.add(new Ogre(8, 1, guard_pattern));
//	userInput = new Input();
}
