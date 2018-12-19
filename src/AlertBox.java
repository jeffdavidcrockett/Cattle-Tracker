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
		
		Label messageLabel = new Label();
		messageLabel.setText(message);
		messageLabel.setStyle("-fx-font-size: 15pt;");
		
		Button acknowledgeButton = new Button("Acknowledge");
		
		acknowledgeButton.setMinSize(80, 30);
		
		acknowledgeButton.setStyle("-fx-font-size: 12pt;");
		
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(acknowledgeButton);
		buttons.setAlignment(Pos.CENTER);
		
		acknowledgeButton.setOnAction(e -> alertWindow.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(messageLabel, buttons);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();
	}
}
