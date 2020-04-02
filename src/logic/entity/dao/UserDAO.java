package logic.entity.dao;

import logic.bean.LoginBean;
import logic.entity.User;
import logic.exception.UserNotFoundException;
import java.util.List;
import java.util.Map;

public class UserDAO extends ConnectionManager {
    private static UserDAO instance;

    private UserDAO() {
        super();
    }

    public static synchronized UserDAO getInstance() {
        if (UserDAO.instance == null) {
            UserDAO.instance = new UserDAO();
        }
        return UserDAO.instance;
    }

    public User getUserEntity(Integer userId) {
        String sql = "select username, manager from users where user_id = " + userId;
        this.setTable(connect(sql));
        if (this.getTable().size() == 1) { // checks if there is only one entry for selected user, as expected.
            // copy the map that contains username and isManager value.
            Map<String, Object> map = this.getTable().get(0);
            String username = map.get("username").toString();
            boolean isManager = map.get("manager").equals(true);
            List<Integer> bookedSession = SessionDAO.getInstance().getBooking(userId);
            return new User(userId, username, isManager, bookedSession);
        }
        return null;
    }



    public boolean checkLogIn(LoginBean bean) throws UserNotFoundException {
        String username = bean.getUsername();
        String password = bean.getPassword();
        String query = "select user_id, manager from users where username = '" + username + "' and password = '" + password+"'";
        this.setTable(connect(query));
        if (this.getTable().size() == 1) {
            Map<String, Object> map = this.getTable().get(0);
            bean.setId((Integer) map.get("user_id"));
            bean.setType(map.get("manager").equals(true));
            return true;
        } else { throw new UserNotFoundException(); }
    }

}
