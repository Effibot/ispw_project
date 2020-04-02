package logic.entity;

import java.util.List;

public class User {
    private int userId;
    private String username;
    private boolean isManager;
    private List<Integer> bookedSession;

    public User() {}

    public User(int userId, String username, boolean isManager, List<Integer> bookedSession) {
        setUserId(userId);
        setUsername(username);
        setManager(isManager);
        setBookedSession(bookedSession);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }
    public List<Integer> getBookedSession() {
        return bookedSession;
    }

    public void setBookedSession(List<Integer> bookedSession) {
        this.bookedSession = bookedSession;
    }

}
