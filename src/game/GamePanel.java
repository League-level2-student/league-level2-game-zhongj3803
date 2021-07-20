package game;

import java.util.Random;

public class GamePanel {
	Ball ball = new Ball(250, 250, 50, 50);
	Board board = new Board(250, 500, 70, 10);
	Random ran = new Random();
	void checkCollision() {
		if (ball.collisionBox.intersects(board.collisionBox)) {
			ball.speedx=ball.posOrNeg[ran.nextInt(2)]*(ran.nextInt(5)+1);
			ball.speedy=ran.nextInt(5)+1;
		}
	}
	void update() {
		ball.update();
	}
}
