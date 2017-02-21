package gamelogic;

class Entity {
	int x;
	int y;
	char symbol;

	public int getX() {
		return x;
	};

	public int getY() {
		return y;
	}

	public char getSymbol() {
		return symbol;
	};

	public void setX(int x) {
		this.x = x;
	};

	public void setY(int y) {
		this.y = y;
	};

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	};

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
}