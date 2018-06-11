package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
			Scene scene = new Scene(root, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
		            java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

			scene.getStylesheets().add(getClass().getResource("FXML_Login.fxml").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RunnerRunner");
			primaryStage.centerOnScreen();
			primaryStage.setMinHeight(640);
			primaryStage.setMinWidth(860);
			primaryStage.setMaxHeight(1080);
			primaryStage.setMaxWidth(1920);
			primaryStage.setMaximized(true);
			Image icon = new Image(getClass().getResourceAsStream("runner.png"));
			primaryStage.getIcons().add(icon);


			//primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(1.5));
			//primaryStage.minHeightProperty().bind(scene.widthProperty().divide(1.5));



			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}