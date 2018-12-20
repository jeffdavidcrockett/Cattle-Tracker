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


public class FinancialReports 
{
	final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
    
	public BorderPane display(Scene dashboardScene, Scene cowScreenScene,
			Stage window, DBConnect db)
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
		
		// Center pane ************************************************************************************************
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = 
				new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("Test Chart");
		xAxis.setLabel("Country");
		yAxis.setLabel("Value");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("2003");
		series1.getData().add(new XYChart.Data(austria, 25601.34));
		series1.getData().add(new XYChart.Data(brazil, 20148.82));
		series1.getData().add(new XYChart.Data(france, 10000));
		series1.getData().add(new XYChart.Data(italy, 35407));
		series1.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));
        
        bc.getData().addAll(series1, series2);
        
        final CategoryAxis xAxis2 = new CategoryAxis();
		final NumberAxis yAxis2 = new NumberAxis();
        final BarChart<String, Number> bc2 =
        		new BarChart<String, Number>(xAxis2, yAxis2);
        bc2.setTitle("Test Chart 2");
        xAxis2.setLabel("Country");
		yAxis2.setLabel("Value");
        
        XYChart.Series series3 = new XYChart.Series();
		series3.setName("2003");
		series3.getData().add(new XYChart.Data(austria, 25601.34));
		series3.getData().add(new XYChart.Data(brazil, 20148.82));
		series3.getData().add(new XYChart.Data(france, 10000));
		series3.getData().add(new XYChart.Data(italy, 35407));
		series3.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series4 = new XYChart.Series();
        series4.setName("2004");
        series4.getData().add(new XYChart.Data(austria, 57401.85));
        series4.getData().add(new XYChart.Data(brazil, 41941.19));
        series4.getData().add(new XYChart.Data(france, 45263.37));
        series4.getData().add(new XYChart.Data(italy, 117320.16));
        series4.getData().add(new XYChart.Data(usa, 14845.27));
        
        bc2.getData().addAll(series3, series4);
        
        final CategoryAxis xAxis3 = new CategoryAxis();
		final NumberAxis yAxis3 = new NumberAxis();
		final BarChart<String, Number> bc3 = 
				new BarChart<String, Number>(xAxis3, yAxis3);
		bc3.setTitle("Test Chart");
		xAxis3.setLabel("Country");
		yAxis3.setLabel("Value");
		
		XYChart.Series series5 = new XYChart.Series();
		series5.setName("2003");
		series5.getData().add(new XYChart.Data(austria, 25601.34));
		series5.getData().add(new XYChart.Data(brazil, 20148.82));
		series5.getData().add(new XYChart.Data(france, 10000));
		series5.getData().add(new XYChart.Data(italy, 35407));
		series5.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series6 = new XYChart.Series();
        series6.setName("2004");
        series6.getData().add(new XYChart.Data(austria, 57401.85));
        series6.getData().add(new XYChart.Data(brazil, 41941.19));
        series6.getData().add(new XYChart.Data(france, 45263.37));
        series6.getData().add(new XYChart.Data(italy, 117320.16));
        series6.getData().add(new XYChart.Data(usa, 14845.27));
        
        bc3.getData().addAll(series5, series6);
        
        final CategoryAxis xAxis4 = new CategoryAxis();
		final NumberAxis yAxis4 = new NumberAxis();
		final BarChart<String, Number> bc4 = 
				new BarChart<String, Number>(xAxis4, yAxis4);
		bc4.setTitle("Test Chart");
		xAxis4.setLabel("Country");
		yAxis4.setLabel("Value");
		
		XYChart.Series series7 = new XYChart.Series();
		series7.setName("2003");
		series7.getData().add(new XYChart.Data(austria, 25601.34));
		series7.getData().add(new XYChart.Data(brazil, 20148.82));
		series7.getData().add(new XYChart.Data(france, 10000));
		series7.getData().add(new XYChart.Data(italy, 35407));
		series7.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series8 = new XYChart.Series();
        series8.setName("2004");
        series8.getData().add(new XYChart.Data(austria, 57401.85));
        series8.getData().add(new XYChart.Data(brazil, 41941.19));
        series8.getData().add(new XYChart.Data(france, 45263.37));
        series8.getData().add(new XYChart.Data(italy, 117320.16));
        series8.getData().add(new XYChart.Data(usa, 14845.27));
        
        bc4.getData().addAll(series7, series8);
        
        
        HBox graphBox1 = new HBox();
        graphBox1.getChildren().addAll(bc, bc2);
        graphBox1.setAlignment(Pos.CENTER);
        
        HBox graphBox2 = new HBox();
        graphBox2.getChildren().addAll(bc3, bc4);
        graphBox2.setAlignment(Pos.CENTER);
        
        mainGrid.add(graphBox1, 0, 0);
        mainGrid.add(graphBox2, 0, 1);
		
		
		// Main layout ************************************************************************************************
		BorderPane mainLayout = new BorderPane();
		mainLayout.setRight(rightPane);
		mainLayout.setCenter(mainGrid);
		
		dashButton.setOnAction(e -> window.setScene(dashboardScene));
		addCowButton.setOnAction(e -> window.setScene(cowScreenScene));
		
		
		
		return mainLayout;
	}
}
