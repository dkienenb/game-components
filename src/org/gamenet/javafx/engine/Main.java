package org.gamenet.javafx.engine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main driver of the game.
 */
public class Main extends Application {
   
	private static Renderer gameWorld;

	/**
     * @param args the command line arguments
     */
    public static void main(Renderer renderer, String[] args) {
    	gameWorld = renderer;
    	
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {


    	// setup title, scene, stats, controls, and actors.
        gameWorld.initializeWindow(primaryStage);
        gameWorld.initialize(primaryStage);

        // kick off the game loop
        gameWorld.beginGameLoop();

        // display window
        primaryStage.show();       
    }

}

