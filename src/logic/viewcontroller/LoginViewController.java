package logic.viewcontroller;

import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import logic.bean.LoginBean;
import logic.controller.LoginController;
import logic.controller.MainController;
import logic.factory.viewfactory.ViewFactory;
import logic.factory.viewfactory.ViewType;
import logic.view.View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginViewController {
	private final Logger logger = Logger.getLogger(getClass().getName());
	@FXML
	private HBox topMenu;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnNoAcc;
	@FXML
	private Button btnSignUp;
	@FXML
	private ImageView btnBack;
	@FXML
	private Circle btnClose;
	@FXML
	private Circle btnExpand;
	@FXML
	private Circle btnReduce;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField tfPwd;
	@FXML
	private TextField tfEmailAddr;
	@FXML
	private Pane pnSignUp;
	@FXML
	private Pane pnSignIn;
	@FXML
	private AnchorPane anchRoot;

	@FXML
	private void handleButtonEvent(ActionEvent event) throws IOException {
		if (event.getSource().equals(btnNoAcc)) {
			loginAnimation(true);
		}
		if (event.getSource().equals(btnSignUp)) {
			String email = tfEmailAddr.getText();
			if (!email.equals(""))
				logger.log(Level.INFO, "Sending email to: " + tfEmailAddr.getText());
		}
		if (event.getSource().equals(btnLogIn)) {
			loginTransitions();
		}
	}

	@FXML
	private void onEnter(KeyEvent key) throws IOException {
		if (key.getCode().equals(KeyCode.ENTER)) {
			loginTransitions();
		}
	}

	private void loginTransitions() throws IOException {
		String username = tfUsername.getText();
		String password = tfPwd.getText();
		if (!username.equals("") && !password.equals("")) {
			LoginController ctrl = new LoginController();
			LoginBean bean = new LoginBean(username, password);
			if (ctrl.checkAuthentication(bean)) {
				MainController.getInstance().setId(bean.getId());
				ViewFactory factory = ViewFactory.getInstance();
				View view;
				if (bean.getType()) {
					view = factory.createView(ViewType.GYMPAGE);
				} else {
					view = factory.createView(ViewType.USERPAGE);
				}
				MainController.getInstance().replace(MainController.getContainer(), view);
			}
		}
	}

	@FXML
	private void handleMouseEvent(MouseEvent event) {
		if (event.getSource() == btnClose) {
			System.exit(0);
		}
		if (event.getSource().equals(btnBack)) {
			loginAnimation(false);
		}
	}

	private void loginAnimation(boolean animation) {
		if (animation) {
			new ZoomOut(pnSignIn).play();
			pnSignIn.toBack();
			new ZoomIn(pnSignUp).play();
			pnSignUp.setVisible(true);
			pnSignUp.toFront();
		} else {
			new ZoomOut(pnSignUp).play();
			pnSignUp.toBack();
			new ZoomIn(pnSignIn).play();
			pnSignIn.toFront();
		}
	}

	@FXML
	void initialize() {
		assert topMenu != null : "fx:id=\"topMenu\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnReduce != null : "fx:id=\"btnReduce\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnExpand != null : "fx:id=\"btnExpand\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'scene.fxml'.";
		assert pnSignUp != null : "fx:id=\"pnSignUp\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfEmailAddr != null : "fx:id=\"tfEmailAddr\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'scene.fxml'.";
		assert pnSignIn != null : "fx:id=\"pnSignIn\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfUsername != null : "fx:id=\"tfUsername\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfPwd != null : "fx:id=\"tfPwd\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnNoAcc != null : "fx:id=\"btnNoAcc\" was not injected: check your FXML file 'scene.fxml'.";
	}
}
