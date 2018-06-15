/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import API.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andreas
 */
public class FXML_Start_Signup_Controller implements Initializable {


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMiddleName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

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
        if (event.getSource() == btnRegister)
            {
        		Boolean valid = false;
        		Boolean valid2 = false;

        		try {
        			CreateUser CU = new CreateUser();
					valid = CU.CreateaUser(txtUsername.getText(),txtName.getText(), txtMiddleName.getText(), txtLastName.getText(),txtEmail.getText(),txtPassword.getText());

					API.UserTokenLogic ut = new UserTokenLogic();
					ut.getToken(txtUsername.getText(), txtPassword.getText());

					CardToUser CTU = new CardToUser();
					valid2 = CTU.addCardToUser(CardStorage.getInstance().getCardNumber());

					Boolean signedup = new UserSignup().addUsertoRun(RunIDStorage.getInstance().getRunID());

					if(valid && valid2){
						changePage(btnRegister,"FXML_start_Run.fxml");
					}
					else{
					Alert alert = new Alert(Alert.AlertType.ERROR);
                	alert.setTitle("Error");
                	alert.setHeaderText("Fejl i registering");
                	alert.setContentText("Forsøg oprettelse igen");
                	alert.showAndWait();
					}

				} catch (IOException e)
        			{

        			}


			}
        if(event.getSource() == btnCancel)
		{
			changePage(btnCancel, "FXML_Start_Scan.fxml");
		}
        }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}