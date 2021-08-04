package game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		JOptionPane.showMessageDialog(null, "Use the mouse to move the board around. Make sure to hit the ball with the board when the ball comes down, and keep the ball bouncing around!");
		BallGame ballgame = new BallGame();
	}
}
