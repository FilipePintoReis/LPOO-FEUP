
public class Hero {
	int x,y;
	char symbol;
	
	public Hero(){
		this.symbol = 'H';
		this.x = 1;
		this.y = 1;
	}
	
	public Hero(int x, int y){
		this.symbol = 'H';
		this.x = x;
		this.y = y;
	}
	
	public void moveLeft(){
		this.x--;
	}
	
	public void moveRight(){
		this.x++;
	}
	
	public void moveUp(){
		this.y--;
	}
	
	public void moveDown(){
		this.y++;
	}
	
	public char getSymbol(){
		return this.symbol;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
