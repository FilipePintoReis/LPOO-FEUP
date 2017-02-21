package gamelogic;
import userinteraction.Input;
import java.io.*;
import java.util.*;

public class Game {
	
	char empty_map[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	Map map = new Map(empty_map);
	boolean gameOver = false;
	Input userInput = new Input();
	Hero hero;
	ArrayList<Guard> guards = new ArrayList<Guard>();
	String gameOverMessage = "Venho por este meio parabeniza-lo(a) pelo desempenho que demonstrou neste jogo.\n";

	
	public boolean moveHero(Hero hero) {         
		int dx = 0, dy = 0;

		switch (userInput.getUserInput()) {
		case "w":
			dx--;
			break;
		case "a":
			dy--;
			break;
		case "s":
			dx++;
			break;
		case "d":
			dy++;
			break;
		default:
			break;
		}

		int x = hero.getX() + dx;
		int y = hero.getY() + dy;

		char symbol = map.getMapElement(x, y);
		if (symbol != ' ')
			return false;
		;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		hero.setX(x);
		hero.setY(y);
		return true;
	}

	public boolean moveGuard(Guard guard) {
		int dx = 0, dy = 0;

		switch (guard.getPattern()[guard.currentPosition]) {
		case 'w':
			dx--;
			break;
		case 'a':
			dy--;
			break;
		case 's':
			dx++;
			break;
		case 'd':
			dy++;
			break;
		default:
			System.out.println("Simbolo invalido");
			break;
		}

		int x = guard.getX() + dx;
		int y = guard.getY() + dy;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		guard.setX(x);
		guard.setY(y);

		guard.incCurrentPosition();
		return true;
	}



	
	public Game() {
		hero = new Hero(1, 1);
		guards.add(new Guard(this, 1, 8));
		userInput = new Input();
	}	

	public void printMap() {

		map.cleanCurrentMap();

		map.setSymbol(hero.getX(),hero.getY() , hero.getSymbol());
		
		for (int i = 0; i < guards.size(); i++)
			map.setSymbol(guards.get(i).getX(), guards.get(i).getY(), guards.get(i).getSymbol());

		for (int i = 0; i < map.getXMapLength(); i++) {
			for (int j = 0; j < map.getYMapLength(); j++) {
				System.out.print(map.getMapElement(i, j) + " ");
			}
			System.out.print("\n");
		}
	}

	public void play() {
		while (!gameOver) {
			printMap();
			System.out.print("Direction[wasd]: ");

			moveHero(hero);
			
			int x = hero.getX();
			int y = hero.getY();
			

			if (map.getMapElement(x + 1, y) == 'i' || map.getMapElement(x - 1, y) == 'i' || map.getMapElement(x, y + 1) == 'i' || map.getMapElement(x, y - 1) == 'i') {
				gameOver = true;
				continue;
			}
			
		
			for (int i = 0; i < guards.size(); i++) {
				moveGuard(guards.get(i));
			}

			for (int i = 0; i < guards.size(); i++)
				if (Math.abs(x - guards.get(i).getX()) + Math.abs(y - guards.get(i).getY()) < 2) {
					gameOver = true;
					gameOverMessage = "Demonstracao de habilidade insuficiente relativamente aos objetivos a cumprir.\n";
					break;
				}

			if (gameOver)
				continue;

			if (map.getMapElement(x + 1, y) == 'k' || map.getMapElement(x - 1, y) == 'k' || map.getMapElement(x, y + 1) == 'k' || map.getMapElement(x, y - 1) == 'k') {
				for (int i = 0; i < map.getXMapLength(); i++)
					for (int j = 0; j < map.getYMapLength(); j++)
						if (map.getMapElement(i, j) == 'I')
							map.setSymbol(i, j, 'i');
			}
		}
		printMap();
		System.out.print(gameOverMessage);
	}
}
