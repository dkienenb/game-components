package org.gamenet.dkienenb.runnableclasses;

import org.gamenet.javafx.engine.Main;
import org.gamenet.javafx.engine.Renderer;

import javafx.stage.Stage;

public abstract class RunnableClassWithGraphics {

	protected abstract void initialize(Stage primaryStage);
	protected abstract void loop();
	protected abstract int getFPS();
	protected abstract String getWindowTitle();
	protected abstract double getWindowWidth();
	protected abstract double getWindowHeight();
	protected abstract void startup();

	private final Renderer renderer = createRenderer(getFPS(), getWindowTitle(), getWindowWidth(), getWindowHeight()); 

	private Renderer createRenderer(int fps, String windowTitle, double windowWidth, double windowHeight) {
		Renderer renderer = new Renderer(fps, windowTitle, windowWidth, windowHeight) {
			@Override
			public void initialize(Stage primaryStage) {
				super.initialize(primaryStage);
			}

			@Override
			public void onKeyFrameStarted() {
				startup();
			}
			
			@Override
			public void onKeyFrameFinished() {
				loop();
			}
		};
		return renderer;
	}

	protected void start(String[] args) {
		Main.main(renderer, args);
	}

}
