package hust.soict.hedspi.gui.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class javafxHelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button();
		btn.setText("Say, helllo World");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
