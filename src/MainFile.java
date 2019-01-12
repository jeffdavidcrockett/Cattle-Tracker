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

public class MainFile extends Application {
	public static Stage window;
	DBConnect db = new DBConnect();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Cattle Tracker");
		window.setScene(Dashboard.getScene(db));
		window.setMaximized(true);
		window.show();
	}
}