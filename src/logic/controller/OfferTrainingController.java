package logic.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.TrainingFormBean;
import logic.entity.Gym;
import logic.entity.dao.GymDAO;
import logic.factory.alertfactory.AlertFactory;
import logic.factory.viewfactory.ViewFactory;
import logic.factory.viewfactory.ViewType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfferTrainingController {
	
	private static OfferTrainingController instance = null;

	private OfferTrainingController() {}

		public static synchronized OfferTrainingController getInstance(){
			if(OfferTrainingController.instance == null){
				OfferTrainingController.instance = new OfferTrainingController();
			}
			return OfferTrainingController.instance;
		}
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	MainController ctrl = MainController.getInstance();
	private Integer id = 1; 
	private TrainingFormBean trainingBean;

	GymDAO dao = GymDAO.getInstance();

	public ObservableList<String> getTrainingList(){
		return FXCollections.observableArrayList(dao.getTrainingList());
	}

	public ObservableList<String> getTrainerList(){
		ArrayList<String> list = new ArrayList<>();
		Gym g = getGymEntity();
		for(Integer key : g.getTrainers().keySet()) {
			list.add(g.getTrainers().get(key));
		} 
		return FXCollections.observableArrayList(list); 
	}
	
	public void checkValidity() {
		if(trainingBean.getDate().isBefore(LocalDate.now())) {
			ctrl.showDateAlert();
		}
		else {
			logger.log(Level.INFO, "onto confirmation screen");
			try {
				ViewFactory factory = ViewFactory.getInstance();
				ctrl.replace(MainController.getContainer(), factory.createView(ViewType.OFFERTRAININGCONFIRMATION));
			} catch (IOException e) {
				AlertFactory.getInstance().createAlert(e);
			}
		}
	}

	public Gym getGymEntity(/*user name dynamically gotten*/) {
		return dao.getGymEntity(id); //this method is a dummy needs to be implemented
		
	}
	
	public TrainingFormBean getTrainingBean() {
		return trainingBean;
	}

	public void setTrainingBean(TrainingFormBean trainingBean) {
		this.trainingBean = trainingBean;
	}
}

