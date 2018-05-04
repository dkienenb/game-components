package org.gamenet.javafx.engine;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class Renderer {

	private int fps;
	private String windowTitle;
	private double gameWindowWidth;
	private double gameWindowHeight;
	
	private Scene primaryScene;
	private Group primarySceneRoot;

    public Renderer(int fps, String windowTitle, double d, double e) {
    	this.fps = fps;
    	this.windowTitle = windowTitle;
        this.gameWindowWidth = d;
        this.gameWindowHeight = e;
    }

    public void initializeWindow(Stage primaryStage) {
    	
    	primarySceneRoot = new Group();
    	
    	primaryScene = new Scene(primarySceneRoot, gameWindowWidth, gameWindowHeight);
    	
        // Sets the window title
        primaryStage.setTitle(windowTitle);
        primaryStage.setScene(primaryScene);
    }

	protected Scene getGameWindow() {
		return primaryScene;
	}
    
	public void beginGameLoop() {
        final Duration duration = Duration.millis(1000 / (float) fps);
		EventHandler<ActionEvent> onFinishedEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				onKeyFrameFinished();
			}

		};
		KeyFrame keyframe = new KeyFrame(duration, onFinishedEvent);
        
        Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.getKeyFrames().add(keyframe);
		
		
		onKeyFrameStarted();
		
		timeline.play();
	}

	/**
	 * Optional method to configure rendering
	 * @param primaryStage
	 */
	public void initialize(Stage primaryStage) {
	}

	public abstract void onKeyFrameStarted();

	/**
	 * Called after every frame update
	 */
	public abstract void onKeyFrameFinished();

	public Group getPrimarySceneRoot() {
		return primarySceneRoot;
	}
	
}
