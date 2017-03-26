package dkeep.logic;

public class Entity {
	int x;
	int y;
	char symbol;

	/**
	 * returns x
	 * @return x
	 */
	public int getX() {
		return x;
	};

	/**
	 * returns y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * returns symbol
	 * @return symbol
	 */
	public char getSymbol() {
		return symbol;
	}; 
	/**
	 * sets x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	};
	/**
	 * sets y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	};
	/**
	 * sets symbol
	 * @param symbol
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	};
	/**
	 * function that will only be defined on the subclasses to move entities
	 * @param userInput
	 */
	public void moveEntity(String userInput){
	}
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Constructor
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Entity(int x, int y, char symbol){
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}
}