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
			Parent root = FXMLLoader.load(getClass().getResource("FXML_Unsigned_Finish.fxml"));
			Scene scene = new Scene(root, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
		            java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

			scene.getStylesheets().add(getClass().getResource("FXML_Start.fxml").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RunnerRunner");
			primaryStage.centerOnScreen();
			primaryStage.setMinHeight(640);
			primaryStage.setMinWidth(860);
			primaryStage.setMaxHeight(1080);
			primaryStage.setMaxWidth(1920);
			//primaryStage.setFullScreen(true);
			//primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(1.5));
			//primaryStage.minHeightProperty().bind(scene.widthProperty().divide(1.5));



			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}