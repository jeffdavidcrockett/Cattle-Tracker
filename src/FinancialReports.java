import java.util.ArrayList;
import java.util.Calendar;
import Data.DBConnect;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.geometry.*;
import javafx.scene.chart.*;


public class FinancialReports {
	static int width = (int) Screen.getPrimary().getBounds().getWidth();
	static int height = (int) Screen.getPrimary().getBounds().getHeight();
	final static String feed = "Feed";
    final static String equipment = "Equipment";
    final static String vet = "Veterinary";
    static String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	static String previousYear1 = Integer.toString(Integer.parseInt(currentYear) - 1);
	static String previousYear2 = Integer.toString(Integer.parseInt(currentYear) - 2);
	static String previousYear3 = Integer.toString(Integer.parseInt(currentYear) - 3);
    
    private static int getAvgHayPricePaid(String year, DBConnect db) {
    	ArrayList<String> hayPrices = new ArrayList<String>();
    	
    	hayPrices = db.getHayPrices(year);
		int hayAverage = 0;
		if (hayPrices != null) {
			int hayTotalCurrent = 0;
			for (int i = 0; i < hayPrices.size(); i++) {
				hayTotalCurrent += Integer.parseInt(hayPrices.get(i));
			}
			hayAverage = hayTotalCurrent / hayPrices.size();
		}
		
		return hayAverage;
    }
    
    private static int getFeedCosts(String year, DBConnect db) {
    	ArrayList<String> allFeedCosts = new ArrayList<String>();
    	
    	allFeedCosts = db.getTotalFeedCosts(year);
		int feedCost = 0;
		if (allFeedCosts != null) {
			for (int i = 0; i < allFeedCosts.size(); i++) {
				feedCost += Integer.parseInt(allFeedCosts.get(i));
			}
		}
		
		return feedCost;
    }
    
    private static int getEquipCost(String year, DBConnect db) {
    	ArrayList<String> allEquipmentCosts = new ArrayList<String>();
    	
    	allEquipmentCosts = db.getTotalEquipmentCosts(year);
		int equipCost = 0;
		if (allEquipmentCosts != null) {
			for (int i = 0; i < allEquipmentCosts.size(); i++) {
				equipCost += Integer.parseInt(allEquipmentCosts.get(i));
			}
		}
		
		return equipCost;
    }
    
    private static int getVetCost(String year, DBConnect db) {
    	ArrayList<String> allVeterinaryCosts = new ArrayList<String>();
    	int vetCost = 0;
    	
    	allVeterinaryCosts = db.getTotalVetCosts(year);
		if (allVeterinaryCosts != null) {
			for (int i = 0; i < allVeterinaryCosts.size(); i++) {
				vetCost += Integer.parseInt(allVeterinaryCosts.get(i));
			}
		}
		
		return vetCost;
    }
    
    private static int getAvgCowPrices(String year, DBConnect db) {
    	ArrayList<String> prices = new ArrayList<String>();
    	int totalCowCost = 0;
    	int avgCowPrice = 0;
    	
    	prices = db.getCowCosts(year);
    	if (prices != null) {
    		for (int i = 0; i < prices.size(); i++) {
    			totalCowCost += Integer.parseInt(prices.get(i));
    		}
    		avgCowPrice = totalCowCost / prices.size();
    	}
    	
    	return avgCowPrice;
    }
    
	public static Scene getScene(DBConnect db) {
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
		
		// Center pane ************************************************************************************************
		
		// Get Average Hay Prices
		int avgHayPriceCurrent = getAvgHayPricePaid(currentYear, db);
		int avgHayPricePrev1 = getAvgHayPricePaid(previousYear1, db);
		int avgHayPricePrev2 = getAvgHayPricePaid(previousYear2, db);
		int avgHayPricePrev3 = getAvgHayPricePaid(previousYear3, db);
		
		// Get Total Feed Costs
		int feedCostCurrent = getFeedCosts(currentYear, db);
		int feedCostPrev1 = getFeedCosts(previousYear1, db);
		int feedCostPrev2 = getFeedCosts(previousYear2, db);
		int feedCostPrev3 = getFeedCosts(previousYear3, db);
		
		// Get Total Equipment Costs
		int equipCostCurrent = getEquipCost(currentYear, db);
		int equipCostPrev1 = getEquipCost(previousYear1, db);
		int equipCostPrev2 = getEquipCost(previousYear2, db);
		int equipCostPrev3 = getEquipCost(previousYear3, db);
		
		// Get Total Veterinary Costs
		int vetCostCurrent = getVetCost(currentYear, db);
		int vetCostPrev1 = getVetCost(previousYear1, db);
		int vetCostPrev2 = getVetCost(previousYear2, db);
		int vetCostPrev3 = getVetCost(previousYear3, db);
		
		// Get Average Cow Prices Paid
		int avgCowPriceCurrent = getAvgCowPrices(currentYear, db);
		int avgCowPricePrev1 = getAvgCowPrices(previousYear1, db);
		int avgCowPricePrev2 = getAvgCowPrices(previousYear2, db);
		int avgCowPricePrev3 = getAvgCowPrices(previousYear3, db);
		
		GridPane mainGrid = new GridPane();
		mainGrid.setStyle("-fx-background-color: #1D1E1E;");
		
		// General Expenses Bar Chart
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> generalExpenses = 
				new BarChart<String, Number>(xAxis, yAxis);
		generalExpenses.setTitle("General Expenses");
		xAxis.setLabel("Items");
		yAxis.setLabel("Total Cost");
		
		XYChart.Series generalSeries1 = new XYChart.Series();
		generalSeries1.setName(currentYear);
		generalSeries1.getData().add(new XYChart.Data(feed, feedCostCurrent));
		generalSeries1.getData().add(new XYChart.Data(equipment, equipCostCurrent));
		generalSeries1.getData().add(new XYChart.Data(vet, vetCostCurrent));
		
		XYChart.Series generalSeries2 = new XYChart.Series();
		generalSeries2.setName(previousYear1);
		generalSeries2.getData().add(new XYChart.Data(feed, feedCostPrev1));
		generalSeries2.getData().add(new XYChart.Data(equipment, equipCostPrev1));
		generalSeries2.getData().add(new XYChart.Data(vet, vetCostPrev1));
		
		XYChart.Series generalSeries3 = new XYChart.Series();
		generalSeries3.setName(previousYear2);
		generalSeries3.getData().add(new XYChart.Data(feed, feedCostPrev2));
		generalSeries3.getData().add(new XYChart.Data(equipment, equipCostPrev2));
		generalSeries3.getData().add(new XYChart.Data(vet, vetCostPrev2));
		
		XYChart.Series generalSeries4 = new XYChart.Series();
		generalSeries4.setName(previousYear3);
		generalSeries4.getData().add(new XYChart.Data(feed, feedCostPrev3));
		generalSeries4.getData().add(new XYChart.Data(equipment, equipCostPrev3));
		generalSeries4.getData().add(new XYChart.Data(vet, vetCostPrev3));
        
        generalExpenses.getData().addAll(generalSeries4, generalSeries3, generalSeries2, generalSeries1);
        
        // Average Hay Prices Chart
        final CategoryAxis xAxis2 = new CategoryAxis();
		final NumberAxis yAxis2 = new NumberAxis();
        final BarChart<String, Number> avgHayPrices =
        		new BarChart<String, Number>(xAxis2, yAxis2);
        avgHayPrices.setTitle("Average Hay Prices");
        xAxis2.setLabel("Year");
		yAxis2.setLabel("$ Price per Bail");
        
        XYChart.Series avgHaySeries1 = new XYChart.Series();
        avgHaySeries1.setName("Average Hay Price Paid");
        avgHaySeries1.getData().add(new XYChart.Data(previousYear3, avgHayPricePrev3));
        avgHaySeries1.getData().add(new XYChart.Data(previousYear2, avgHayPricePrev2));
        avgHaySeries1.getData().add(new XYChart.Data(previousYear1, avgHayPricePrev1));
        avgHaySeries1.getData().add(new XYChart.Data(currentYear, avgHayPriceCurrent));
        
        avgHayPrices.getData().addAll(avgHaySeries1);
        
        // Average Cow Prices Chart
        final CategoryAxis xAxis3 = new CategoryAxis();
		final NumberAxis yAxis3 = new NumberAxis();
		final BarChart<String, Number> avgCowPrices = 
				new BarChart<String, Number>(xAxis3, yAxis3);
		avgCowPrices.setTitle("Average Cow Prices");
		xAxis3.setLabel("Year");
		yAxis3.setLabel("$ Avg Price per Cow");
		
		XYChart.Series avgCowSeries1 = new XYChart.Series();
		avgCowSeries1.setName("Average Cow Price Paid");
		avgCowSeries1.getData().add(new XYChart.Data(previousYear3, avgCowPricePrev3));
		avgCowSeries1.getData().add(new XYChart.Data(previousYear2, avgCowPricePrev2));
		avgCowSeries1.getData().add(new XYChart.Data(previousYear1, avgCowPricePrev1));
		avgCowSeries1.getData().add(new XYChart.Data(currentYear, avgCowPriceCurrent));
        
        avgCowPrices.getData().addAll(avgCowSeries1);
     
        Separator separator1 = new Separator();
        separator1.setMinWidth(980);
        HBox separatorBox = new HBox();
        separatorBox.getChildren().addAll(separator1);
        
        HBox graphBox1 = new HBox();
        graphBox1.getChildren().addAll(generalExpenses, avgHayPrices);
        graphBox1.setAlignment(Pos.CENTER);
        
        HBox graphBox2 = new HBox();
        graphBox2.getChildren().addAll(avgCowPrices);
        graphBox2.setAlignment(Pos.CENTER);
        
        mainGrid.add(graphBox1, 0, 0);
        mainGrid.add(separatorBox, 0, 1);
        mainGrid.add(graphBox2, 0, 2);
		
		// Main layout ************************************************************************************************
		BorderPane mainLayout = new BorderPane();
		mainLayout.setRight(rightPane);
		mainLayout.setCenter(mainGrid);
		
		dashButton.setOnAction(e -> MainFile.window.setScene(Dashboard.getScene(db)));
		
		Scene financialReportsScene = new Scene(mainLayout, width, height);
		financialReportsScene.getStylesheets().add(MainFile.class.getResource("styles.css").toExternalForm());
		
		return financialReportsScene;
	}
}
