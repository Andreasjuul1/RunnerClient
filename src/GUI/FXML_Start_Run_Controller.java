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
public class FXML_Start_Run_Controller implements Initializable {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtStudyID;

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
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnRegister)
            {
        	if (txtUsername.getText().isEmpty() == true && txtEmail.getText().isEmpty() == true && txtPassword.getText().isEmpty() == true && txtStudyID.getText().isEmpty())
        	{
        		System.out.println("Fejl i indtastning af oplysninger");
				Alert alert = new Alert(Alert.AlertType.ERROR);
            	alert.setTitle("Error");
            	alert.setHeaderText("Manglende Oplysninger");
            	alert.setContentText("Udfyld alle felter for fuldendt registering");
            	alert.showAndWait();

        	}
        	else
                changePage(btnRegister,"FXML_Start_Run.fxml");
            }
        else if (event.getSource() == btnCancel)
        	{
        		changePage(btnCancel,"FXML_Start_Scan.fxml");
        	}
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}