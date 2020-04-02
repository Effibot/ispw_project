package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import logic.controller.CardController;
import logic.controller.MainController;
import logic.entity.Session;
import logic.entity.User;
import logic.entity.dao.SessionDAO;
import logic.entity.dao.UserDAO;
import logic.factory.alertfactory.AlertFactory;
import logic.factory.viewfactory.ViewFactory;
import logic.factory.viewfactory.ViewType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserPageViewController {
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
	private BorderPane schedulepane;

	@FXML
	private ListView<Parent> sessionList;

	@FXML
	private ImageView sideUserIcon;

	@FXML
	private Label sideUsername;

	@FXML
	private Label sideGymName;

	@FXML
	private Label sideGymStreet;

	private MainController ctrl = MainController.getInstance();
	private ViewFactory factory = ViewFactory.getInstance();
	private User user;

	public void handleMouseEvent(MouseEvent event) {
		if(event.getSource().equals(logOutIcon)) {
			try {
				ctrl.replace(MainController.getContainer(), factory.createView(ViewType.LOGIN));
			} catch (IOException e) {
				AlertFactory.getInstance().createAlert(e);
			}
		}
	}
	public void fillActiveSessions() {
		SessionDAO sDao = SessionDAO.getInstance();
		// get the id list of booked sessions
		ArrayList<Integer> bookings = (ArrayList<Integer>) sDao.getBooking(user.getUserId());
		// get the actual list
		ArrayList<Session> list = (ArrayList<Session>) sDao.getSessionList(bookings);
		CardController cc = new CardController();
		if(!list.isEmpty()) {
			for (Session s : list) {
				// add the card to the list
				sessionList.getItems().add(cc.createCard(s));
				// set selection mode to single
				sessionList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			}
		}
	}
	
	@FXML
	void initialize() {
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert viewRecorder != null : "fx:id=\"viewRecorder\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert userIcon != null : "fx:id=\"userIcon\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert logOutIcon != null : "fx:id=\"logOutIcon\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert newTrainer != null : "fx:id=\"newTrainer\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert schedulepane != null : "fx:id=\"schedulepane\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert sessionList != null : "fx:id=\"sessionList\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert sideUserIcon != null : "fx:id=\"sideUserIcon\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert sideUsername != null : "fx:id=\"sideUsername\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert sideGymName != null : "fx:id=\"sideGymName\" was not injected: check your FXML file 'UserPage.fxml'.";
		assert sideGymStreet != null : "fx:id=\"sideGymStreet\" was not injected: check your FXML file 'UserPage.fxml'.";

		user = UserDAO.getInstance().getUserEntity(ctrl.getId());
		sideUsername.setText(user.getUsername());
		fillActiveSessions();		
	}
}