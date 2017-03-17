package dkeep.cli;
import dkeep.logic.*;

public class Main {
	
	public static void printLevel(Level level){
		for (int i = 0; i < level.getMap().getXMapLength(); i++) {
			for (int j = 0; j < level.getMap().getYMapLength(); j++) {
				System.out.print(level.getMap().getMapElement(i, j) + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		Input userInput = new Input();
		String input;
		
		while(!game.checkGameOver()){
			printLevel(game.getCurrentLevel());
			System.out.print("Direction[wasd]: ");
			input = userInput.getUserInput();
			game.play2(input);
		}
	}
}