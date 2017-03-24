package dkeep.test;

import dkeep.logic.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ActualGameClassTest {

	
	
	
	@Test
	public void testStringMap(){
		Game game = new Game();
		String stringMap = game.getCurrentMapString();
		String test = "X X X X X X X X X X"
			  +"\n" + "X H     I   X   G X" 
			  +"\n" + "X X X   X X X     X" 
			  +"\n" + "X   I   I   X     X"
			  +"\n" + "X X X   X X X     X"
			  +"\n" + "I                 X"
			  +"\n" + "I                 X"
			  +"\n" + "X X X   X X X X   X"
			  +"\n" + "X   I   I   X k   X"
			  +"\n" + "X X X X X X X X X X";
		assertEquals(test,stringMap);
	}
}
