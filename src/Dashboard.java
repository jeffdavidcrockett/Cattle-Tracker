import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import Data.DBConnect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;


public class Dashboard {
	static double malePercentage;
	static double femalePercentage;
	static ArrayList<String> allExpenses = new ArrayList<String>();
	static ArrayList<String> allFeedCosts = new ArrayList<String>();
	static ArrayList<String> allEquipCosts = new ArrayList<String>();
	static ArrayList<String> allCowCosts = new ArrayList<String>();
	static ArrayList<String> allVetCosts = new ArrayList<String>();
	static String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	
	public static Scene getScene(DBConnect db) {
		// Get Total Cows and Male/Female percentages
		int totalCows = db.getTotalCows();
		double totalCowsDouble = totalCows;
		double totalMales = db.getMaleCount();
		
		if (totalCows != 0 && totalMales != 0) {
			malePercentage = (totalMales / totalCowsDouble) * 100;
			DecimalFormat df = new DecimalFormat("#.##");
			malePercentage = Double.valueOf(df.format(malePercentage));
			femalePercentage = 100.00 - malePercentage;
		}
		else {
			malePercentage = 0;
			femalePercentage = 0;
			totalMales = 0;
		}
		
		String totalCowsString = Integer.toString(totalCows);
		
		// Get Total Expenses For Current Year
		allExpenses = db.getTotalExpenses(currentYear);
		int totalExpenses = 0;
		if (allExpenses != null) {
			for (int i = 0; i < allExpenses.size(); i++) {
				totalExpenses += Integer.parseInt(allExpenses.get(i));
			}
		}
		
		// Get Total Feed Costs
		allFeedCosts = db.getTotalFeedCosts(currentYear);
		int feedCostsTotal = 0;
		if (allFeedCosts != null) {
			for (int i = 0; i < allFeedCosts.size(); i++) {
				feedCostsTotal += Integer.parseInt(allFeedCosts.get(i));
			}
		}
		
		// Get Total Equipment Costs
		allEquipCosts = db.getTotalEquipmentCosts(currentYear);
		int equipCostsTotal = 0;
		if (allEquipCosts != null) {
			for (int i = 0; i < allEquipCosts.size(); i++) {
				equipCostsTotal += Integer.parseInt(allEquipCosts.get(i));
			}
		}
		
		// Get Total Cow Cost
		allCowCosts = db.getCurrentCowsCost();
		int cowCostsTotal = 0;
		if (allCowCosts != null) {
			for (int i = 0; i < allCowCosts.size(); i++) {
				cowCostsTotal += Integer.parseInt(allCowCosts.get(i));
			}
		}
		
		// Get Total Veterinary Costs
		allVetCosts = db.getTotalVetCosts(currentYear);
		int vetCostsTotal = 0;
		if (allVetCosts != null) {
			for (int i = 0; i < allVetCosts.size(); i++) {
				vetCostsTotal += Integer.parseInt(allVetCosts.get(i));
			}
		}
		
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
		Label totalExpensesLabel = new Label("Total Expenses for " + currentYear);
		Label investmentValLabel = new Label("$" + totalExpenses);
		
		totalCowsLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: white;");
		numOfCowsLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: orange;");
		totalExpensesLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: white;");
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
		totalInvestmentPane.getChildren().addAll(totalExpensesLabel);
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
		Button editHerdButton = new Button("My Herd");
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
		
		reportsButton.setOnAction(e -> MainFile.window.setScene(FinancialReports.getScene(db)));
		editHerdButton.setOnAction(e -> MainFile.window.setScene(AddCow.getScene(db)));
		addExpenseButton.setOnAction(e -> MainFile.window.setScene(GeneralExpenses.getScene(db)));
		
		Scene dashboardScene = new Scene(border, width, height);
		dashboardScene.getStylesheets().add(MainFile.class.getResource("styles.css").toExternalForm());
		
		return dashboardScene;
	}
}


































