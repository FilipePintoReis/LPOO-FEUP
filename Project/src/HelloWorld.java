import java.util.Scanner;

public class HelloWorld {

	
	public static char getUserInput(){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		return input.charAt(0);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		char input;
		
		
		
		while(!game.isOver()){
			input = getUserInput();
			game.moveHero(input);
			game.getMap().printMap();
		}
	}

}
