package logic.controller;

import logic.bean.LoginBean;
import logic.entity.dao.UserDAO;
import logic.exception.UserNotFoundException;
import logic.factory.alertfactory.AlertFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public boolean checkAuthentication(LoginBean bean) {
		logger.log(Level.INFO, "Connecting...");
		try {
			return UserDAO.getInstance().checkLogIn(bean);
		} catch (UserNotFoundException e) {
			AlertFactory.getInstance().createAlert(e);
			return false;
		}
	}

}
