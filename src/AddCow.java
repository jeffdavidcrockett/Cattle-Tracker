import java.util.ArrayList;
import java.util.Calendar;
import Cows.Bull;
import Cows.Heffer;
import Data.DBConnect;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.geometry.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AddCow {
	static int width = (int) Screen.getPrimary().getBounds().getWidth();
	static int height = (int) Screen.getPrimary().getBounds().getHeight();
	static boolean result;
	static String castrated;
	static String gender;
	static String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	
	public static Scene getScene(DBConnect db) {
		// Right pane ****************************************************************************
		Label navigationLabel = new Label("Navigation");
		navigationLabel.setStyle("-fx-text-fill: white; -fx-font-size: 40pt;");
		
		Button dashButton = new Button("Dashboard");
		Button sellCowButton = new Button("Sell Cow");
		
		dashButton.setStyle("-fx-font-size: 15pt;");
		sellCowButton.setStyle("-fx-font-size: 15pt;");
		
		dashButton.setMaxWidth(Double.MAX_VALUE);
		sellCowButton.setMaxWidth(Double.MAX_VALUE);
		
		VBox rightPane = new VBox(20);
		rightPane.setMinWidth(300);
		rightPane.setStyle("-fx-background-color: #1B4040;");
		rightPane.setAlignment(Pos.CENTER);
		rightPane.getChildren().addAll(navigationLabel, dashButton, sellCowButton);
		
		// Center pane *************************************************************************************
		Label addCowLabel = new Label("          Add Cow");
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
		
		final ComboBox<String> breedBox = new ComboBox<String>(breedOptions);
		
		// Create list of years from current year to 10 years back
		ArrayList<String> yearList = new ArrayList<String>();
		int i = 1;
		while (i != 11) {
			yearList.add(Integer.toString(Calendar.getInstance().get(Calendar.YEAR) - i));
			i++;
		}
		
		ObservableList<String> month = 
			    FXCollections.observableArrayList(
			        "01", "02", "03",
			        "04", "05", "06",
			        "07", "08", "09",
			        "10", "11", "12"
			    );
		ComboBox<String> monthBoxPurchased = new ComboBox<String>(month);
		ComboBox<String> monthBoxBirth = new ComboBox<String>(month);
		
		ObservableList<String> day = 
			    FXCollections.observableArrayList(
			        "01", "02", "03",
			        "04", "05", "06",
			        "07", "08", "09",
			        "10", "11", "12",
			        "13", "14", "15",
			        "16", "17", "18",
			        "19", "20", "21",
			        "22", "23", "24",
			        "25", "26", "27",
			        "28", "29", "30",
			        "31"
			    );
		ComboBox<String> dayBoxPurchased = new ComboBox<String>(day);
		ComboBox<String> dayBoxBirth = new ComboBox<String>(day);
		
		ObservableList<String> year = 
			    FXCollections.observableArrayList(
			    	currentYear, yearList.get(0), yearList.get(1),
			    	yearList.get(2), yearList.get(3), yearList.get(4),
			    	yearList.get(5), yearList.get(6), yearList.get(7),
			    	yearList.get(8), yearList.get(9)
			    );
		ComboBox<String> yearBoxPurchased = new ComboBox<String>(year);
		ComboBox<String> yearBoxBirth = new ComboBox<String>(year);
		
		HBox priceBox = new HBox(5);
		priceBox.getChildren().addAll(dollarSignLabel, pricePaidField);
		priceBox.setAlignment(Pos.CENTER_LEFT);
		
		HBox idDateBox = new HBox(5);
		idDateBox.getChildren().addAll(monthBoxBirth, dayBoxBirth, yearBoxBirth);
		
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
		
		HBox datePurchasedDate = new HBox(5);
		datePurchasedDate.getChildren().addAll(monthBoxPurchased, dayBoxPurchased, yearBoxPurchased);
		
		VBox column0 = new VBox();
		VBox column1 = new VBox();
		VBox column2 = new VBox();
		HBox row1 = new HBox(80);
		
		column0.getChildren().addAll(male, blankLabel1, female, blankLabel2,
				idInput, idField, blankLabel3, breedInput, breedBox, blankLabel4, birthdateInput, idDateBox);
		
		column1.getChildren().addAll(datePurchasedInput, datePurchasedDate, blankLabel5, 
				purchasedFromInput, purchasedFromField, blankLabel10, pricePaidLabel, priceBox, 
				blankLabel6, vaccinatedInput, tempVaccineField);
		
		column2.getChildren().addAll(mothersIdInput, mothersIdField, blankLabel7, fathersIdInput, fathersIdField,
				blankLabel8, castratedLabel, castratedOptions, blankLabel9, notesLabel, notesField);
		
		
		row1.getChildren().addAll(column0, column1, column2);
		
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		mainGrid.add(addCowLabelBox, 0, 0);
		mainGrid.add(row1, 0, 1);
		mainGrid.add(blankHBox1, 0, 2);
		mainGrid.add(submitCowButtonBox, 0, 3);
		
		submitCowButton.setOnAction(e -> {
			if (male.isSelected() == true && female.isSelected() == true || castYes.isSelected() == true && 
					castNo.isSelected() == true) {
				if (male.isSelected() == true && female.isSelected() == true) {
					AlertBox.display("Attention!", "Please check only male or female. Both are currently selected.");
				}
				else if (castYes.isSelected() == true && castNo.isSelected() == true) {
					AlertBox.display("Attention!", "Both castrated options are selected. Please select only one.");
				}
			}
			else {
				result = ConfirmBox.display("Cow Submission","", "Are you sure you would like to submit this cow?");
			}
			if (male.isSelected() == false && female.isSelected() == false) {
				AlertBox.display("Attention!", "Please select either male or female.");
			}
			else if (result == true && male.isSelected() == true || female.isSelected() == true) {
				int cowId = Integer.parseInt(idField.getText());
				String cowBreed = (String) breedBox.getValue();
				String birthdate = (String) monthBoxBirth.getValue() + '-' + (String) dayBoxBirth.getValue() + 
						'-' + (String) yearBoxBirth.getValue();
				String datePurchased = (String) monthBoxPurchased.getValue() + '-' + (String) dayBoxPurchased.getValue() + 
						'-' + (String) yearBoxPurchased.getValue();
				String purchasedFrom = purchasedFromField.getText();
				String price = pricePaidField.getText();
				String vaccinated = tempVaccineField.getText();
				int mothersId = Integer.parseInt(mothersIdField.getText());
				int fathersId = Integer.parseInt(fathersIdField.getText());
				if (castYes.isSelected() == true) {
					// May not need "No" graphical check box with this logic setup
					castrated = "Yes";
				}
				else {
					castrated = "No";
				}
				String notes = notesField.getText();
				if (male.isSelected()) {
					gender = "Male";
					Bull bull = new Bull(cowId, cowBreed, gender, birthdate, datePurchased, purchasedFrom, 
							price, vaccinated, mothersId, fathersId, castrated, notes);
					bull.writeBullToCurrentDb(db);
					
					AlertBox.display("", "Cow was added to database!");
					
					male.setSelected(false);
					idField.clear();
					breedBox.valueProperty().set(null);
					dayBoxBirth.valueProperty().set(null);
					dayBoxPurchased.valueProperty().set(null);
					monthBoxBirth.valueProperty().set(null);
					monthBoxPurchased.valueProperty().set(null);
					yearBoxBirth.valueProperty().set(null);
					yearBoxPurchased.valueProperty().set(null);
					purchasedFromField.clear();
					pricePaidField.clear();
					tempVaccineField.clear();
					mothersIdField.clear();
					fathersIdField.clear();
					castYes.setSelected(false);
					castNo.setSelected(false);
					notesField.clear();
				}
				else if (female.isSelected()) {
					gender = "Female";
					Heffer heffer = new Heffer(cowId, cowBreed, gender, birthdate, datePurchased, purchasedFrom, 
							price, vaccinated, mothersId, fathersId, notes);
					heffer.writeHefferToCurrentDb(db);
					
					AlertBox.display("", "Cow was added to database!");
					
					female.setSelected(false);
					idField.clear();
					breedBox.valueProperty().set(null);
					dayBoxBirth.valueProperty().set(null);
					dayBoxPurchased.valueProperty().set(null);
					monthBoxBirth.valueProperty().set(null);
					monthBoxPurchased.valueProperty().set(null);
					yearBoxBirth.valueProperty().set(null);
					yearBoxPurchased.valueProperty().set(null);
					purchasedFromField.clear();
					pricePaidField.clear();
					tempVaccineField.clear();
					mothersIdField.clear();
					fathersIdField.clear();
					castYes.setSelected(false);
					castNo.setSelected(false);
					notesField.clear();
				}
			}
		});

		dashButton.setOnAction(e -> MainFile.window.setScene(Dashboard.getScene(db)));
		sellCowButton.setOnAction(e -> MainFile.window.setScene(SellCow.getScene(db)));
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		
		Scene addCowScene = new Scene(mainLayout, width, height);
		
		return addCowScene;
	}
}
