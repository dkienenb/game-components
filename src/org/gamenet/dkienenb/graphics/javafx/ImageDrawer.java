package org.gamenet.dkienenb.graphics.javafx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public final class ImageDrawer {

	@SuppressWarnings("static-method")
	public void drawImage(Canvas canvas, Position position, Image image) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, position.getX() - (image.getWidth() / 2), position.getY() - (image.getHeight() / 2));
 	}
	
}
