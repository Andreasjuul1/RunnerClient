/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import API.AttendingRun;
import API.CardStorage;
import API.CardToUser;
import API.RunIDStorage;
import API.UserSignup;
import API.UserTokenLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andreas
 */
public class FXML_Finish_Login_Controller implements Initializable {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;


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
    private void handleButtonAction(ActionEvent event) throws IOException{
    	if(event.getSource() == btnCancel)
		{
			changePage(btnCancel, "FXML_Finish_Scan.fxml");
		}

        if (event.getSource() == btnLogin)
            {
        		Boolean valid = false;
        		Boolean valid2 = false;
        		Boolean valid3 = false;
        		Boolean signed = false;

        		try {
        			UserTokenLogic t1 = new UserTokenLogic();
					valid = t1.getToken(txtUsername.getText(), txtPassword.getText());

					CardToUser CTU = new CardToUser();
					valid2 = CTU.addCardToUser(CardStorage.getInstance().getCardNumber());


					signed = new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID());

					if (!signed){
						UserSignup us = new UserSignup();
						valid3 = us.addUsertoRun(RunIDStorage.getInstance().getRunID());
					}

					if(valid && valid2 && valid3 == true){
						changePage(btnLogin,"FXML_Finish_Run.fxml");
					}
				}
        		catch (IOException e1) {

            	}
        }
      }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}