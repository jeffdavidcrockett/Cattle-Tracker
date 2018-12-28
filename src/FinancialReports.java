import java.util.ArrayList;
import java.util.Calendar;
import Data.DBConnect;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.chart.*;


public class FinancialReports 
{
	final static String feed = "Feed";
    final static String equipment = "Equipment";
    final static String vet = "Veterinary";
    final static String italy = "Italy";
    final static String usa = "USA";
    String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	String previousYear1 = Integer.toString(Integer.parseInt(currentYear) - 1);
	String previousYear2 = Integer.toString(Integer.parseInt(currentYear) - 2);
	String previousYear3 = Integer.toString(Integer.parseInt(currentYear) - 3);
    static String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    
    private int getAvgHayPricePaid(String year, DBConnect db)
    {
    	ArrayList<String> hayPrices = new ArrayList<String>();
    	
    	hayPrices = db.getAvgHayPrices(year);
		int hayAverage = 0;
		if (hayPrices != null)
		{
			int hayTotalCurrent = 0;
			for (int i = 0; i < hayPrices.size(); i++)
			{
				hayTotalCurrent += Integer.parseInt(hayPrices.get(i));
			}
			hayAverage = hayTotalCurrent / hayPrices.size();
		}
		
		return hayAverage;
    }
    
    private int getFeedCosts(String year, DBConnect db)
    {
    	ArrayList<String> allFeedCosts = new ArrayList<String>();
    	
    	allFeedCosts = db.getTotalFeedCosts(year);
		int feedCost = 0;
		if (allFeedCosts != null)
		{
			for (int i = 0; i < allFeedCosts.size(); i++)
			{
				feedCost += Integer.parseInt(allFeedCosts.get(i));
			}
		}
		
		return feedCost;
    }
    
    private int getEquipCost(String year, DBConnect db)
    {
    	ArrayList<String> allEquipmentCosts = new ArrayList<String>();
    	
    	allEquipmentCosts = db.getTotalEquipmentCosts(year);
		int equipCost = 0;
		if (allEquipmentCosts != null)
		{
			for (int i = 0; i < allEquipmentCosts.size(); i++)
			{
				equipCost += Integer.parseInt(allEquipmentCosts.get(i));
			}
		}
		
		return equipCost;
    }
    
    private int getVetCost(String year, DBConnect db)
    {
    	ArrayList<String> allVeterinaryCosts = new ArrayList<String>();
    	
    	allVeterinaryCosts = db.getTotalVetCosts(year);
		int vetCost = 0;
		if (allVeterinaryCosts != null)
		{
			for (int i = 0; i < allVeterinaryCosts.size(); i++)
			{
				vetCost += Integer.parseInt(allVeterinaryCosts.get(i));
			}
		}
		
		return vetCost;
    }
    
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
		System.out.println(feedCostCurrent);
		
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
        
        XYChart.Series series3 = new XYChart.Series();
		series3.setName("Average Hay Price Paid");
		series3.getData().add(new XYChart.Data(previousYear3, avgHayPricePrev3));
		series3.getData().add(new XYChart.Data(previousYear2, avgHayPricePrev2));
		series3.getData().add(new XYChart.Data(previousYear1, avgHayPricePrev1));
		series3.getData().add(new XYChart.Data(currentYear, avgHayPriceCurrent));
        
        avgHayPrices.getData().addAll(series3);
        
        final CategoryAxis xAxis3 = new CategoryAxis();
		final NumberAxis yAxis3 = new NumberAxis();
		final BarChart<String, Number> bc3 = 
				new BarChart<String, Number>(xAxis3, yAxis3);
		bc3.setTitle("Test Chart");
		xAxis3.setLabel("Country");
		yAxis3.setLabel("Value");
		
		XYChart.Series series5 = new XYChart.Series();
		series5.setName("2003");
		series5.getData().add(new XYChart.Data(italy, 35407));
		series5.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series6 = new XYChart.Series();
        series6.setName("2004");
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
		series7.getData().add(new XYChart.Data(italy, 35407));
		series7.getData().add(new XYChart.Data(usa, 12000));
		
		XYChart.Series series8 = new XYChart.Series();
        series8.setName("2004");
        series8.getData().add(new XYChart.Data(italy, 117320.16));
        series8.getData().add(new XYChart.Data(usa, 14845.27));
        
        bc4.getData().addAll(series7, series8);
        
        
        HBox graphBox1 = new HBox();
        graphBox1.getChildren().addAll(generalExpenses, avgHayPrices);
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
		
		
		
		return mainLayout;
	}
}
