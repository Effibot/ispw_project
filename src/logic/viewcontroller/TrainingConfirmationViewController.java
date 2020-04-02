package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import logic.bean.TrainingFormBean;
import logic.controller.OfferTrainingController;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TrainingConfirmationViewController implements Initializable {

    @FXML
    private Label homeLabel;

    @FXML
    private Label offerTrainingLabel;

    @FXML
    private Text singleText;

    @FXML
    private Text typeText;

    @FXML
    private Text nameText;

    @FXML
    private Text trainerText;

    @FXML
    private Text startHourText;

    @FXML
    private Text startMinuteText;

    @FXML
    private Text endHourText;

    @FXML
    private Text endMinuteText;

    @FXML
    private Text dateText;

    @FXML
    private Text descriptioText;

    @FXML
    private Button okButton;
    
    @FXML
    private Button modifyButton;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	OfferTrainingController otCtrl = OfferTrainingController.getInstance();
    	TrainingFormBean bean = otCtrl.getTrainingBean();

    	if(Boolean.TRUE.equals(bean.getSingle())){
    	    singleText.setText("singolo");
        }
    	if(Boolean.TRUE.equals(bean.getGroup())){
    	    singleText.setText("gruppo");
        }
    	typeText.setText(bean.getTrainingType());
    	nameText.setText(bean.getTrainingName());
    	trainerText.setText(bean.getTrainerName());
/*   added "" to fix smell
    	"startHourText.setText(Integer.toString(bean.getStartHour()));" */
		dateText.setText(bean.getDate().format(formatter));
		descriptioText.setText(bean.getDescription());
    }


    @FXML
    void onMouseClickedEvent(MouseEvent event) {
    	// to be implemented
    }
}
