package gamelogic;
import java.util.*;

public class Game {
	ArrayList<Level> levels = new ArrayList<Level>();
	

	public Game(){
		Level level1 = new Level();
		levels.add(level1);
	}
	
	public void play(){
		for(int i=0; i < levels.size(); i++){
			levels.get(i).play();
		}
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
