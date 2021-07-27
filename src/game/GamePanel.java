package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseMotionListener, ActionListener {
	int score = 0;
	Ball ball = new Ball(250, 250, 50, 50);
	Board board = new Board(250, 500, 70, 10);
	Random ran = new Random();
	Timer frameDraw;

	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void checkCollision() {
		if (ball.x < 0 || ball.x > 500) {
			ball.speedx = -ball.speedx;
		}
		if (ball.y < 0) {
			ball.speedy = -ball.speedy;
		}
		if (ball.collisionBox.intersects(board.collisionBox)) {
			ball.speedx = ball.posOrNeg[ran.nextInt(2)] * (ran.nextInt(3) + 5);
			ball.speedy = -(ran.nextInt(3) + 5);
			score++;
		}
	}

	void update() {
		ball.update();
		board.update();
		checkCollision();
		if (ball.y > 600) {
			JOptionPane.showMessageDialog(null, "Game over! Your score was: " + score);
			System.exit(0);
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, BallGame.WIDTH, BallGame.HEIGHT);
		g.drawImage(board.image, board.x, board.y, board.width, board.height, null);
		g.drawImage(ball.image, ball.x, ball.y, ball.width, ball.height, null);
		g.setColor(Color.white);
		g.drawString("score: " + score, 50, 50);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		board.x = e.getX();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		update();
		repaint();
	}
}
