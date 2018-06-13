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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import API.*;

public class FXML_Login_Controller implements Initializable {


	@FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtRunID;


    private void changePage(Button btn, String dokument) throws IOException
    {
        Stage stage;
        Parent root;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(dokument));
        Scene scene = new Scene(root);
        stage.setMaximized(true);
		stage.setScene(scene);
;
		stage.show();
    }
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == btnLogin)
            {
        		Boolean valid = false;

        		try {
        			TerminalTokenLogic tl = new TerminalTokenLogic();
					valid = tl.getToken(txtUsername.getText(), txtPassword.getText(), txtRunID.getText());

					if(valid == true){
						changePage(btnLogin,"FXML_Main.fxml");
					}
				} catch (IOException e1) {

				}





            }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}