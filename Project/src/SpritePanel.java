package dkeep.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dkeep.logic.Game;
import dkeep.logic.Level;
import dkeep.logic.Hero;
import dkeep.logic.Guard;
import dkeep.logic.Lever;
import dkeep.logic.Key;

public class SpritePanel extends JPanel implements KeyListener {
	private Game game;
	private int imageSize;
	private BufferedImage hero;
	private BufferedImage ogre;
	private BufferedImage guard;
	private BufferedImage sleepingGuard;
	private BufferedImage key;
	private BufferedImage lever;
	private BufferedImage activatedLever;
	private BufferedImage closedDoor;
	private BufferedImage openedDoor;
	private BufferedImage wall;
	private BufferedImage floor;
	private BufferedImage club;
	private BufferedImage mace;
	private BufferedImage ogreOnKey;
	private BufferedImage clubOnKey;
	private BufferedImage maceOnKey;
	private BufferedImage heroWithClub;
	private BufferedImage heroWithKey;
	private BufferedImage stunnedOgre;
	
	public void setGame(Game game){ this.game = game; }
	public Game getGame(){ return game; }
	
	public SpritePanel(int imageSize){
		addKeyListener(this);
		this.imageSize = imageSize;
		this.game = new Game();
		try{
			hero 		   = ImageIO.read(new File("src/dkeep/gui/sprites/hero.png"));
			ogre 		   = ImageIO.read(new File("src/dkeep/gui/sprites/ogre.png"));
			guard 		   = ImageIO.read(new File("src/dkeep/gui/sprites/guard.png"));
			//sleepingGuard  = ImageIO.read(new File("src/dkeep/gui/sprites/sleepingGuard.png"));
			key 		   = ImageIO.read(new File("src/dkeep/gui/sprites/key.png"));
			lever 		   = ImageIO.read(new File("src/dkeep/gui/sprites/lever.png"));
			//activatedLever = ImageIO.read(new File("src/dkeep/gui/activatedLever.png"));
			closedDoor 	   = ImageIO.read(new File("src/dkeep/gui/sprites/closedDoor.png"));
			openedDoor     = ImageIO.read(new File("src/dkeep/gui/sprites/openedDoor.png"));
			wall 		   = ImageIO.read(new File("src/dkeep/gui/sprites/wall.png"));
			floor		   = ImageIO.read(new File("src/dkeep/gui/sprites/floor.png"));
			club 		   = ImageIO.read(new File("src/dkeep/gui/sprites/club.png"));
			mace 		   = ImageIO.read(new File("src/dkeep/gui/sprites/mace.png"));
			//ogreOnKey 	   = ImageIO.read(new File("src/dkeep/gui/sprites/ogreOnKey.png"));
			//clubOnKey 	   = ImageIO.read(new File("src/dkeep/gui/sprites/clubOnKey.png"));
			//maceOnKey 	   = ImageIO.read(new File("src/dkeep/gui/sprites/maceOnKey.png"));
			//heroWithClub   = ImageIO.read(new File("src/dkeep/gui/sprites/heroWithClub.png"));
			//heroWithKey    = ImageIO.read(new File("src/dkeep/gui/sprites/heroWithKey.png"));
			//stunnedOgre    = ImageIO.read(new File("src/dkeep/gui/sprites/stunnedOgre.png"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(game.getLevels().size() == 0)
			return;
		
		for(int i=0; i < game.getCurrentLevel().getMap().getEmptyMap().length; i++)
			for(int j=0; j < game.getCurrentLevel().getMap().getEmptyMap()[0].length; j++)
					//print empty map
					//print cenas por cima e tal
				switch(game.getCurrentLevel().getMap().getEmptyMap()[i][j]){
				
				case 'X':
					g.drawImage(wall,  i * imageSize, j * imageSize, this);
					break;
					
				case 'I':
					g.drawImage(closedDoor, i * imageSize, j * imageSize, this);
					break;
					
				case 'S':
					g.drawImage(openedDoor, i * imageSize, j * imageSize, this);
					break;
					
				case ' ':
					g.drawImage(floor, i * imageSize, j * imageSize, this);
					break;
					
				default: break;
				}
				
		for(int i1=0; i1 < game.getCurrentLevel().getMap().getCurrentMap().length; i1++)
			for(int j1=0; j1 < game.getCurrentLevel().getMap().getCurrentMap()[0].length; j1++){
					
				switch(game.getCurrentLevel().getMap().getCurrentMap()[i1][j1]){
					
				case 'H':
					g.drawImage(hero, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case 'K':
					g.drawImage(hero, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case 'A':
					g.drawImage(hero, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case '8':
					g.drawImage(ogre, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case '$':
					g.drawImage(ogre, i1 * imageSize, j1 * imageSize, this);
					break;
				
				case 'O':
					g.drawImage(ogre, i1 * imageSize, j1 * imageSize, this);
					break;
				
				case 'G':
					g.drawImage(guard,  i1 * imageSize, j1 * imageSize, this);
					break;
					
				case 'g':
					g.drawImage(guard, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case 'k':
					g.drawImage(key, i1 * imageSize, j1 * imageSize, this);
					break;
					
				case '*':
					g.drawImage(mace, i1 * imageSize, j1 * imageSize, this);
					break;
				
				default: break;
				}	
			}
	}
	
	public void inputHandler(final int s1, final int s2) { }
	
	@Override
	public void keyPressed(KeyEvent e){
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0){ }
	
	@Override
	public void keyTyped(KeyEvent arg0){ }
	
}
