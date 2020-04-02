package logic.entity;

import java.sql.Date;
import java.sql.Time;

public class Session {
	private int sessionId;
	private String trainername;
	private int courseId;
	private boolean isPrivate;
	private Time timeStart;
	private Time timeEnd;
	private Date date;
	private String description;
	private Gym gym;
	
	private Time[] duration;
	
	public Session(int sessionId, Gym gym, Time[] duration, Date date, String description) {
		setSessionId(sessionId);
		setGym(gym);
		setDuration(duration);
		setDate(date);
		setDescription(description);
	}
	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	public Time getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}
	public Time getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Time[] getDuration() {
		return duration;
	}

	public void setDuration(Time[] duration) {
		this.duration = duration;
	}

	public String printDuration(Time[] duration) {
		return duration[0].toString()+" - "+duration[1].toString();
	}
	
}
