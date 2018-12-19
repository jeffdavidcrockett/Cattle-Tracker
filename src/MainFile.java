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
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// Set primaryStage equal to window var and set title
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
		Label numOfCowsLabel = new Label("  8");
		Label totalInvestmentLabel = new Label(" Total Investment");
		Label investmentValLabel = new Label("  $22,000.00");
		
		totalCowsLabel.setStyle("-fx-font-size: 70pt; -fx-text-fill: white;");
		numOfCowsLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: orange;");
		totalInvestmentLabel.setStyle("-fx-font-size: 60pt; -fx-text-fill: white;");
		investmentValLabel.setStyle("-fx-font-size: 50pt; -fx-text-fill: orange;");
		
		ObservableList<PieChart.Data> genderChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Male", 13),
                new PieChart.Data("Female", 25));
		final PieChart genderChart = new PieChart(genderChartData);
		genderChart.setTitle("Gender");
		
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("2 months", 13),
                new PieChart.Data("6 months", 25),
                new PieChart.Data("1 year", 18),
                new PieChart.Data("2 years", 13));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Ages");
		
		cowTotalPane.getChildren().addAll(totalCowsLabel);
		numCowPane.getChildren().addAll(numOfCowsLabel);
		totalInvestmentPane.getChildren().addAll(totalInvestmentLabel);
		investmentValPane.getChildren().addAll(investmentValLabel);
		genderPiePane.getChildren().addAll(genderChart, chart);
		
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
		
		Button test = new Button("Test");
		
		leftPane.getChildren().addAll(test);
		
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
		
		// Main layout
		BorderPane border = new BorderPane();
		border.setCenter(mainPane);
		border.setLeft(leftPane);
		border.setRight(rightPane);
		
		// Entire Window
		Scene mainScene = new Scene(border, width, height);
		window.setScene(mainScene);
		
		// Scenes
		AddCowLayout cowScreen = new AddCowLayout();
		Scene cowScreenScene = new Scene(cowScreen.display(width, height, mainScene, window, db), width, height);
		
		dashButton.setOnAction(e -> window.setScene(mainScene));
		
		addCowButton.setOnAction(e -> window.setScene(cowScreenScene));
		
		
		window.setMaximized(true);
		window.show();
	}
}




















