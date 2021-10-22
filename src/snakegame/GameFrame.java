package snakegame;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GameFrame(){
		// SnakeGamePanel panel = new SnakeGamePanel(); 
		// this.add(panel); //same thing
		this.add(new SnakeGamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
