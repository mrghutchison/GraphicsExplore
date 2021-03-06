package cemc.javafx.workshop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DriverGUI extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		final int NUM_SIDES = 6;
		Die d = new Die(NUM_SIDES); // Create a standard 6 sided Die	
		
		// Create GUI components
		Font font = new Font("Arial",24);
		Font fontBold = Font.font("Arial", FontWeight.BOLD, 24);
		
		Label title = new Label("DICE Roller");
		title.setFont(fontBold);
		
		Button btnRoll = new Button("ROLL DICE");
		btnRoll.setFont(font);
		
		Label result = new Label("Result");
		result.setFont(fontBold);
		
		Label lblValue = new Label();
		lblValue.setFont(font);
		lblValue.setAlignment(Pos.CENTER);
		
		// Create container node and add controls
		VBox dieHolder = new VBox (20);
		dieHolder.getChildren().add(title);
		dieHolder.getChildren().addAll(btnRoll, result, lblValue);
		dieHolder.setAlignment(Pos.CENTER);
		
		// Create a scene, set the root Node and optional the dimensions
		Scene scene = new Scene(dieHolder, 300, 300);
		
		// Set the stage with the scene
		stage.setScene(scene);
		stage.show();
		
		// Setup button action with Images and an ImageView object
		btnRoll.setOnAction( e -> lblValue.setText(String.valueOf(d.roll())));
	}

	public static void main(String[] args) {
		// Call the JavaFX graphics interface
		launch(args);
	}
}
