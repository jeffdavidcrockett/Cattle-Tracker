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




public class AddCowLayout 
{
	boolean result;
	boolean castrated;
	
	public BorderPane display(int width, int height, Scene dashboardScene, Stage window, DBConnect db)
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
		
		// Center pane *************************************************************************************
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		Label addCowLabel = new Label("               Add Cow");
		Label idInput = new Label("ID");
		Label breedInput = new Label("Breed");
		Label birthdateInput = new Label("Birthdate");
		Label datePurchasedInput = new Label("Date purchased");
		Label purchasedFromInput = new Label("Purchased from");
		Label pricePaidLabel = new Label("Price Paid");
		Label dollarSignLabel = new Label("$");
		Label vaccinatedInput = new Label("Vaccinated");
		Label mothersIdInput = new Label("Mother's ID");
		Label fathersIdInput = new Label("Father's ID");
		Label castratedLabel = new Label("Castrated");
		Label castYesLabel = new Label("Yes");
		Label castNoLabel = new Label("No");
		Label notesLabel = new Label("Notes");
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

		addCowLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: orange;");
		idInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		breedInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		birthdateInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		datePurchasedInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		purchasedFromInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		purchasedFromInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		vaccinatedInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		mothersIdInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		fathersIdInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		castratedLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		castYesLabel.setStyle("-fx-font-size: 10pt; -fx-text-fill: white;");
		castNoLabel.setStyle("-fx-font-size: 10pt; -fx-text-fill: white;");
		notesLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		pricePaidLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		dollarSignLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");

		
		Button submitCowButton = new Button("Submit Cow");
		submitCowButton.setMinSize(100, 80);
		submitCowButton.setStyle("-fx-font-size: 30pt;");

		TextField idField = new TextField();
		TextField purchasedFromField = new TextField();
		TextField pricePaidField = new TextField();
		TextField tempVaccineField = new TextField();
		TextField mothersIdField = new TextField();
		TextField fathersIdField = new TextField();
		TextField notesField = new TextField();
		
		idField.setMaxWidth(200);
		purchasedFromField.setMaxWidth(200);
		pricePaidField.setMaxWidth(200);
		tempVaccineField.setMaxWidth(200);
		mothersIdField.setMaxWidth(200);
		fathersIdField.setMaxWidth(200);
		notesField.setMinWidth(400);
		
		CheckBox male = new CheckBox("Male");
		CheckBox female = new CheckBox("Female");
		CheckBox castYes = new CheckBox();
		CheckBox castNo = new CheckBox();
		
		male.setStyle("-fx-text-fill: white; -fx-font-size: 15pt;");
		female.setStyle("-fx-text-fill: white; -fx-font-size: 15pt;");

		
		ObservableList<String> breedOptions = 
			    FXCollections.observableArrayList(
			        "Black Angus",
			        "Dairy");
		
		final ComboBox breedBox = new ComboBox(breedOptions);
		
		DateBox birthdateBoxes = new DateBox();
		ComboBox[] birthBoxes = birthdateBoxes.createDateBox();
		
		HBox priceBox = new HBox(5);
		priceBox.getChildren().addAll(dollarSignLabel, pricePaidField);
		priceBox.setAlignment(Pos.CENTER_LEFT);
		
		HBox idDateBox = new HBox(5);
		idDateBox.getChildren().addAll(birthBoxes[0], birthBoxes[1], birthBoxes[2]);
		
		HBox submitCowButtonBox = new HBox();
		submitCowButtonBox.getChildren().addAll(submitCowButton);
		submitCowButtonBox.setAlignment(Pos.BOTTOM_CENTER);
		
		HBox blankHBox1 = new HBox();
		blankHBox1.setMinHeight(100);
        
		HBox castYesBox = new HBox(5);
		HBox castNoBox = new HBox(5);
		
		castYesBox.getChildren().addAll(castYesLabel, castYes);
		castNoBox.getChildren().addAll(castNoLabel, castNo);
		
		HBox castratedOptions = new HBox(20);
		castratedOptions.getChildren().addAll(castYesBox, castNoBox);
		
        HBox addCowLabelBox = new HBox();
		addCowLabelBox.getChildren().addAll(addCowLabel);
		addCowLabelBox.setAlignment(Pos.CENTER);
		addCowLabelBox.setStyle("-fx-background-color: #1D1E1E;");
		
		DateBox datePurchasedBoxes = new DateBox();
		ComboBox[] boxes = datePurchasedBoxes.createDateBox();
		
		HBox datePurchasedDate = new HBox(5);
		datePurchasedDate.getChildren().addAll(boxes[0], boxes[1], boxes[2]);
		
		HBox row1 = new HBox(80);
		VBox column0 = new VBox();
		VBox column1 = new VBox();
		VBox column2 = new VBox();
		
		column0.getChildren().addAll(male, blankLabel1, female, blankLabel2,
				idInput, idField, blankLabel3, breedInput, breedBox, blankLabel4, birthdateInput, idDateBox);
		
		column1.getChildren().addAll(datePurchasedInput, datePurchasedDate, blankLabel5, 
				purchasedFromInput, purchasedFromField, blankLabel10, pricePaidLabel, priceBox, 
				blankLabel6, vaccinatedInput, tempVaccineField);
		
		column2.getChildren().addAll(mothersIdInput, mothersIdField, blankLabel7, fathersIdInput, fathersIdField,
				blankLabel8, castratedLabel, castratedOptions, blankLabel9, notesLabel, notesField);
		
		
		row1.getChildren().addAll(column0, column1, column2);
		
		mainGrid.add(addCowLabelBox, 0, 0);
		mainGrid.add(row1, 0, 1);
		mainGrid.add(blankHBox1, 0, 2);
		mainGrid.add(submitCowButtonBox, 0, 3);
		
		submitCowButton.setOnAction(e -> {
			if (male.isSelected() == true && female.isSelected() == true || castYes.isSelected() == true && castNo.isSelected() == true)
			{
				if (male.isSelected() == true && female.isSelected() == true) 
				{
					AlertBox.display("Attention!", "Please check only male or female. Both are currently selected.");
				}
				else if (castYes.isSelected() == true && castNo.isSelected() == true)
				{
					AlertBox.display("Attention!", "Both castrated options are selected. Please select only one.");
				}
			}
			else
			{
				result = ConfirmBox.display("Cow Submission","Any unfilled parameters will be defaulted to 'Uknown'.", 
						"Are you sure you would like to submit this cow?");
			}
			if (male.isSelected() == false && female.isSelected() == false)
			{
				AlertBox.display("Attention!", "Please select either male or female.");
			}
			else if (result == true && male.isSelected() == true || female.isSelected() == true)
			{
				int cowId = Integer.parseInt(idField.getText());
				String cowBreed = (String) breedBox.getValue();
				String birthdate = (String) birthBoxes[0].getValue() + '-' + (String) birthBoxes[1].getValue() + 
						'-' + (String) birthBoxes[2].getValue();
				String datePurchased = (String) boxes[0].getValue() + '-' + (String) boxes[1].getValue() + 
						'-' + (String) boxes[2].getValue();
				String purchasedFrom = purchasedFromField.getText();
				String price = pricePaidField.getText();
				String vaccinated = tempVaccineField.getText();
				int mothersId = Integer.parseInt(mothersIdField.getText());
				int fathersId = Integer.parseInt(fathersIdField.getText());
				if (castYes.isSelected() == true)
				{
					// May not need "No" graphical check box with this logic setup
					castrated = true;
				}
				else
				{
					castrated = false;
				}
				String notes = notesField.getText();
				if (male.isSelected())
				{
					Bull bull = new Bull(cowId, cowBreed, birthdate, datePurchased, purchasedFrom, 
							price, vaccinated, mothersId, fathersId, notes, castrated);
					bull.writeCowToDb(db);
				}
			}
		});
		
		dashButton.setOnAction(e -> window.setScene(dashboardScene));
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		mainLayout.setMinWidth(width);
		
		return mainLayout;
	}
}
