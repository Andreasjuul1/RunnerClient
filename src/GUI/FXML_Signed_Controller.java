package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.event.*;
import javafx.scene.control.Alert;

/**
 *
 * @author Andreas Juul Rasmussen
 */
public class FXML_Signed_Controller implements Initializable {

    @FXML // fx:id="txtPassword"
    private PasswordField txtCardNumber; 

    @FXML // fx:id="btnAnnuler"
    private Button btnCancel; 


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnCancel)
            {
                changePage(btnCancel,"FXML_Start.fxml");
            }
        else if (event.getSource()== txtCardNumber)

        	{
        		String CardNumber = txtCardNumber.getText();
        				if(CardNumber.equals(null)){

        					Alert alert = new Alert(Alert.AlertType.ERROR);                      
                        	alert.setTitle("Error");
                        	alert.setHeaderText("Kort ikke registeret");
                        	alert.setContentText("Ugyldigt kort nummer");
                        	alert.showAndWait();
        				}
        				else
        				{
        					System.out.println(CardNumber);
        					Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
                        	alert.setTitle("RunnerRunner");
                        	alert.setContentText("Nyt kort tilknyttet bruger");
                        	alert.showAndWait();
        					changePage(btnCancel,"FXML_Signed.fxml");
        				}
        	}
    }


    //funktionen der håndterer sideskiftet
    private void changePage(Button btn, String dokument) throws IOException
    {
        Stage stage;
        Parent root;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(dokument));
        Scene scene = new Scene(root);                                                   
        stage.setScene(scene);	
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