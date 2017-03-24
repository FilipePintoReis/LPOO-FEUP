package dkeep.gui;

import java.awt.Graphics;
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
	
	public Game getGame(){ return game; }
	
	public SpritePanel(int imageSize){
		addKeyListener(this);
		this.imageSize = imageSize;
		this.game = new Game();
		try{
			hero 		   = ImageIO.read(new File("src/dkeep/gui/hero.png"));
			ogre 		   = ImageIO.read(new File("src/dkeep/gui/ogre.png"));
			guard 		   = ImageIO.read(new File("src/dkeep/gui/guard.png"));
			sleepingGuard  = ImageIO.read(new File("src/dkeep/gui/sleepingGuard.png"));
			key 		   = ImageIO.read(new File("src/dkeep/gui/key.png"));
			lever 		   = ImageIO.read(new File("src/dkeep/gui/lever.png"));
			activatedLever = ImageIO.read(new File("src/dkeep/gui/activatedLever.png"));
			closedDoor 	   = ImageIO.read(new File("src/dkeep/gui/closedDoor.png"));
			openedDoor     = ImageIO.read(new File("src/dkeep/gui/openedDoor.png"));
			wall 		   = ImageIO.read(new File("src/dkeep/gui/wall.png"));
			floor		   = ImageIO.read(new File("src/dkeep/gui/floor.png"));
			club 		   = ImageIO.read(new File("src/dkeep/gui/club.png"));
			mace 		   = ImageIO.read(new File("src/dkeep/gui/mace.png"));
			ogreOnKey 	   = ImageIO.read(new File("src/dkeep/gui/ogreOnKey.png"));
			clubOnKey 	   = ImageIO.read(new File("src/dkeep/gui/clubOnKey.png"));
			maceOnKey 	   = ImageIO.read(new File("src/dkeep/gui/maceOnKey.png"));
			heroWithClub   = ImageIO.read(new File("src/dkeep/gui/heroWithClub.png"));
			heroWithKey    = ImageIO.read(new File("src/dkeep/gui/heroWithKey.png"));
			stunnedOgre    = ImageIO.read(new File("src/dkeep/gui/stunnedOgre.png"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i=0; i < game.getCurrentLevel().getMap().getEmptyMap().length; i++)
			for(int j=0; j < game.getCurrentLevel().getMap().getEmptyMap()[0].length; j++){
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
				
		for(int i=0; i < game.getCurrentLevel().getMap().getCurrentMap().length; i++)
			for(int j=0; j < game.getCurrentLevel().getMap().getCurrentMap()[0].length; j++){
					
				switch(game.getCurrentLevel().getMap().getCurrentMap()[i][j]){
					
				case 'H':
					g.drawImage(hero, i * imageSize, j * imageSize, this);
					break;
					
				case 'K':
					g.drawImage(heroWithKey, i * imageSize, j * imageSize, this);
					break;
					
				case 'A':
					g.drawImage(heroWithClub, i * imageSize, j * imageSize, this);
					break;
					
				case '8':
					g.drawImage(stunnedOgre, i * imageSize, j * imageSize, this);
					break;
					
				case '$':
					g.drawImage(ogreOnKey, i * imageSize, j * imageSize, this);
					break;
				
				
				}
					
			}
	}
	
	
}
