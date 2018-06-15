package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXML_Finish_End_NotSigned_Controller implements Initializable {

    @FXML
    private Button btnOK;

    private void changePage(Button btn, String dokument) throws IOException
    {
        Stage stage;
        Parent root;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(dokument));
        Scene scene = new Scene(root);
        stage.setMaximized(true);
		stage.setScene(scene);

		stage.show();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnOK)
            {
        	changePage(btnOK, "FXML_Finish_Scan.fxml");
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}