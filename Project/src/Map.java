package gamelogic;

public class Map {
	char empty_map[][];
	char current_map[][];
	
	public Map(int x, int y){
		empty_map = new char[x][y];
		current_map = new char[x][y];
	}
	
	public Map(char[][] map){
		
		current_map = new char[map.length][map[0].length];
		empty_map = new char[map.length][map[0].length];
		
		for(int i=0; i < current_map.length; i++){
			
			for(int j=0; j < current_map[i].length; j++){
				current_map[i][j] = map[i][j];
				empty_map[i][j] = map[i][j];
			}
		}
	}
	
	public void setSymbol(int x, int y, char symbol){ current_map[x][y] = symbol; }
	
	public char getMapElement(int x, int y){ return current_map[x][y]; }
	public int getXMapLength(){ return current_map.length; }
	public int getYMapLength(){ return current_map[0].length; }
	public char[][] getEmptyMap(){ return empty_map; }
	public char[][] getCurrentMap(){ return current_map; }
	
	public void cleanCurrentMap(){
		for(int i=0; i < current_map.length; i++)
			for(int j=0; j < current_map[i].length; j++)
				current_map[i][j] = empty_map[i][j];
	}
	
	public boolean isEmpty(int x, int y){
		return (current_map[x][y] == ' ');
	}
	
}
