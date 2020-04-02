package logic.factory.viewfactory;

import java.net.URL;

public enum ViewType {
	LOGIN(0, "/logic/fxml/Login.fxml"),
	GYMPAGE(1, "/logic/fxml/GymPage.fxml"),
	USERPAGE(2, "/logic/fxml/UserPage.fxml"),
	OFFERTRAININGFORM(3, "/logic/fxml/OfferTrainingForm.fxml"),
	BOOKINGFORM(4, "/logic/fxml/BookingForm.fxml"),
	OFFERTRAININGCONFIRMATION(5, "/logic/fxml/OfferTrainingConfirmation.fxml"),
	CARD(6, "/logic/fxml/Card.fxml");
	/* MAX SUBVIEW DIM: 900 x 542
	 * */

	private final int type;
	private final String path;
	private ViewType(int t, String p){
		this.type = t;
		this.path = p;
	}
	public static ViewType getView(int type) {
		for(ViewType subview : ViewType.values()) if(subview.type == type) return subview;
		throw new IllegalArgumentException("Unable to find the requested view("+type+")");
	}

	public int getType() {
		return type;
	}

	public static URL getUrl(ViewType subview){
		return ViewType.class.getResource(subview.path);
	}
}