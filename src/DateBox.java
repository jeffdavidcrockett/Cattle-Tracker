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


public class DateBox
{
	public static ComboBox monthBox;
	public static ComboBox dayBox;
	public static ComboBox yearBox;
	
	public static ComboBox[] createDateBox()
	{
		ComboBox[] dateBoxes = new ComboBox[3];
		
		HBox dateBox = new HBox(5);
		
		ObservableList<String> month = 
			    FXCollections.observableArrayList(
			        "01", "02", "03",
			        "04", "05", "06",
			        "07", "08", "09",
			        "10", "11", "12"
			    );
		monthBox = new ComboBox(month);
		
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
		dayBox = new ComboBox(day);
		
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
		yearBox = new ComboBox(year);
		
//		dateBox.getChildren().addAll(monthBox, dayBox, yearBox);
		dateBoxes[0] = monthBox;
		dateBoxes[1] = dayBox;
		dateBoxes[2] = yearBox;
		
		return dateBoxes;
	}
	
	public static void clearBoxes()
	{
		monthBox.valueProperty().set(null);
		dayBox.valueProperty().set(null);
		yearBox.valueProperty().set(null);
	}
}
