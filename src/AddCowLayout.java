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
		// Right pane
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
		
		// Center pane
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		Label addCowLabel = new Label("               Add Cow");
		Label idInput = new Label("  ID");
		Label breedInput = new Label("Breed");
		Label birthdateInput = new Label("Birthdate");
		
		addCowLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: white;");
		idInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		breedInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		birthdateInput.setStyle("-fx-font-size: 20pt; -fx-text-fill: white;");
		
		TextField idField = new TextField();
		
		idField.setMaxWidth(200);
		
		ObservableList<String> breedOptions = 
			    FXCollections.observableArrayList(
			        "Black Angus",
			        "Option 2",
			        "Option 3"
			    );
		final ComboBox breedBox = new ComboBox(breedOptions);
		
		HBox dateBox = new HBox(5);
		
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
		
		dateBox.getChildren().addAll(monthBox, dayBox, yearBox);
        
        HBox addCowLabelBox = new HBox();
		addCowLabelBox.getChildren().addAll(addCowLabel);
		addCowLabelBox.setAlignment(Pos.CENTER);
		addCowLabelBox.setStyle("-fx-background-color: #1D1E1E;");
		
		VBox idBox = new VBox();
		
		idBox.getChildren().addAll(idInput, idField, breedInput, breedBox, birthdateInput, dateBox);
		
		mainGrid.add(addCowLabelBox, 0, 0);
		mainGrid.add(idBox, 0, 1);
		
		dashButton.setOnAction(e -> window.setScene(dashboardScene));
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		mainLayout.setMinWidth(width);
		
		return mainLayout;
	}
}
