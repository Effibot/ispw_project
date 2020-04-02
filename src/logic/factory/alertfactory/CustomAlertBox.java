package logic.factory.alertfactory;


import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.StageStyle;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomAlertBox extends Alert {

	// Default case, for exception not mapped yet.

	public CustomAlertBox(Exception e) {
		super(AlertType.ERROR);
		this.setTitle("Exception not mapped");
		this.setHeaderText("This exception is not mapped");
		this.setContentText("If you want to help our team, please contact us\n"
				+ "and send the text in the dialog below.");
		setDialog(this, e);
		display();
	}

	// For mapped exception

	public CustomAlertBox(AlertType alertType, Exception e) {
		super(alertType);
		String title = e.getMessage();
		String header = e.getCause().toString();
		this.setTitle(title);
		this.setHeaderText(header);
		display();
	}

	// Edit alert style and display it.
	public void display() {
		this.initStyle(StageStyle.UNDECORATED);
		this.showAndWait();
	}
	
	// Setting up the dialog in case of unmapped exceptions.
	
	public void setDialog(CustomAlertBox alert, Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		TextArea area = new TextArea(sw.toString());
		alert.getDialogPane().setExpandableContent(area);
	}
}
