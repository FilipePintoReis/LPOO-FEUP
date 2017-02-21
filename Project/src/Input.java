package userinteraction;

import java.util.Scanner;

public class Input {
	Scanner sc;
	String input;

	public Input() {
		sc = new Scanner(System.in);
		input = null;
	}

	public Scanner getScanner() {
		return sc;
	}

	public String getInput() {
		return input;
	}

	public String getUserInput() {
		input = sc.nextLine();
		return input;
	}

}
