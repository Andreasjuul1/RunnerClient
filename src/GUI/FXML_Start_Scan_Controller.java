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
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import API.*;

/**
 *
 * @author Andreas Juul Rasmussen
 */
public class FXML_Start_Scan_Controller implements Initializable {

    @FXML // fx:id="btnAnnuler"
    private Button btnCancel;

    @FXML // fx:id="txtPassword"
    private PasswordField txtCardNumber;



    //funktionen der h�ndterer sideskiftet
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
        		Boolean exist = false;

        		try{
        			CheckCard check = new CheckCard();
        			exist = check.getCard(txtCardNumber.getText());

        			API.CardStorage.getInstance().setCardNumber(txtCardNumber.getText());
        			System.out.println("findes kortet " + exist);
        			if(exist == true)
        				{
        					Boolean att = new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID(), CardStorage.getInstance().getCardNumber());

        					System.out.println("CardStorage:   " + CardStorage.getInstance().getCardNumber());
        					System.out.println("RunIDStorage:   " + RunIDStorage.getInstance().getRunID());

        					if(!att){
        						System.out.println("Bruger ikke tilmeldt l�bet");
        						changePage(btnCancel, "FXML_Start_Login.fxml");
        					}
    					}
    				else
    					{
    						changePage(btnCancel, "FXML_Start_Choose.fxml");
    						System.out.println("V�lg bruger type, p� ukendt kort");

    					}
        			}


        		catch (Exception e) {
					// TODO: handle exception
				}

        	}
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}