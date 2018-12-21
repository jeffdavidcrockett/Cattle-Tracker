import java.util.*;
import Cows.Bull;
import Cows.Heffer;
import Data.DBConnect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.Group;


public class SellCow 
{
	public BorderPane display(Scene dashboardScene, Stage window, DBConnect db)
	{
		// Right pane ****************************************************************************
		VBox rightPane = new VBox(20);
		rightPane.setMinWidth(300);
		rightPane.setStyle("-fx-background-color: #1B4040;");
		rightPane.setAlignment(Pos.CENTER);
				
		Label navigationLabel = new Label("Navigation");
		navigationLabel.setStyle("-fx-text-fill: white; -fx-font-size: 40pt;");
				
		Button dashButton = new Button("Dashboard");
		Button reportsButton = new Button("Financial Reports");
		Button addCowButton = new Button("Add Cow to Herd");
		Button addExpenseButton = new Button("Add General Expense");
				
		dashButton.setStyle("-fx-font-size: 15pt;");
		reportsButton.setStyle("-fx-font-size: 15pt;");
		addCowButton.setStyle("-fx-font-size: 15pt;");
		addExpenseButton.setStyle("-fx-font-size: 15pt;");
				
		dashButton.setMaxWidth(Double.MAX_VALUE);
		reportsButton.setMaxWidth(Double.MAX_VALUE);
		addCowButton.setMaxWidth(Double.MAX_VALUE);
		addExpenseButton.setMaxWidth(Double.MAX_VALUE);
		
		rightPane.getChildren().addAll(navigationLabel, dashButton, reportsButton, addCowButton, addExpenseButton);
		
		// Center pane *********************************************************************************
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		Label sellCowLabel = new Label("  Sell Cow");
		Label lookupLabel = new Label("Lookup Cow by ID: ");
		Label idLabel = new Label("ID: ");
		Label idDisplayLabel = new Label();
		Label genderLabel = new Label("Gender: ");
		Label genderDisplayLabel = new Label();
		Label breedLabel = new Label("Breed: ");
		Label breedDisplayLabel = new Label();
		Label birthdateLabel = new Label("Birthdate: ");
		Label birthdateDisplayLabel = new Label();
		Label datePurchasedLabel = new Label("Date Purchased: ");
		Label datePurchasedDisplayLabel = new Label();
		Label purchasedFromLabel = new Label("Purchased From: ");
		Label purchasedFromDisplayLabel = new Label();
		Label pricePaidLabel = new Label("Price Paid: ");
		Label pricePaidDisplayLabel = new Label();
		Label mothersIdLabel = new Label("Mothers ID: ");
		Label mothersIdDisplayLabel = new Label();
		Label fathersIdLabel = new Label("Fathers ID: ");
		Label fathersIdDisplayLabel = new Label();
		Label castratedLabel = new Label("Castrated: ");
		Label castratedDisplayLabel = new Label();
		Label blankLabel1 = new Label();
		Label blankLabel2 = new Label();
		Label blankLabel3 = new Label();
		Label blankLabel4 = new Label();
		Label blankLabel5 = new Label();
		Label blankLabel6 = new Label();
		Label blankLabel7 = new Label();
		Label blankLabel8 = new Label();
		Label blankLabel9 = new Label();
		Label blankLabel10 = new Label();
		Label blankLabel11 = new Label();
		Label blankLabel12 = new Label();
		Label blankLabel13 = new Label();
		Label blankLabel14 = new Label();
		Label blankLabel15 = new Label();

		
		sellCowLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: orange;");
		lookupLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		idLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		idDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		genderLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		genderDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		breedLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		breedDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		birthdateLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		birthdateDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		datePurchasedLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		datePurchasedDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		purchasedFromLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		purchasedFromDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		pricePaidLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		pricePaidDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		mothersIdLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		mothersIdDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		fathersIdLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		fathersIdDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		castratedLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		castratedDisplayLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: aqua;");
		
		
		TextField lookupField = new TextField();
		
		lookupField.setMaxWidth(200);
		
		Button lookupButton = new Button("Lookup");
		Button sellCowButton = new Button("Sell Cow");
		
		lookupButton.setStyle("-fx-font-size: 9pt;");
		sellCowButton.setStyle("-fx-font-size: 15pt;");

		HBox mainLabelBox = new HBox();
		mainLabelBox.getChildren().addAll(sellCowLabel);
		mainLabelBox.setAlignment(Pos.CENTER);
		
		HBox lookupBox = new HBox(5);
		lookupBox.getChildren().addAll(lookupLabel, lookupField, lookupButton);
		lookupBox.setAlignment(Pos.CENTER_LEFT);
		
		HBox idBox = new HBox();
		idBox.getChildren().addAll(idLabel, idDisplayLabel);
		
		HBox genderBox = new HBox();
		genderBox.getChildren().addAll(genderLabel, genderDisplayLabel);
		
		HBox breedBox = new HBox();
		breedBox.getChildren().addAll(breedLabel, breedDisplayLabel);
		
		HBox birthdateBox = new HBox();
		birthdateBox.getChildren().addAll(birthdateLabel, birthdateDisplayLabel);
		
		HBox datePurchasedBox = new HBox();
		datePurchasedBox.getChildren().addAll(datePurchasedLabel, datePurchasedDisplayLabel);
		
		HBox purchasedFromBox = new HBox();
		purchasedFromBox.getChildren().addAll(purchasedFromLabel, purchasedFromDisplayLabel);
		
		HBox pricePaidBox = new HBox();
		pricePaidBox.getChildren().addAll(pricePaidLabel, pricePaidDisplayLabel);
		
		HBox mothersIdBox = new HBox();
		mothersIdBox.getChildren().addAll(mothersIdLabel, mothersIdDisplayLabel);
		
		HBox fathersIdBox = new HBox();
		fathersIdBox.getChildren().addAll(fathersIdLabel, fathersIdDisplayLabel);
		
		HBox castratedBox = new HBox();
		castratedBox.getChildren().addAll(castratedLabel, castratedDisplayLabel);
		
		VBox column0 = new VBox();
		column0.getChildren().addAll(blankLabel1, blankLabel2, idBox, blankLabel3,  genderBox, blankLabel4,
				breedBox, blankLabel5, birthdateBox, blankLabel13, blankLabel14, sellCowButton);
		column0.setMinWidth(300);
		
		VBox column1 = new VBox();
		column1.getChildren().addAll(blankLabel6, blankLabel7, datePurchasedBox, blankLabel8, purchasedFromBox, 
				blankLabel9, pricePaidBox, blankLabel10, mothersIdBox);
		column1.setMinWidth(300);

		VBox column2 = new VBox();
		column2.getChildren().addAll(blankLabel11, blankLabel12, fathersIdBox, blankLabel15, castratedBox);
		column2.setMinWidth(300);

		HBox row1 = new HBox(100);
		row1.getChildren().addAll(column0, column1, column2);
		
		mainGrid.add(mainLabelBox, 0, 0);
		mainGrid.add(lookupBox, 0, 1);
		mainGrid.add(row1, 0, 2);
	
		// Main layout ******************************************************************************************
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		
		lookupButton.setOnAction(e -> {
			HashMap<String, ArrayList> cowData = new HashMap<String, ArrayList>();
			
			int id = Integer.parseInt(lookupField.getText());
			cowData = db.getRow(id);
			
			idDisplayLabel.setText(String.valueOf(cowData.get("integers").get(0)));
			genderDisplayLabel.setText(String.valueOf(cowData.get("strings").get(0)));
			breedDisplayLabel.setText(String.valueOf(cowData.get("strings").get(1)));
			birthdateDisplayLabel.setText(String.valueOf(cowData.get("strings").get(2)));
			datePurchasedDisplayLabel.setText(String.valueOf(cowData.get("strings").get(3)));
			purchasedFromDisplayLabel.setText(String.valueOf(cowData.get("strings").get(4)));
			pricePaidDisplayLabel.setText(String.valueOf(cowData.get("strings").get(5)));
			mothersIdDisplayLabel.setText(String.valueOf(cowData.get("integers").get(1)));
			fathersIdDisplayLabel.setText(String.valueOf(cowData.get("integers").get(2)));
			castratedDisplayLabel.setText(String.valueOf(cowData.get("strings").get(7)));
		});
		
		return mainLayout;
	}
}
