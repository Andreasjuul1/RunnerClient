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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FXML_Start_Login_OldCard_Controller {


    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

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
    	if(event.getSource() == btnCancel)
		{
			changePage(btnCancel, "FXML_Start_Scan.fxml");
		}

        if (event.getSource() == btnLogin)
            {
        		Boolean valid = false;
        		Boolean valid2 = false;


        		try {
        			UserTokenLogic t1 = new UserTokenLogic();
        			valid = t1.getToken(txtUsername.getText(), txtPassword.getText());
        			System.out.println("kortnummer: " + CardStorage.getInstance().getCardNumber());
        			CardToUser CTU = new CardToUser();
        			valid2 = CTU.addCardToUser(CardStorage.getInstance().getCardNumber());
        			System.out.println("Card added? " + valid2);



        			Boolean signed = new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID(), CardStorage.getInstance().getCardNumber());

        			System.out.println("Er bruger tilmeldt? " + signed);
        			System.out.println("hent token " + valid);
        			System.out.println("Tilføj kort til bruger " + valid2);
        			System.out.println("tilmeldt løb? " + signed);

        			if (!signed){
        				UserSignup us = new UserSignup();
        				us.addUsertoRun(RunIDStorage.getInstance().getRunID());
        			}

        			if(valid && valid2){
        				changePage(btnLogin,"FXML_Start_Run.fxml");
        			}

        		}

        		catch (IOException e1) {

        	}
        }
      }
}
