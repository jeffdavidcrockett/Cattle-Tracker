import java.util.ArrayList;
import java.util.Calendar;

import Cows.Bull;
import Cows.Heffer;
import Data.DBConnect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.Group;



public class GeneralExpenses 
{
	String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	String previousYear1 = Integer.toString(Integer.parseInt(currentYear) - 1);
	String previousYear2 = Integer.toString(Integer.parseInt(currentYear) - 2);
	String previousYear3 = Integer.toString(Integer.parseInt(currentYear) - 3);
	
	
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
				
		dashButton.setStyle("-fx-font-size: 15pt;");
				
		dashButton.setMaxWidth(Double.MAX_VALUE);
				
		rightPane.getChildren().addAll(navigationLabel, dashButton);
		
		// Center pane*******************************************************************************
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		Separator separator1 = new Separator();
		Separator separator2 = new Separator();
		Separator separator3 = new Separator();
		
		Label mainLabel = new Label("General Expenses");
		
		mainLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: orange;");
		
		// Main Screen Label
		HBox mainLabelBox = new HBox();
		mainLabelBox.setAlignment(Pos.CENTER);
		mainLabelBox.getChildren().addAll(mainLabel);
		
		// Hay Section
		Label hayLabel = new Label("Hay");
		Label hayPricePer = new Label("Price Per Bail: ");
		Label amountOfHayBailsLabel = new Label("Number of Bails: ");
		
		hayLabel.setStyle("-fx-font-size: 30pt; -fx-text-fill: white; -fx-padding: 10 10 10 10;");
		hayPricePer.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		amountOfHayBailsLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		
		TextField hayPricePerField = new TextField();
		TextField amountOfHayBailsField = new TextField();
		
		hayPricePerField.setMaxWidth(200);
		amountOfHayBailsField.setMaxWidth(100);
		
		Button submitHayExpenseButton = new Button("Submit");
		
		ObservableList<String> hayYears = 
			    FXCollections.observableArrayList(
			        currentYear,
			        previousYear1,
			        previousYear2,
			        previousYear3);
		
		final ComboBox hayYearsBox = new ComboBox(hayYears);
		hayYearsBox.getSelectionModel().select(0);

		HBox hayPricePerDetails = new HBox();
		hayPricePerDetails.getChildren().addAll(hayPricePer, hayPricePerField);
		
		HBox hayBailDetails = new HBox(10);
		hayBailDetails.getChildren().addAll(amountOfHayBailsLabel, amountOfHayBailsField, hayYearsBox, submitHayExpenseButton);

		HBox hayAllDetails = new HBox(20);
		hayAllDetails.setAlignment(Pos.CENTER_LEFT);
	    hayAllDetails.setPadding(new Insets(15, 12, 15, 12));
		hayAllDetails.getChildren().addAll(hayPricePerDetails, hayBailDetails);
		
		VBox hayVBox = new VBox();
		hayVBox.getChildren().addAll(hayLabel, hayAllDetails, separator1);
		
		// Other Feed Section
		Label otherFeedLabel = new Label("Other Feed");
		Label otherFeedAmountLabel = new Label("Amount $: ");
		
		otherFeedLabel.setStyle("-fx-font-size: 30pt; -fx-text-fill: white; -fx-padding: 10 10 10 10;");
		otherFeedAmountLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		
		TextField otherFeedField = new TextField();
		
		otherFeedField.setMaxWidth(200);
		
		Button submitOtherFeedButton = new Button("Submit");
		
		ObservableList<String> otherFeedYears = 
			    FXCollections.observableArrayList(
			        currentYear,
			        previousYear1,
			        previousYear2,
			        previousYear3);
		
		final ComboBox otherFeedYearsBox = new ComboBox(otherFeedYears);
		otherFeedYearsBox.getSelectionModel().select(0);
		
		HBox otherFeedDetails = new HBox(10);
		otherFeedDetails.getChildren().addAll(otherFeedAmountLabel, otherFeedField, otherFeedYearsBox, submitOtherFeedButton);
		
		HBox otherFeedAllDetails = new HBox();
		otherFeedAllDetails.setAlignment(Pos.CENTER_LEFT);
		otherFeedAllDetails.setPadding(new Insets(15, 12, 15, 12));
		otherFeedAllDetails.getChildren().addAll(otherFeedDetails);
		
		VBox otherFeedVBox = new VBox();
		otherFeedVBox.getChildren().addAll(otherFeedLabel, otherFeedAllDetails, separator2);
		
		// Equipment Section
		Label equipmentLabel = new Label("Equipment");
		Label equipmentAmountLabel = new Label("Amount $: ");
		
		equipmentLabel.setStyle("-fx-font-size: 30pt; -fx-text-fill: white; -fx-padding: 10 10 10 10;");
		equipmentAmountLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		
		TextField equipmentField = new TextField();
		
		equipmentField.setMaxWidth(200);
		
		Button equipmentButton = new Button("Submit");
		
		ObservableList<String> equipmentYears = 
			    FXCollections.observableArrayList(
			        currentYear,
			        previousYear1,
			        previousYear2,
			        previousYear3);
		
		final ComboBox equipmentYearsBox = new ComboBox(equipmentYears);
		equipmentYearsBox.getSelectionModel().select(0);
		
		HBox equipmentDetails = new HBox(10);
		equipmentDetails.getChildren().addAll(equipmentAmountLabel, equipmentField, equipmentYearsBox, equipmentButton);
		
		HBox equipmentAllDetails = new HBox();
		equipmentAllDetails.setAlignment(Pos.CENTER_LEFT);
		equipmentAllDetails.setPadding(new Insets(15, 12, 15, 12));
		equipmentAllDetails.getChildren().addAll(equipmentDetails);
		
		VBox equipmentVBox = new VBox();
		equipmentVBox.getChildren().addAll(equipmentLabel, equipmentAllDetails, separator3);
		
		// Veterinary Section
		Label veterinaryLabel = new Label("Veterinary");
		Label veterinaryAmountLabel = new Label("Amount $: ");
		
		veterinaryLabel.setStyle("-fx-font-size: 30pt; -fx-text-fill: white; -fx-padding: 10 10 10 10;");
		veterinaryAmountLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		
		TextField veterinaryField = new TextField();
		
		veterinaryField.setMaxWidth(200);
		
		Button veterinaryButton = new Button("Submit");
		
		ObservableList<String> veterinaryYears = 
			    FXCollections.observableArrayList(
			        currentYear,
			        previousYear1,
			        previousYear2,
			        previousYear3);
		
		final ComboBox veterinaryYearsBox = new ComboBox(veterinaryYears);
		veterinaryYearsBox.getSelectionModel().select(0);
		
		HBox veterinaryDetails = new HBox(10);
		veterinaryDetails.getChildren().addAll(veterinaryAmountLabel, veterinaryField, veterinaryYearsBox, veterinaryButton);
		
		HBox veterinaryAllDetails = new HBox();
		veterinaryAllDetails.setAlignment(Pos.CENTER_LEFT);
		veterinaryAllDetails.setPadding(new Insets(15, 12, 15, 12));
		veterinaryAllDetails.getChildren().addAll(veterinaryDetails);
		
		VBox veterinaryVBox = new VBox();
		veterinaryVBox.getChildren().addAll(veterinaryLabel, veterinaryAllDetails);
		
		// MainGrid
		mainGrid.add(mainLabelBox, 0, 0);
		mainGrid.add(hayVBox, 0, 1);
		mainGrid.add(otherFeedVBox, 0, 2);
		mainGrid.add(equipmentVBox, 0, 3);
		mainGrid.add(veterinaryVBox, 0, 4);
		
		
		// Main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(mainGrid);
		mainLayout.setRight(rightPane);
		
		// Button actions
		dashButton.setOnAction(e -> window.setScene(dashboardScene));
		
		submitHayExpenseButton.setOnAction(e -> {
			if (!hayPricePerField.getText().trim().isEmpty() || !amountOfHayBailsField.getText().trim().isEmpty())
			{
				String pricePerBail = hayPricePerField.getText();
				String amountOfBails = amountOfHayBailsField.getText();
				String totalCost = Integer.toString(Integer.parseInt(pricePerBail) * Integer.parseInt(amountOfBails));
				
				boolean answer = ConfirmBox.display("Add Hay Expense", "Are you sure you would like to add", 
						amountOfBails + " bails of hay at $" + pricePerBail + " a bail?");
				
				if (answer)
				{
					db.writeGeneralExpense((String) hayYearsBox.getValue(), "Hay", pricePerBail, totalCost);
					AlertBox.display("Attention!", "Expense was added to database");
					hayPricePerField.clear();
					amountOfHayBailsField.clear();
				}
			}
			else
			{
				AlertBox.display("Attention!", "Please fill out all Hay expense fields");
			}
		});
		
		submitOtherFeedButton.setOnAction(e -> {
			if (!otherFeedField.getText().trim().isEmpty())
			{
				String totalCost = otherFeedField.getText();
				
				boolean answer = ConfirmBox.display("Feed Expense", "Are you sure you would like to add", 
						"a feed expense of $" + totalCost + "?");
				
				if (answer)
				{
					db.writeGeneralExpense((String) otherFeedYearsBox.getValue(), "Feed", null, totalCost);
					AlertBox.display("Attention!", "Expense was added to database");
					otherFeedField.clear();
				}
			}
			else
			{
				AlertBox.display("Attention!", "Please fill out cost field");
			}
		});
		
		equipmentButton.setOnAction(e -> {
			if (!equipmentField.getText().trim().isEmpty())
			{
				String totalCost = equipmentField.getText();
				
				boolean answer = ConfirmBox.display("Equipment Expense", "Are you sure you would like to add", 
						"an equipment expense of $" + totalCost + "?");
				
				if (answer)
				{
					db.writeGeneralExpense((String) equipmentYearsBox.getValue(), "Equipment", null, totalCost);
					AlertBox.display("Attention!", "Expense was added to database");
					equipmentField.clear();
				}
			}
			else
			{
				AlertBox.display("Attention!", "Please fill out cost field");
			}
		});
		
		veterinaryButton.setOnAction(e -> {
			if (!veterinaryField.getText().trim().isEmpty())
			{
				String totalCost = veterinaryField.getText();
				
				boolean answer = ConfirmBox.display("Veterinary Cost", "Are you sure you would like to add", 
						"a veterinary expense of $" + totalCost + "?");
				
				if (answer)
				{
					db.writeGeneralExpense((String) veterinaryYearsBox.getValue(), "Vet", null, totalCost);
					AlertBox.display("Attention!", "Expense was added to database");
					veterinaryField.clear();
				}
			}
			else
			{
				AlertBox.display("Attention!", "Please fill out cost field");
			}
		});
				
		return mainLayout;
	}
}
