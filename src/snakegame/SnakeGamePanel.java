package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


import javax.swing.JPanel;
import javax.swing.Timer; //not util.Timer

public class SnakeGamePanel extends JPanel implements ActionListener {
	static final int screenWidth = 650; 
	static final int screenHeight = 650; 
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
		random = new Random();
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newBall();
		running = true;
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {  /// Method for the board
		for (int i=0; i<screenHeight/unitSize; i++) {
			g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
			g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
		}
		g.setColor(Color.green);
		g.fillOval(ballPositionX, ballPositionY, unitSize, unitSize);
		for (int i = 0; i<bodyParts; i++) {
			if (i==0) {
				g.setColor(Color.red);
				g.fillRect(x[i], y[i], unitSize, unitSize);
			} else {
				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], unitSize, unitSize);
			}
		}
	}
	public void newBall() { /// Method to generate new balls
		ballPositionX = random.nextInt((int)(screenWidth/unitSize))*unitSize;
		ballPositionY = random.nextInt((int)(screenHeight/unitSize))*unitSize;
	}
	public void move() { /// Method for moving snake
		
		for(int i = bodyParts; i>0 ;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch (direction) {
		case 'U': 
			y[0] = y[0] - unitSize;
			break;
		case 'D': 
			y[0] = y[0] + unitSize;
			break;
		case 'L': 
			x[0] = x[0] - unitSize;
			break;
		case 'R': 
			x[0] = x[0] + unitSize;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + direction);
		}
	}
	public void checkBall() {
		
	}
	public void checkCollision() {
		//Checks if head collides with body
		for(int i = bodyParts; i>0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		//Checks if head collides with the left border
		if(x[0] < 0) {
			running = false;
		}
		//Checks if head collides with the right border
		if(x[0] > screenWidth) {
			running = false;
		}
		//Checks if head collides with the top border
		if(y[0] < 0) {
			running = false;
		}
		//Checks if head collides with the down border
		if(y[0] > screenHeight) {
			running = false;
		}
		if (!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkBall();
			checkCollision();
		}
		repaint();
		
	}
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT: 
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT: 
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP: 
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN: 
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + e.getKeyCode());
			}
		}
	}

}
