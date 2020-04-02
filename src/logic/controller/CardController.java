package logic.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.entity.Session;
import logic.factory.alertfactory.AlertFactory;
import logic.factory.viewfactory.ViewType;
import logic.viewcontroller.CardViewController;

import java.io.IOException;

public class CardController {

	public Parent createCard(Session s) {
		FXMLLoader loader = new FXMLLoader(ViewType.getUrl(ViewType.CARD));
		Parent card = null;
		try {
			card = loader.load();
		} catch (IOException e) {
			AlertFactory.getInstance().createAlert(e);
		}
		CardViewController controller = loader.getController();
		controller.setDate(s.getDate().toString());
		controller.setGymName(s.getGym().getGymName());
		controller.setDescription(s.getDescription());
		controller.setDuration(s.printDuration(s.getDuration()));
		controller.setSessionName("Session: "+s.getSessionId());
		return card;
	}
}
