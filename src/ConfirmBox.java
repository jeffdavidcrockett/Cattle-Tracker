import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class ConfirmBox {
	static boolean answer;
	
	public static boolean display(String title, String message1, String message2) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label firstMessage = new Label();
		firstMessage.setText(message1);
		
		Label secondMessage = new Label();
		secondMessage.setText(message2);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		HBox yesNoButtons = new HBox(10);
		yesNoButtons.getChildren().addAll(yesButton, noButton);
		yesNoButtons.setAlignment(Pos.CENTER);
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(firstMessage, secondMessage, yesNoButtons);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}