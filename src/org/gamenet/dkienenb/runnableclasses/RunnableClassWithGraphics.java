package org.gamenet.dkienenb.runnableclasses;

import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public abstract class RunnableClassWithGraphics extends RunnableClass {

	private static final String DEFAULT_TITLE = "Runnable Class with graphics";
	private static final double DEFAULT_CANVAS_HEIGHT = 900;
	private static final double DEFAULT_CANVAS_WIDTH = 1600;
	private Canvas canvas;

	@Override
	public void start(Stage primaryStage) throws Exception {
		canvas = DrawingSetup.setup(primaryStage, getCanvasWidth(), getCanvasHeight(), this, getTitle());
		super.start(primaryStage);
	}

	protected String getTitle() {
		return DEFAULT_TITLE;
	}

	public double getCanvasWidth() {
		return DEFAULT_CANVAS_WIDTH;
	}

	public double getCanvasHeight() {
		return DEFAULT_CANVAS_HEIGHT;
	}

	protected abstract void canvasSetup(Canvas canvas);

	@Override
	public boolean loop() {
		graphicsLoop(canvas);
		return logicLoop();
	}

	protected abstract void graphicsLoop(Canvas canvas);
	protected abstract boolean logicLoop();

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
