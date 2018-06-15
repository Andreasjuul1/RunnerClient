package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import API.AttendingRun;
import API.CardStorage;
import API.RunIDStorage;
import API.TokenStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Andreas
 */
public class FXML_Finish_Choose_Controller implements Initializable {

    @FXML // fx:id="btnLogin"
    private Button btnLogin;

    @FXML // fx:id="button"
    private Button btnNoUser;




    private void changePage(Button btn, String dokument) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(dokument));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnLogin)
            {
        		if (!new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID(),CardStorage.getInstance().getCardNumber()))
        		{
				changePage(btnLogin, "FXML_Finish_Login.fxml");
        		}
        	changePage(btnLogin, "FXML_Finish_Login");
            }
        else if (event.getSource() == btnNoUser)
        	{
        		changePage(btnNoUser,"FXML_Finish_End_NoLogin.fxml");
        		System.out.println("Ingen Bruger");
        	}
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}