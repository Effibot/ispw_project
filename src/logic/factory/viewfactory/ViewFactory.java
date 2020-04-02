package logic.factory.viewfactory;

import logic.view.*;

import java.io.IOException;

public class ViewFactory {
	private static ViewFactory instance = null;
	private ViewFactory() {}
	public static synchronized ViewFactory getInstance() {
		if(instance == null) {
			instance = new ViewFactory();
		}
		return instance;
	}
	public View createView(ViewType view) throws IOException{
		switch(view.getType()) {
		case 0:
			return new LoginView(view);
		case 1: // return gymPage
			return new GymPageView(view);
		case 2: // return userPage
			return new UserPageView(view);
		case 3: // return offerTraining
			return new TrainingFormView(view);
		case 5:
			return new TrainingConfView(view);
		default:
			throw new IOException("Factory exception: view not found");
		}
	}
}