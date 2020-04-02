package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.sql.Time;
import java.util.StringTokenizer;


public class CardViewController {
	@FXML
	private AnchorPane cardAnchor;

	@FXML
	private GridPane grid;

	@FXML
	private Text sessionName;

	@FXML
	private Text date;

	@FXML
	private Text gymName;

	@FXML
	private Text duration;

	@FXML
	private Text description;

	public String getSessionName() {
		return sessionName.getText();
	}


	public void setSessionName(String sessionName) {
		this.sessionName.setText(sessionName);
	}


	public String getDate() {
		return date.getText();
	}


	public void setDate(String date) {
		this.date.setText(date);
	}


	public String getGymName() {
		return gymName.getText();
	}


	public void setGymName(String gymName) {
		this.gymName.setText(gymName);
	}


	public Time[] getDuration() {
		StringTokenizer s = new StringTokenizer(duration.getText());
		Time[] d = {};
		while(s.hasMoreTokens() && !s.nextToken().equals("-")) {
			d[d.length] = Time.valueOf(s.nextToken());
		}
		return d;
	}


	public void setDuration(String duration) {
		this.duration.setText(duration);
	}


	public String getDescription() {
		return description.getText();
	}


	public void setDescription(String description) {
		this.description.setText(description);
	}


	@FXML
	void initialize() {
		assert cardAnchor != null : "fx:id=\"cardAnchor\" was not injected: check your FXML file 'Card.fxml'.";
		assert grid != null : "fx:id=\"grid\" was not injected: check your FXML file 'Card.fxml'.";
		assert sessionName != null : "fx:id=\"sessionName\" was not injected: check your FXML file 'Card.fxml'.";
		assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'Card.fxml'.";
		assert gymName != null : "fx:id=\"gymName\" was not injected: check your FXML file 'Card.fxml'.";
		assert duration != null : "fx:id=\"duration\" was not injected: check your FXML file 'Card.fxml'.";
		assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'Card.fxml'.";

	}
}