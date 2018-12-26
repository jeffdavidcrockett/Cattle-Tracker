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
	public static String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	
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
		
		HBox hayPricePerDetails = new HBox();
		hayPricePerDetails.getChildren().addAll(hayPricePer, hayPricePerField);
		
		HBox hayBailDetails = new HBox();
		hayBailDetails.getChildren().addAll(amountOfHayBailsLabel, amountOfHayBailsField);

		HBox hayAllDetails = new HBox(20);
		hayAllDetails.setAlignment(Pos.CENTER_LEFT);
	    hayAllDetails.setPadding(new Insets(15, 12, 15, 12));
		hayAllDetails.getChildren().addAll(hayPricePerDetails, hayBailDetails, submitHayExpenseButton);
		
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
		
		HBox otherFeedDetails = new HBox();
		otherFeedDetails.getChildren().addAll(otherFeedAmountLabel, otherFeedField);
		
		HBox otherFeedAllDetails = new HBox(20);
		otherFeedAllDetails.setAlignment(Pos.CENTER_LEFT);
		otherFeedAllDetails.setPadding(new Insets(15, 12, 15, 12));
		otherFeedAllDetails.getChildren().addAll(otherFeedDetails, submitOtherFeedButton);
		
		VBox otherFeedVBox = new VBox();
		otherFeedVBox.getChildren().addAll(otherFeedLabel, otherFeedAllDetails, separator2);
		
		//Veterinary Section
		Label veterinaryLabel = new Label("Veterinary");
		Label veterinaryAmountLabel = new Label("Amount $: ");
		
		veterinaryLabel.setStyle("-fx-font-size: 30pt; -fx-text-fill: white; -fx-padding: 10 10 10 10;");
		veterinaryAmountLabel.setStyle("-fx-font-size: 15pt; -fx-text-fill: white;");
		
		TextField veterinaryField = new TextField();
		
		veterinaryField.setMaxWidth(200);
		
		Button veterinaryButton = new Button("Submit");
		
		HBox veterinaryDetails = new HBox();
		veterinaryDetails.getChildren().addAll(veterinaryAmountLabel, veterinaryField);
		
		HBox veterinaryAllDetails = new HBox(20);
		veterinaryAllDetails.setAlignment(Pos.CENTER_LEFT);
		veterinaryAllDetails.setPadding(new Insets(15, 12, 15, 12));
		veterinaryAllDetails.getChildren().addAll(veterinaryDetails, veterinaryButton);
		
		VBox veterinaryVBox = new VBox();
		veterinaryVBox.getChildren().addAll(veterinaryLabel, veterinaryAllDetails);
		
		// MainGrid
		mainGrid.add(mainLabelBox, 0, 0);
		mainGrid.add(hayVBox, 0, 1);
		mainGrid.add(otherFeedVBox, 0, 2);
		mainGrid.add(veterinaryVBox, 0, 3);
		
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
					db.writeGeneralExpense(year, "Hay", pricePerBail, totalCost);
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
					db.writeGeneralExpense(year, "Feed", null, totalCost);
					AlertBox.display("Attention!", "Expense was added to database");
					otherFeedField.clear();
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
					db.writeGeneralExpense(year, "Vet", null, totalCost);
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
