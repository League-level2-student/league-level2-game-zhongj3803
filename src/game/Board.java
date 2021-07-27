package game;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Board extends GameObject {
	int speed;
	BufferedImage image;

	Board(int x, int y, int width, int height) {
		super(x-width/2, y, width, height);
		speed = 10;
		loadImage("board.PNG");
	}

	void left() {
		x -= speed;
	}

	void right() {
		x += speed;
	}
	void loadImage(String imageFile) {
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));

		} catch (Exception e) {

		}

	}
}
