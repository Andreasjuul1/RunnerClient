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
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import API.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Andreas
 */
public class FXML_Finish_Run_Controller implements Initializable {

	@FXML
	private Button btnOK;

	@FXML
	private Text txtTime;

	private void changePage(Button btn, String dokument) throws IOException {
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
		if (event.getSource() == btnOK) {

			changePage(btnOK, "FXML_Finish_Scan.fxml");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		GetFinishTime cft = new GetFinishTime();
		try {
			cft.userFinishTime(RunIDStorage.getInstance().getRunID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(cft.userFinishTime(RunIDStorage.getInstance().getRunID()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			txtTime.setText(cft.userFinishTime(RunIDStorage.getInstance().getRunID()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}