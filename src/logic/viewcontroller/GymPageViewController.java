package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.controller.MainController;
import logic.factory.alertfactory.AlertFactory;
import logic.factory.viewfactory.ViewFactory;
import logic.factory.viewfactory.ViewType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GymPageViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Hyperlink viewRecorder;

	@FXML
	private ImageView userIcon;

	@FXML
	private ImageView logOutIcon;

	@FXML
	private Button newTrainer;

	@FXML
	private Button newSession;

	@FXML
	private ListView<?> reviewList;

	@FXML
	private ListView<?> sessionList;

	@FXML
	private ImageView sideUserIcon;

	@FXML
	private Label sideUsername;

	@FXML
	private Label sideGymName;

	@FXML
	private Label sideGymStreet;

	MainController ctrl = MainController.getInstance();
	ViewFactory factory = ViewFactory.getInstance();
	public void handleMouseEvent(MouseEvent event) {
		if(event.getSource().equals(logOutIcon)) {
			try {
				ctrl.replace(MainController.getContainer(), factory.createView(ViewType.LOGIN));
			} catch (IOException e) {
				AlertFactory.getInstance().createAlert(e);
			}
		}	
	}
	
	@FXML
	private void onMouseClickedEvent(MouseEvent event) {
		if(event.getSource().equals(newSession)) {
			try {
				ctrl.replace(MainController.getContainer(), factory.createView(ViewType.OFFERTRAININGFORM));
			} catch (IOException e) {
				AlertFactory.getInstance().createAlert(e);
			}
		}
	}
	@FXML
	void initialize() {
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert viewRecorder != null : "fx:id=\"viewRecorder\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert userIcon != null : "fx:id=\"userIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert logOutIcon != null : "fx:id=\"logOutIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert newTrainer != null : "fx:id=\"newTrainer\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert newSession != null : "fx:id=\"newSession\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert reviewList != null : "fx:id=\"reviewList\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sessionList != null : "fx:id=\"sessionList\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideUserIcon != null : "fx:id=\"sideUserIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideUsername != null : "fx:id=\"sideUsername\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideGymName != null : "fx:id=\"sideGymName\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideGymStreet != null : "fx:id=\"sideGymStreet\" was not injected: check your FXML file 'GymPage.fxml'.";
	}
}
