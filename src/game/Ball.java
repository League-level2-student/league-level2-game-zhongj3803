package game;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Ball extends GameObject {
	int speedx;
	int speedy;
	BufferedImage image;
	Random ran = new Random();
	int[] posOrNeg = { -1, 1 };

	Ball(int x, int y, int width, int height) {
		super(x-width/2, y-height/2, width, height);
		speedx = posOrNeg[ran.nextInt(2)] * (ran.nextInt(3) + 5);
		speedy = posOrNeg[ran.nextInt(2)] * (ran.nextInt(3) + 5);
		loadImage("ball.PNG");

	}

	void update() {
		x += speedx;
		y += speedy;
		super.update();
	}

	void loadImage(String imageFile) {
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));

		} catch (Exception e) {

		}

	}
}
