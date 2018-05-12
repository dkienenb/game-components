package org.gamenet.dkienenb.runnableclasses;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * This class is for making classes that run easily.
 */
public abstract class RunnableClass extends Application {

	private Stage primaryStage;

	private boolean running = true;

	protected void run() throws Exception {
		setup();
		while (running) {
			running = loop();
		}
		shutdown();
	}

	protected abstract void setup();
	protected abstract boolean loop();
	protected abstract void shutdown();
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Platform.exit();
		}
	}

}
