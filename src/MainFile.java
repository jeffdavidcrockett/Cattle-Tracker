import Data.DBConnect;
import javafx.application.Application;
import javafx.stage.Stage;

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