package logic.entity.dao;

import logic.entity.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SessionDAO extends ConnectionManager {
    private static SessionDAO instance = null;
    private SessionDAO() { super(); }
    public static synchronized SessionDAO getInstance(){
        if(SessionDAO.instance == null){
            SessionDAO.instance = new SessionDAO();
        }
        return SessionDAO.instance;
    }

    public List<Integer> getBooking(Integer userId) {
        ArrayList<Integer> sessionList = new ArrayList<>();
        String sql = "select session_id from booked_session where user_id =" + userId;
        this.setTable(connect(sql));
        Map<String, Object> map;
        for (int i = 0; i < this.getTable().size(); i++) {
            map = this.getTable().get(i);
            sessionList.add((Integer) map.get("session_id"));
        }
        return sessionList;
    }

    public List<Session> getSessionList(List<Integer> listId) {
        String sql = "select session_id, time_start, time_end, gym_id, day, description from training_session";
        this.setTable(connect(sql));
        if(!this.getTable().isEmpty()){
            Integer id;
            ArrayList<Session> bookedSession = new ArrayList<>();
            Map<String, Object> map;
            for(int i = 0; i < this.getTable().size(); i++){
                map = this.getTable().get(i);
                id = (Integer)map.get("session_id");
                if(listId.contains(id)){
                    Time[] duration = {(Time)map.get("time_start"), (Time)map.get("time_end")};
                    bookedSession.add(new Session(id, GymDAO.getInstance().getGymEntity((Integer)map.get("gym_id")),
                            duration, (Date)map.get("day"), (String)map.get("description")));
                }
            }
            return bookedSession;
        }
        return Collections.emptyList();
    }
}
