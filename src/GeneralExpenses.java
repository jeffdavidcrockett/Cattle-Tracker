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



public class GeneralExpenses 
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
		
		// Center pane*******************************************************************************
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		Label generalExpensesLabel = new Label("         General Expenses");
		
		generalExpensesLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: orange;");
		
		TextField expenseCostField = new TextField();
		
		expenseCostField.setMaxWidth(200);
		
		ObservableList<String> expenses = 
			    FXCollections.observableArrayList(
			        "Hay", 
			        "Equipment", 
			        "Veterinary"
			    );
		final ComboBox expensesBox = new ComboBox(expenses);
		
		HBox expenseBoxBox = new HBox(20);
		expenseBoxBox.getChildren().addAll(expensesBox, expenseCostField);
		expenseBoxBox.setAlignment(Pos.CENTER);
		
		HBox mainLabelBox = new HBox();
		mainLabelBox.setAlignment(Pos.CENTER);
		mainLabelBox.getChildren().addAll(generalExpensesLabel);
		
		
		mainGrid.add(mainLabelBox, 0, 0);
		mainGrid.add(expenseBoxBox, 0, 1);
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
				
		return mainLayout;
	}
}
