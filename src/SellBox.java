import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.geometry.*;


public class SellBox {
	static boolean answer;
	static ArrayList<Boolean> boolList = new ArrayList<Boolean>();
	static ArrayList<String> stringList = new ArrayList<String>();
	static HashMap<String, ArrayList> sellData = new HashMap<String, ArrayList>();
	
	public static HashMap<String, ArrayList> display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Sell Cow");
		window.setMinWidth(300);
		window.setMinHeight(150);
		
		Label soldForPriceLabel = new Label("Price sold for: $");
		Label soldToLabel = new Label("Sold to: ");
		
		soldForPriceLabel.setStyle("-fx-font-size: 12pt;");
		soldToLabel.setStyle("-fx-font-size: 12pt;");
		
		TextField soldForField = new TextField();
		TextField soldToField = new TextField();
		
		Button sellButton = new Button("Sell");
		Button cancelButton = new Button("Cancel");
		
		HBox sellCancelButtons = new HBox(10);
		sellCancelButtons.getChildren().addAll(sellButton, cancelButton);
		sellCancelButtons.setAlignment(Pos.CENTER);
		
		VBox labelVBox = new VBox(10);
		labelVBox.getChildren().addAll(soldForPriceLabel, soldToLabel);
		labelVBox.setAlignment(Pos.CENTER_RIGHT);
		
		VBox fieldVBox = new VBox(10);
		fieldVBox.getChildren().addAll(soldForField, soldToField);
		fieldVBox.setAlignment(Pos.CENTER);
		
		HBox mainHBox = new HBox();
		mainHBox.getChildren().addAll(labelVBox, fieldVBox);
		
		sellButton.setOnAction(e -> {
			if (soldForField.getText().trim().isEmpty() || soldToField.getText().trim().isEmpty()) {
				AlertBox.display("Attention!", "Please fill out all fields");
			}
			else {
				answer = true;
				
				sellData.put("strings", stringList);
				sellData.put("bools", boolList);
				
				sellData.get("strings").add(soldForField);
				sellData.get("strings").add(soldToField);
				sellData.get("bools").add(answer);
				
				window.close();
			}
		});
		
		cancelButton.setOnAction(e -> {
			sellData = null;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(mainHBox, sellCancelButtons);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return sellData;
	}
}