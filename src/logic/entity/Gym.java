package logic.entity;
import java.util.Map;

public class Gym {
	

	private int gymId;
	private String gymName;
	private int managerId;
	private String managerName;
	private String street;
	private Map<Integer, String> trainers;
	private Map<Integer, String> courses;
	
	public Gym() {}
	public Gym(int gymId, String gymName, int managerId,
               String managerName, String street,
               Map<Integer, String> trainers,
               Map<Integer, String> courses) {
		setGymId(gymId);
		setGymName(gymName);
		setManagerId(managerId);
		setManagerName(managerName);
		setstreet(street);
		setTrainers(trainers);
		setCourses(courses);
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getstreet() {
		return street;
	}
	public void setstreet(String street) {
		this.street = street;
	}
	public Map<Integer, String> getTrainers() {
		return trainers;
	}
	public void setTrainers(Map<Integer, String> trainers) {
		this.trainers = trainers;
	}
	public Map<Integer, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<Integer, String> courses) {
		this.courses = courses;
	}
}