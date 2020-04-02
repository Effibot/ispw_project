package logic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.factory.alertfactory.AlertFactory;
import logic.factory.viewfactory.ViewType;

import java.io.IOException;

public class View {
	private Parent root;
	
	protected View(ViewType view) {
		FXMLLoader loader = new FXMLLoader(ViewType.getUrl(view));
        try {
            setRoot(loader.load());
        } catch (IOException e) {
            AlertFactory.getInstance().createAlert(e);
        }
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
}