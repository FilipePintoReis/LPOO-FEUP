import java.io.*;
import java.util.*;


public class Game {
	boolean gameOver = false;
	Map map;
	Hero hiro;
	
	public Game(){
		this.map = new Map();
		this.hiro = new Hero();
	}	
	
	public boolean isOver(){
		return gameOver;
	}
	
	public Hero getHero(){
		return this.hiro;
	}
	
	public Map getMap(){
		return this.map;
	}
	
	public boolean moveHero(char input){
		switch(input){
		case 'W':
			if(this.map.getMap()[this.hiro.getX()][this.hiro.getY()-1] != ' '){
				hiro.moveUp();
			}
			break; 
				
		case 'S':
			if(this.map.getMap()[this.hiro.getX()][this.hiro.getY()+1] != ' '){
				hiro.moveDown();
			}
			break;
			
		case 'A':
			if(this.map.getMap()[this.hiro.getX()-1][this.hiro.getY()] != ' '){
				hiro.moveLeft();
			}
			break; 
				
		case 'D':
			if(this.map.getMap()[this.hiro.getX()+1][this.hiro.getY()] != ' '){
				hiro.moveRight();
			}
			break;
			
		default:
			return false;
		}
		return true;
	}
}