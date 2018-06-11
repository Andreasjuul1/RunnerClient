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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 *
 * @author Andreas Juul Rasmussen
 */
public class FXML_Start_Scan_Controller implements Initializable {

    @FXML // fx:id="btnAnnuler"
    private Button btnCancel;

    @FXML // fx:id="txtPassword"
    private PasswordField txtCardNumber;


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
		stage.setMaximized(true);
        stage.show();

    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnCancel)
            {
                changePage(btnCancel,"FXML_Main.fxml");
            }
        else if (event.getSource()== txtCardNumber)

        	{
        		String CardNumber = txtCardNumber.getText();
        				if(CardNumber.equals("1")){

        					System.out.println("Skal tjekke i databasen om kortet er knyttet til en bruger");
        					Alert alert = new Alert(Alert.AlertType.ERROR);
                        	alert.setTitle("Error");
                        	alert.setHeaderText("Kort ikke registeret");
                        	alert.setContentText("Ugyldigt kort nummer");
                        	alert.showAndWait();
                        	changePage(btnCancel, "FXML_Start_Signup.fxml");
        				}
        				else
        				{
        					System.out.println(CardNumber);
        					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        	alert.setTitle("RunnerRunner");
                        	alert.setContentText("Nyt kort tilknyttet bruger");
                        	alert.showAndWait();
                        	System.out.println("Skal tjekke i databasen om kortet er knyttet til en bruger");
        					changePage(btnCancel,"FXML_Start_Run.fxml");
        				}
        	}
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}