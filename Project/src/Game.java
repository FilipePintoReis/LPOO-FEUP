import java.io.*;
import java.util.*;

public class Game {
	class Entity{
		int x;
		int y;
		char symbol;
		public int getX(){return x;};
		public int getY(){return y;}
		public char getSymbol(){return symbol;};
		public void setX(int x){this.x = x;};
		public void setY(int y){this.y = y;};
		public void setSymbol(char symbol){this.symbol = symbol;};
		public Entity(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	class Guard extends Entity{
                char pattern[] = {'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'w', 'w', 'w', 'w', 'w'};
                int currentPosition;
		public Guard(int x, int y){
			super(x,y);
			this.setSymbol('G');
			this.currentPosition = 0;
		}
		public char[] getPattern(){ return this.pattern; }
		public int getCurrentPosition(){ return this.currentPosition; }
		public void incCurrentPosition(){
                    this.currentPosition++;
                    if(currentPosition > pattern.length-1)
                        this.currentPosition = 0;
                    }
	}
	class Hero extends Entity{
		public Hero(int x, int y){
			super(x,y);
			symbol = 'H';
		}
	}
	public boolean moveHero(Hero hero){
            int dx = 0, dy = 0;
            input = sc.nextLine();

		switch(input){
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
                    
                int x = hero.getX()+dx;
		int y = hero.getY()+dy;
		
		char symbol = map[x][y];
		if(symbol != ' ') return false;;
		
		if(x < 0 || x > map.length -1)return false;
		if(y < 0 || y > map.length -1) return false;

		hero.setX(x);
                hero.setY(y);
		return true;
	}
	
	public boolean moveGuard(Guard guard){
            int dx = 0, dy = 0;
            
            switch(guard.getPattern()[guard.currentPosition]){
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
                
                int x = guard.getX()+dx;
                int y = guard.getY()+dy;
                
                if(x < 0 || x > map.length -1) return false;
                if(y < 0 || y > map.length -1) return false;
                
                guard.setX(x);
                guard.setY(y);
                
                guard.incCurrentPosition();
                return true;
	}
	
	Scanner sc;
	String input;
	boolean gameOver = false;
	char empty_map[][] = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
	};

	char[][] map = new char[10][10];
	Hero hero;
	ArrayList<Guard> guards = new ArrayList<Guard>();

	public Game(){
		hero = new Hero(1,1);
		guards.add(new Guard(1,8));
		sc = new Scanner(System.in);
	}

	public void printMap(){

		for(int i = 0; i < 10; i++)
		for(int j = 0; j < 10; j++)
		map[i][j]=empty_map[i][j];

		map[hero.getX()][hero.getY()] = hero.getSymbol();

		for(int i = 0; i < guards.size(); i++)
		map[guards.get(i).getX()][guards.get(i).getY()] = guards.get(i).getSymbol();

		for(int i=0; i < map.length; i++){
			for(int j=0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

public void play(){
	while(!gameOver){
		printMap();
		System.out.print("Direction[wasd]: ");

		moveHero(hero);
		
		int x = hero.getX();
		int y = hero.getY();
		
		if(map[x+1][y] == 'i' ||
                   map[x-1][y] == 'i' ||
                   map[x][y+1] == 'i' ||
                   map[x][y-1] == 'i'){
                gameOver = true;
                continue;
                }
		
		for(int i = 0; i < guards.size(); i++){
                    moveGuard(guards.get(i));
		}

		for(int i = 0; i < guards.size(); i++)
		if(
		Math.abs(x - guards.get(i).getX()) +
		Math.abs(y - guards.get(i).getY()) < 2
		){gameOver = true; break;}

		if(gameOver) continue;

		if(
		map[x+1][y]=='k'||
		map[x-1][y]=='k'||
		map[x][y+1]=='k'||
		map[x][y-1]=='k'
		){
			for(int i = 0; i < empty_map.length; i++)
			for(int j = 0; j < empty_map[i].length; j++)
			if(empty_map[i][j] == 'I')
			empty_map[i][j] = 'i';
		}
	}
	System.out.print("Venho por este meio parabeniza-lo(a) pelo desempenho que demonstrou neste jogo.\n");
    }
}
