package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import API.AttendingRun;
import API.CardStorage;
import API.CheckCard;
import API.GetFinishTime;
import API.RunIDStorage;
import API.SetRunTime;
import API.UserSignup;
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
public class FXML_Finish_Scan_Controller implements Initializable {

	@FXML // fx:id="btnAnnuler"
	private Button btnCancel;

	@FXML // fx:id="txtPassword"
	private PasswordField txtCardNumber;

	// funktionen der håndterer sideskiftet
	private void changePage(Button btn, String dokument) throws IOException {
		Stage stage;
		Parent root;

		stage = (Stage) btn.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource(dokument));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setMaximized(true);
		stage.show();

	}

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		if (event.getSource() == btnCancel) {
			changePage(btnCancel, "FXML_Main.fxml");
		}

		else if (event.getSource() == txtCardNumber)

		{
			Boolean exist = false;

			try {
				CheckCard check = new CheckCard();
				exist = check.getCard(txtCardNumber.getText());

				API.CardStorage.getInstance().setCardNumber(txtCardNumber.getText());

				if (exist) {
					if (!new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID(),
							CardStorage.getInstance().getCardNumber())) {
						changePage(btnCancel, "FXML_Finish_End_NotSigned.fxml");
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						Date date = new Date();
						System.out.println(sdf.format(date));
						SetRunTime srt = new SetRunTime();
						srt.setUserFinishTime(RunIDStorage.getInstance().getRunID(), sdf.format(date));

						changePage(btnCancel, "FXML_Finish_Run.fxml");
					}
				}
				if (!new AttendingRun().userAttending(RunIDStorage.getInstance().getRunID(),
						CardStorage.getInstance().getCardNumber())) {
					changePage(btnCancel, "FXML_Finish_Login.fxml");

				}
				changePage(btnCancel, "FXML_Finish_Choose.fxml");
			} catch (Exception e) {
			}

		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}