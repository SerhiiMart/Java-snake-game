package snakegame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;

import javax.swing.JPanel;

public class SnakeGamePanel extends JPanel implements ActionListener {
	static final int screenWidth = 600; 
	static final int screenHeight = 600; 
	static final int unitSize = 25;
	static final int gameUnits = (screenWidth * screenHeight)/unitSize;
	static final int delay = 75; // higher the number, slower the game
	final int x[] = new int[gameUnits];
	final int y[] = new int[gameUnits];
	int bodyParts = 5;
	int ballsEaten;
	int ballPositionX;
	int ballPositionY;
	char direction = 'D';
	boolean running = false;
	Timer timer;
	Random random;
	
	SnakeGamePanel(){
		
	}
	public void startGame() {
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	public void draw(Graphics g) {
		
	}
	public void move() {
		
	}
	public void checkBall() {
		
	}
	public void checkCollision() {
		
	}
	public void gameOver(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}

}
