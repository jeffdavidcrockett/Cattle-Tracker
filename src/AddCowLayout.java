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
	public BorderPane display(int width, int height, Scene dashboardScene, Stage window)
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
		Label vaccinatedInput = new Label("Vaccinated");
		Label mothersIdInput = new Label("Mother's ID");
		Label fathersIdInput = new Label("Father's ID");
		Label maleLabel = new Label("Male");
		Label femaleLabel = new Label("Female");
		Label castratedLabel = new Label("Castrated");
		Label castYesLabel = new Label("Yes");
		Label castNoLabel = new Label("No");
		Label blankLabel1 = new Label();
		Label blankLabel2 = new Label();
		Label blankLabel3 = new Label();
		Label blankLabel4 = new Label();
		Label blankLabel5 = new Label();
		Label blankLabel6 = new Label();
		Label blankLabel7 = new Label();
		Label blankLabel8 = new Label();

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
		maleLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		femaleLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		castratedLabel.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		castYesLabel.setStyle("-fx-font-size: 10pt; -fx-text-fill: white;");
		castNoLabel.setStyle("-fx-font-size: 10pt; -fx-text-fill: white;");
		
		Button submitCowButton = new Button("Submit Cow");
		submitCowButton.setMinSize(100, 80);
		submitCowButton.setStyle("-fx-font-size: 30pt;");

		TextField idField = new TextField();
		TextField purchasedFromField = new TextField();
		TextField tempVaccineField = new TextField();
		TextField mothersIdField = new TextField();
		TextField fathersIdField = new TextField();
		
		CheckBox male = new CheckBox();
		CheckBox female = new CheckBox();
		CheckBox castYes = new CheckBox();
		CheckBox castNo = new CheckBox();
		
		idField.setMaxWidth(200);
		purchasedFromField.setMaxWidth(200);
		tempVaccineField.setMaxWidth(200);
		mothersIdField.setMaxWidth(200);
		fathersIdField.setMaxWidth(200);
		
		ObservableList<String> breedOptions = 
			    FXCollections.observableArrayList(
			        "Black Angus",
			        "Dairy");
		
		final ComboBox breedBox = new ComboBox(breedOptions);
		
		HBox idDateBox = new HBox(5);
		
		ObservableList<String> month = 
			    FXCollections.observableArrayList(
			        "01", "02", "03",
			        "04", "05", "06",
			        "07", "08", "09",
			        "10", "11", "12"
			    );
		final ComboBox monthBox = new ComboBox(month);
		
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
		final ComboBox dayBox = new ComboBox(day);
		
		ObservableList<String> year = 
			    FXCollections.observableArrayList(
			    	"2018", "2017", "2016",
				       "2015", "2014", "2013",
			        "2018", "2017", "2016",
			        "2015", "2014", "2013",
			        "2012", "2011", "2010",
			        "2009", "2008", "2007",
			        "2006", "2005", "2004",
			        "2003", "2002", "2001",
			        "2000"
			    );
		final ComboBox yearBox = new ComboBox(year);
		
		idDateBox.getChildren().addAll(monthBox, dayBox, yearBox);
		
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
		
		DateBox datePurchasedDate = new DateBox();
		
		HBox row1 = new HBox(80);
		VBox column0 = new VBox();
		VBox column1 = new VBox();
		VBox column2 = new VBox();
		
		column0.getChildren().addAll(maleLabel, male, blankLabel1, femaleLabel, female, blankLabel2,
				idInput, idField, blankLabel3, breedInput, breedBox);
		
		column1.getChildren().addAll(birthdateInput, idDateBox, blankLabel4, datePurchasedInput, datePurchasedDate.createDateBox(),
				blankLabel5, purchasedFromInput, purchasedFromField, blankLabel6, vaccinatedInput, tempVaccineField);
		
		column2.getChildren().addAll(mothersIdInput, mothersIdField, blankLabel7, fathersIdInput, fathersIdField,
				blankLabel8, castratedLabel, castratedOptions);
		
		
		row1.getChildren().addAll(column0, column1, column2);
		
		mainGrid.add(addCowLabelBox, 0, 0);
		mainGrid.add(row1, 0, 1);
		mainGrid.add(blankHBox1, 0, 2);
		mainGrid.add(submitCowButtonBox, 0, 3);
		
		submitCowButton.setOnAction(e -> AlertBox.display("Attention!", "Are you sure you would like to submit cow?"));
		
		dashButton.setOnAction(e -> window.setScene(dashboardScene));
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		mainLayout.setMinWidth(width);
		
		return mainLayout;
	}
}
