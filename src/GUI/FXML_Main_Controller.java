/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
public class FXML_Main_Controller implements Initializable {

    @FXML // fx:id="btnLogin"
    private Button btnFinish;

    @FXML // fx:id="button"
    private Button btnStart;




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
        if (event.getSource() == btnStart)
            {
                changePage(btnStart,"FXML_Start_Scan.fxml");
                System.out.println("start scan");
                System.out.println(TokenStorage.getInstance().getTerminalToken());
            }
        else if (event.getSource() == btnFinish)
        	{
        		changePage(btnFinish,"FXML_Finish_Scan.fxml");
        		System.out.println("finish scan");
        	}
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}