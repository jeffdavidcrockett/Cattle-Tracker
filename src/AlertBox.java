import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AlertBox 
{
	public static void display(String title, String message)
	{
		Stage alertWindow = new Stage();
		
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(350);
		alertWindow.setMinHeight(150);
		
		Label label = new Label();
		label.setText(message);
		label.setStyle("-fx-font-size: 15pt;");
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setMinSize(80, 30);
		noButton.setMinSize(80, 30);
		
		yesButton.setStyle("-fx-font-size: 12pt;");
		noButton.setStyle("-fx-font-size: 12pt;");
		
		HBox yesNoButtons = new HBox(10);
		yesNoButtons.getChildren().addAll(yesButton, noButton);
		yesNoButtons.setAlignment(Pos.CENTER);
		
		yesButton.setOnAction(e -> alertWindow.close());
		noButton.setOnAction(e -> alertWindow.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesNoButtons);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();
	}
}
