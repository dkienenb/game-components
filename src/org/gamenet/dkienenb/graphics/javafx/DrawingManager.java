package org.gamenet.dkienenb.graphics.javafx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;

public class DrawingManager {

	private Canvas canvas;
	private List<Drawable> drawables = new ArrayList<>();

	public DrawingManager(Canvas canvas) {
		this.canvas = canvas;
	}

	public void draw(Drawable drawable){
		drawable.draw(canvas);
	}

	public void addDrawable(Drawable drawable) {
		drawables.add(drawable);
	}

	public void drawAll() {
		drawables.stream().forEach(drawable -> draw(drawable));
	}
}
