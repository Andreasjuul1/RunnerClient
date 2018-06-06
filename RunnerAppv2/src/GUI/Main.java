package GUI;

import java.awt.geom.Rectangle2D;
import com.sun.glass.ui.Screen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import com.sun.glass.ui.Screen;
import javafx.application.Application;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FXML_Start.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("FXML_Start.fxml").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RunnerRunner");
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);

			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}