package game;

import javax.swing.JFrame;

public class BallGame {
public static int WIDTH=500;
public static int HEIGHT=600;
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();

	BallGame() {
		frame.add(panel);
		frame.addMouseMotionListener(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		BallGame ballgame = new BallGame();
	}
}
