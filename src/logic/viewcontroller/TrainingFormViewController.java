package logic.viewcontroller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import logic.bean.TrainingFormBean;
import logic.controller.OfferTrainingController;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainingFormViewController implements Initializable{

	OfferTrainingController otCtrl = OfferTrainingController.getInstance();


	@FXML
	private Label homeLabel;

	@FXML
	private RadioButton singleRButton;

	@FXML
	private ToggleGroup session;

	@FXML
	private RadioButton groupRButton;

	@FXML
	private ChoiceBox<String> trainingTypeCBox;

	@FXML
	private TextField trainingNameTField;

	@FXML
	private ChoiceBox<String> trainerCBox;

	@FXML
	private ComboBox<Integer> startHourCBox;

	@FXML
	private ComboBox<Integer> startMinuteCBox;

	@FXML
	private ComboBox<Integer> endHourCBox;

	@FXML
	private ComboBox<Integer> endMinuteCBox;

	@FXML
	private DatePicker datePicker;

	@FXML
	private TextArea descriptionTArea;

	@FXML
	private Button okButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<String> typeList = otCtrl.getTrainingList();
		trainingTypeCBox.setItems(typeList);
		trainingTypeCBox.setValue(typeList.get(0));

		ObservableList<String> trainerList = otCtrl.getTrainerList();
		trainerCBox.setItems(trainerList);
		trainerCBox.setValue(trainerList.get(0)); 	
		
		startHourCBox.getItems().addAll(hourGenerator());
		startHourCBox.setPromptText("HH");

		startMinuteCBox.getItems().addAll(minuteList);
		startMinuteCBox.setPromptText("MM");

		endHourCBox.getItems().addAll(hourGenerator());
		endHourCBox.setPromptText("HH");

		endMinuteCBox.getItems().addAll(minuteList);
		endMinuteCBox.setPromptText("MM");


	}

	@FXML
	private void onMouseClickedEvent(MouseEvent event){
		if(event.getSource().equals(homeLabel)) {
			//TODO launch home view
		}
		if(event.getSource().equals(okButton)) {

			TrainingFormBean bean = new TrainingFormBean();

			bean.setSingle(singleRButton.isSelected());
			bean.setGroup(groupRButton.isSelected());
			bean.setTrainingType(trainingTypeCBox.getValue());
			bean.setTrainingName(trainingNameTField.getText());
			bean.setTrainerName(trainerCBox.getValue());
			bean.setStartHour(startHourCBox.getValue());
			bean.setStartMinute(startMinuteCBox.getValue());
			bean.setEndHour(endHourCBox.getValue());
			bean.setEndMinute(endMinuteCBox.getValue());
			bean.setDate(datePicker.getValue());
			bean.setDescription(descriptionTArea.getText());

			otCtrl.setTrainingBean(bean);	
			otCtrl.checkValidity();

			//TODO: create check schedule for trainer in OfferTrainingController
		}
	}

	private Integer[] minuteList = {00, 15, 30, 45};

	private Integer[] hourGenerator() {
		Integer[] list = new Integer[24];

		for (int i = 0; i < 24; i++)
			list[i] = i;
		return list;
	}
	
	public void showDateAlert() {
    	Alert dateAlert = new Alert(AlertType.ERROR, "You cannot select a past date", ButtonType.OK);
    	dateAlert.showAndWait();
    	
    	if(dateAlert.getResult() == ButtonType.OK) {
    		dateAlert.close();
    	}
    }
}
