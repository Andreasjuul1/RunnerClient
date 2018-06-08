/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andreas
 */
public class FXML_Start_Controller implements Initializable {

    @FXML // fx:id="button"
    private Button btnSigned; 

    @FXML // fx:id="btnLogin"
    private Button btnUnsigned; 




    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnSigned)
            {
                changePage(btnSigned,"FXML_Signed.fxml");
            }
        else if (event.getSource() == btnUnsigned)
        	{
        		changePage(btnUnsigned,"FXML_Unsigned.fxml");
        	}
    }
    private void changePage(Button btn, String dokument) throws IOException
    {
        Stage stage;
        Parent root;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(dokument));
        Scene scene = new Scene(root);                                                      
        stage.centerOnScreen();
        stage.setResizable(true);
		stage.setFullScreen(true);
        stage.show();                                                                     
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}