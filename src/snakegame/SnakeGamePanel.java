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
	public void draw(Graphics g) {
		for (int i=0; i<screenHeight/unitSize; i++) {
			g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
			g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
		}
		g.setColor(Color.green);
		g.fillOval(ballPositionX, ballPositionY, unitSize, unitSize);
	}
	public void newBall() {
		ballPositionX = random.nextInt((int)(screenWidth/unitSize))*unitSize;
		ballPositionY = random.nextInt((int)(screenHeight/unitSize))*unitSize;
	}
	public void move() {
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
