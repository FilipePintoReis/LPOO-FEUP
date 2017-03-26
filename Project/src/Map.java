package dkeep.logic;
import java.util.*;

public class Map {
	char empty_map[][];
	char current_map[][];
	ArrayList<Entity> exits;
	
	/**
	 * map constructor, given a X and Y lengths
	 * @param x
	 * @param y
	 */
	
	public Map(int x, int y){
		empty_map = new char[x][y];
		current_map = new char[x][y];
	}
	
	
	/**
	 * Map constructor, given a char[][] map
	 * @param map
	 */
	
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
	
	/**
	 * sets the symbol of the given (x, y) position to a new, given symbol
	 * @param x
	 * @param y
	 * @param symbol
	 */
	
	public void setSymbol(int x, int y, char symbol){ current_map[x][y] = symbol; }
	
	/**
	 *  opens the doors of the maps, turns their symbols from 'I' to 'S'
	 */
	
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
	
	/**
	 * creats Exit entities and pushes them to a Exit ArrayList, according to their
	 * position on the map
	 */
	
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
	
	/**
	 * returns the element of the map at the given (x, y) position
	 * @param x int
	 * @param y int
	 * @return char
	 */
	
	public char getMapElement(int x, int y){ return current_map[x][y]; }
	
	/**
	 * returns the X length of the current map
	 * @return int
	 */
	
	public int getXMapLength(){ return current_map.length; }
	
	/**
	 * returns the Y length of the current map
	 * @return int
	 */
	
	public int getYMapLength(){ return current_map[0].length; }
	
	/**
	 * returns the empty map
	 * @return char[][]
	 */
	
	public char[][] getEmptyMap(){ return empty_map; }
	
	/**
	 * returns the current map 
	 * @return char[][]
	 */
	
	public char[][] getCurrentMap(){ return current_map; }
	
	/**
	 * return the arraylist of exits of the map
	 * @return ArrayList<Entity>
	 */
	
	public ArrayList<Entity> getExits(){ return exits; }
	
	/**
	 * cleans the current map, equals it to the empty map
	 */
	
	public void cleanCurrentMap(){
		for(int i=0; i < current_map.length; i++)
			for(int j=0; j < current_map[i].length; j++)
				current_map[i][j] = empty_map[i][j];
	}
	
	/*public boolean isEmpty(int x, int y){
		return (current_map[x][y] == ' ');
	}*/
	
}
