import java.text.DecimalFormat;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class MainFile extends Application
{
	Stage window;
	Button button;
	DBConnect db = new DBConnect();
	
	double malePercentage;
	double femalePercentage;
	ArrayList<String> allFeedCosts = new ArrayList<String>();
	ArrayList<String> allEquipCosts = new ArrayList<String>();
	ArrayList<String> allCowCosts = new ArrayList<String>();
	ArrayList<String> allVetCosts = new ArrayList<String>();
	String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// Get Total Cows and Male/Female percentages
		int totalCows = db.getTotalCows();
		double totalCowsDouble = totalCows;
		double totalMales = db.getMaleCount();
		
		if (totalCows != 0 && totalMales != 0)
		{
			malePercentage = (totalMales / totalCowsDouble) * 100;
			DecimalFormat df = new DecimalFormat("#.##");
			malePercentage = Double.valueOf(df.format(malePercentage));
			femalePercentage = 100.00 - malePercentage;
		}
		else
		{
			malePercentage = 0;
			femalePercentage = 0;
			totalMales = 0;
		}
		
		String totalCowsString = Integer.toString(totalCows);
		
		// Get Total Feed Costs
		allFeedCosts = db.getTotalFeedCosts(year);
		int feedCostsTotal = 0;
		if (allFeedCosts != null)
		{
			for (int i = 0; i < allFeedCosts.size(); i++)
			{
				feedCostsTotal += Integer.parseInt(allFeedCosts.get(i));
			}
		}
		
		// Get Total Equipment Costs
		allEquipCosts = db.getTotalEquipmentCosts(year);
		int equipCostsTotal = 0;
		if (allEquipCosts != null)
		{
			for (int i = 0; i < allEquipCosts.size(); i++)
			{
				equipCostsTotal += Integer.parseInt(allEquipCosts.get(i));
			}
		}
		
		// *** NEED TO QUERY COWS BOUGHT ONLY IN CURRENT YEAR ***
		// Get Total Cow Cost
		allCowCosts = db.getCurrentCowsCost();
		int cowCostsTotal = 0;
		if (allCowCosts != null)
		{
			for (int i = 0; i < allCowCosts.size(); i++)
			{
				cowCostsTotal += Integer.parseInt(allCowCosts.get(i));
			}
		}
		
		// Get Total Veterinary Costs
		allVetCosts = db.getTotalVetCosts(year);
		int vetCostsTotal = 0;
		if (allVetCosts != null)
		{
			for (int i = 0; i < allVetCosts.size(); i++)
			{
				vetCostsTotal += Integer.parseInt(allVetCosts.get(i));
			}
		}
		
		// Set primaryStage equal to window variable and set title
		window = primaryStage;
		window.setTitle("Cattle Tracker");
		
		// Get screen dimensions
		int width = (int) Screen.getPrimary().getBounds().getWidth();
		int height = (int) Screen.getPrimary().getBounds().getHeight();
		
		// Center pane
		GridPane mainPane = new GridPane();
		mainPane.setStyle("-fx-background-color: #1D1E1E;");
		mainPane.setMinWidth(800);
		
		HBox cowTotalPane = new HBox();
		HBox numCowPane = new HBox();
		HBox totalInvestmentPane = new HBox();
		HBox investmentValPane = new HBox();
		HBox genderPiePane = new HBox();
		HBox testPiePane = new HBox();
		
		cowTotalPane.setMinWidth(800);
		numCowPane.setMinWidth(800);
		totalInvestmentPane.setMinWidth(800);
		investmentValPane.setMinWidth(800);
		
		cowTotalPane.setStyle("-fx-background-color: #1D1E1E;");
		numCowPane.setStyle("-fx-background-color: #1D1E1E;");
		totalInvestmentPane.setStyle("-fx-background-color: #1D1E1E;");
		investmentValPane.setStyle("-fx-background-color: #1D1E1E;");
		genderPiePane.setStyle("-fx-background-color: #1D1E1E;");
		testPiePane.setStyle("-fx-background-color: #1D1E1E;");
		
		cowTotalPane.setAlignment(Pos.CENTER);
		numCowPane.setAlignment(Pos.CENTER);
		totalInvestmentPane.setAlignment(Pos.CENTER);
		investmentValPane.setAlignment(Pos.CENTER);
		genderPiePane.setAlignment(Pos.CENTER_LEFT);
		testPiePane.setAlignment(Pos.CENTER_LEFT);
		
		Label totalCowsLabel = new Label(" Total Cows");
		Label numOfCowsLabel = new Label(totalCowsString);
		Label totalInvestmentLabel = new Label(" Total Investment");
		Label investmentValLabel = new Label("  $22,000.00");
		
		totalCowsLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: white;");
		numOfCowsLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: orange;");
		totalInvestmentLabel.setStyle("-fx-font-size: 60pt; -fx-text-fill: white;");
		investmentValLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: orange;");
		
		ObservableList<PieChart.Data> genderChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Male", malePercentage),
                new PieChart.Data("Female", femalePercentage));
		final PieChart genderChart = new PieChart(genderChartData);
		genderChart.setTitle("Gender");
		genderChart.setLegendSide(Side.LEFT);
		
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Cows", cowCostsTotal),
                new PieChart.Data("Feed", feedCostsTotal),
                new PieChart.Data("Equipment", equipCostsTotal),
                new PieChart.Data("Veterinary", vetCostsTotal));
		final PieChart costsChart = new PieChart(pieChartData);
		costsChart.setTitle("Overall Costs");
		costsChart.setLegendSide(Side.LEFT);
		
		cowTotalPane.getChildren().addAll(totalCowsLabel);
		numCowPane.getChildren().addAll(numOfCowsLabel);
		totalInvestmentPane.getChildren().addAll(totalInvestmentLabel);
		investmentValPane.getChildren().addAll(investmentValLabel);
		genderPiePane.getChildren().addAll(genderChart, costsChart);
		
		mainPane.add(cowTotalPane, 0, 0);
		mainPane.add(numCowPane, 0, 1);
		mainPane.add(totalInvestmentPane, 0, 2);
		mainPane.add(investmentValPane, 0, 3);
		mainPane.add(genderPiePane, 0, 4);
		
		
		// Left pane
		VBox leftPane = new VBox();
		leftPane.setMinWidth(300);
		leftPane.setStyle("-fx-background-color: #1B4040;");
		leftPane.setAlignment(Pos.TOP_CENTER);
		leftPane.setPadding(new Insets(20, 10, 10, 10));
		
		// Right pane
		VBox rightPane = new VBox(20);
		rightPane.setMinWidth(300);
		rightPane.setStyle("-fx-background-color: #1B4040;");
		rightPane.setAlignment(Pos.CENTER);
		
		Label navigationLabel = new Label("Navigation");
		navigationLabel.setStyle("-fx-text-fill: white; -fx-font-size: 40pt;");
		
		Button reportsButton = new Button("Financial Reports");
		Button editHerdButton = new Button("Edit My Herd");
		Button addExpenseButton = new Button("Add General Expense");
		
		reportsButton.setStyle("-fx-font-size: 15pt;");
		editHerdButton.setStyle("-fx-font-size: 15pt;");
		addExpenseButton.setStyle("-fx-font-size: 15pt;");
		
		reportsButton.setMaxWidth(Double.MAX_VALUE);
		editHerdButton.setMaxWidth(Double.MAX_VALUE);
		addExpenseButton.setMaxWidth(Double.MAX_VALUE);
		
		rightPane.getChildren().addAll(navigationLabel, editHerdButton, addExpenseButton, reportsButton);
		
		// Main layout
		BorderPane border = new BorderPane();
		border.setCenter(mainPane);
		border.setLeft(leftPane);
		border.setRight(rightPane);
		
		// Scenes
		Scene mainScene = new Scene(border, width, height);
		mainScene.getStylesheets().add(MainFile.class.getResource("styles.css").toExternalForm());
		
		AddCow cowScreen = new AddCow();
		Scene cowScreenScene = new Scene(cowScreen.display(mainScene, window, db, width, height), width, height);
		
		FinancialReports financialScreen = new FinancialReports();
		Scene financialScreenScene = new Scene(financialScreen.display(mainScene, cowScreenScene,
				window, db), width, height);
		financialScreenScene.getStylesheets().add(MainFile.class.getResource("styles.css").toExternalForm());
		
		GeneralExpenses generalExpensesScreen = new GeneralExpenses();
		Scene generalExpensesScene = new Scene(generalExpensesScreen.display(mainScene, window, db), width, height);
		
		window.setScene(mainScene);
		window.setMaximized(true);
		window.show();
		
		reportsButton.setOnAction(e -> window.setScene(financialScreenScene));
		editHerdButton.setOnAction(e -> window.setScene(cowScreenScene));
		addExpenseButton.setOnAction(e -> window.setScene(generalExpensesScene));
	}
}




















