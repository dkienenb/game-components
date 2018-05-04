package org.gamenet.dkienenb.runnableclasses;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class DrawingSetup {

	public static Canvas setup(Stage primaryStage, double canvasWidth, double canvasHeight, RunnableClassWithGraphics handlerSetupClass, String title) {
			primaryStage = new Stage();
			primaryStage.setTitle(title);
			Group root = new Group();
			Canvas canvas = new Canvas(canvasWidth, canvasHeight);
			handlerSetupClass.canvasSetup(canvas);
			root.getChildren().add(canvas);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			return canvas;
	}

}
