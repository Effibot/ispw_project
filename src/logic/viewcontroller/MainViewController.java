package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import logic.controller.MainController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{
	
    @FXML
    private AnchorPane main;
    
	@FXML
	private HBox topMenu;

	@FXML
	private BorderPane container;
	
	@FXML
	private Circle btnReduce;

	@FXML
	private Circle btnExpand;

	@FXML
	private Circle btnClose;

	@FXML
	private Button place;

	@FXML
	private void onMouseClickedEvent(MouseEvent event){
		if(event.getSource()==btnClose) {
			System.exit(0);
		}
		if(event.getSource()==btnReduce) {
			Stage stage = (Stage)main.getScene().getWindow();
			stage.setIconified(true);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MainController.setContainer(container);
	}	
}