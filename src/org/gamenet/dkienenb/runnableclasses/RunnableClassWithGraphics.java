package org.gamenet.dkienenb.runnableclasses;

import org.gamenet.javafx.engine.Main;
import org.gamenet.javafx.engine.Renderer;

import javafx.stage.Stage;

public abstract class RunnableClassWithGraphics {

	protected abstract void initialiaze(Stage primaryStage);
	protected abstract void loop();
	protected void startup() {}

	private final Renderer renderer; 

	public RunnableClassWithGraphics(String[] args, int fps, String windowTitle, double windowWidth, double windowHeight) {
		
		renderer = new Renderer(fps, windowTitle, windowWidth, windowHeight) {
			@Override
			public void initialize(Stage primaryStage) {
				initialiaze(primaryStage);
			}

			public void onKeyFrameStarted() {
				startup();
			}
			
			@Override
			public void onKeyFrameFinished() {
				loop();
			}
		};
		
		Main.main(renderer, args);
	}
}
