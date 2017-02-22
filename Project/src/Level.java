package gamelogic;

import userinteraction.Input;
import java.util.*;

public class Level {

	

	//class attributes
	boolean levelOver = false;
	Input userInput = new Input();
	Map map;
	Hero hero;
	ArrayList<Guard> guards = new ArrayList<Guard>();
	ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	String levelOverMessage = "Venho por este meio parabeniza-lo(a) pelo desempenho que demonstrou neste jogo.\n";
	
	public Level() {
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
		hero = new Hero(1, 1);
		map = new Map(empty_map);
		guards.add(new Guard(1, 8, guard_pattern));
		ogres.add(new Ogre(8, 1, guard_pattern));
		userInput = new Input();
	}
	
	
	
	public Level(Hero hero, Map map, ArrayList<Guard> guards, ArrayList<Ogre> ogres){
		this.hero = hero;
		this.map = map;
		this.guards = guards;
		this.ogres = ogres;
	}
	
	
	
	
	
	
	
	
	//Game stuff
	
	
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

		/*if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;*/

		hero.setX(x);
		hero.setY(y);
		return true;
	}

	//O switch procura na pattern do guarda a sua nova posicao 
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
	
	public boolean moveOgre(Ogre ogre) {
		int dx = 0, dy = 0;

		switch (ogre.getPattern()[ogre.currentPosition]) {
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

		int x = ogre.getX() + dx;
		int y = ogre.getY() + dy;

		if (x < 0 || x > map.getXMapLength() - 1)
			return false;
		if (y < 0 || y > map.getYMapLength() - 1)
			return false;

		ogre.setX(x);
		ogre.setY(y);

		ogre.incCurrentPosition();
		return true;
	}

	

	public void printMap() {
        //Mapa fica vazio
		map.cleanCurrentMap();
        //Coloca o heroi dentro do novo mapa
		map.setSymbol(hero.getX(), hero.getY(), hero.getSymbol());
        //Coloca os guardas dentro do novo mapa
		for (int i = 0; i < guards.size(); i++)
			map.setSymbol(guards.get(i).getX(), guards.get(i).getY(), guards.get(i).getSymbol());
        //Mostra todos os elementos do mapa
		for (int i = 0; i < map.getXMapLength(); i++) {
			for (int j = 0; j < map.getYMapLength(); j++) {
				System.out.print(map.getMapElement(i, j) + " ");
			}
			System.out.print("\n");
		}
	}

	
	public boolean play() {
		while (!levelOver) {
			printMap();
			System.out.print("Direction[wasd]: ");

			moveHero(hero);

			int x = hero.getX();
			int y = hero.getY();

			//Serve para ver se cheguei às portas da caverna
			if (map.getMapElement(x + 1, y) == 'i' || map.getMapElement(x - 1, y) == 'i'
					|| map.getMapElement(x, y + 1) == 'i' || map.getMapElement(x, y - 1) == 'i') {
				levelOver = true;
			}

			//Serve para mover cada um dos guardas para a sua nova posicao 
			for (int i = 0; i < guards.size(); i++) {
				moveGuard(guards.get(i));
			}
            
			//Avalia para cada guarda se o heroi se encontra em range
			for (int i = 0; i < guards.size(); i++)
				if (Math.abs(x - guards.get(i).getX()) + Math.abs(y - guards.get(i).getY()) < 2) {
					levelOver = true;
					levelOverMessage = "Demonstracao de habilidade insuficiente relativamente aos objetivos a cumprir.\n";
					break;
				}

			if (levelOver)
				continue;
			
            //Avalia se o heroi esta em range da chave
			if (map.getMapElement(x + 1, y) == 'k' || 
				map.getMapElement(x - 1, y) == 'k' || 
				map.getMapElement(x, y + 1) == 'k' ||
				map.getMapElement(x, y - 1) == 'k') 
			{
				map.openDoors();
			}
		}
		printMap();
		System.out.print(levelOverMessage);
		return levelOver;
	}
}
