package hust.soict.hedspi.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class javafxCounter extends Application {
	private TextField tfCount;
	private Button btnCount;
	private int count = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// allocate controls
		tfCount = new TextField("0");
		tfCount.setEditable(false);
		btnCount = new Button("Count");
		// register event handler using Lambda Expression (JDK 8)
		btnCount.setOnAction(evt->tfCount.setText(++count + ""));
		
		// create a scene graph of node rooted at a FlowPane
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(15, 12, 15, 12)); // top, right, bottom, left
		flow.setVgap(10); // vertical gap between nodes in pixels
		
		flow.setHgap(10); // Horizontal gap between nodes in pixels
		flow.setAlignment(Pos.CENTER); // alignment
		flow.getChildren().addAll(new Label("Count: "), tfCount, btnCount);
		
		// setup scene and stage
		primaryStage.setScene(new Scene(flow, 400, 80));
		primaryStage.setTitle("JavaFX counter");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
