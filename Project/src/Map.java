package gamelogic;
import java.util.*;

public class Map {
	char empty_map[][];
	char current_map[][];
	ArrayList<Entity> exits;
	
	public Map(int x, int y){
		empty_map = new char[x][y];
		current_map = new char[x][y];
	}
	
	public Map(char[][] map){
		
		current_map = new char[map.length][map[0].length];
		empty_map = new char[map.length][map[0].length];
		exits = new ArrayList<Entity>();
		
		for(int i=0; i < current_map.length; i++){
			
			for(int j=0; j < current_map[i].length; j++){
				current_map[i][j] = map[i][j];
				empty_map[i][j] = map[i][j];
			}
		}
	}
	public void setSymbol(int x, int y, char symbol){ current_map[x][y] = symbol; }
	public void openDoors(){
		for(int i = 0; i < this.getXMapLength(); i++ )
			for(int j = 0; j < this.getYMapLength(); j++){
				if(current_map[i][j] == 'I'){
					current_map[i][j] = 'S';
				}
			}
		for(int i = 0; i < this.getXMapLength(); i++ )
			for(int j = 0; j < this.getYMapLength(); j++){
				if(empty_map[i][j] == 'I'){
					empty_map[i][j] = 'S';
				}
			}	
	}
	public void setExits(ArrayList<Entity> exits){
		char old_map[][] = current_map;
		
		for(int i=0; i < exits.size(); i++){
			if(current_map[exits.get(i).getX()][exits.get(i).getY()] != 'X' ||
			   current_map[exits.get(i).getX()][exits.get(i).getY()] !=	' '){
				current_map = old_map;
				return;
			}
			current_map[exits.get(i).getX()][exits.get(i).getY()] = exits.get(i).getSymbol();
		}
	}
	public void loadExits(){
		exits.clear();
		for(int i=0; i < current_map.length; i++)
			for(int j=0; j < current_map[0].length; j++){
				if(current_map[i][j] == 'I' || current_map[i][j] == 'S'){
					Entity exit = new Entity(i, j, 'I');
					exits.add(exit);
				}
			}
	}
	public char getMapElement(int x, int y){ return current_map[x][y]; }
	public int getXMapLength(){ return current_map.length; }
	public int getYMapLength(){ return current_map[0].length; }
	public char[][] getEmptyMap(){ return empty_map; }
	public char[][] getCurrentMap(){ return current_map; }
	public ArrayList<Entity> getExits(){ return exits; }
	
	public void cleanCurrentMap(){
		for(int i=0; i < current_map.length; i++)
			for(int j=0; j < current_map[i].length; j++)
				current_map[i][j] = empty_map[i][j];
	}
	
	public boolean isEmpty(int x, int y){
		return (current_map[x][y] == ' ');
	}
	
}
