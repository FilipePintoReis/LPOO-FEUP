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
		String input, gameOverMessage = "";
		
		while(!game.checkGameOver()){
			printLevel(game.getCurrentLevel());
			System.out.print("Direction[wasd]: ");
			input = userInput.getUserInput();
			game.play(input);
		}
		printLevel(game.getLevels().get(game.getCurrentLevelIndex()-1));
		if(game.checkHeroCaptured())
			System.out.print("You have lost, but you will learn from your mistakes, and soon, you will destroy the one ring.");
		else
			System.out.print("It's all ogre now. Good job");
	}
	
	
}