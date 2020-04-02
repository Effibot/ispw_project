package logic.entity.dao;


import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final String USR = "postgres";
    private static final String PWD= "postgres";
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final int[] portNumber = {5432};
    private static final String DBNAME = "fitappdb";
    private static final int[] stmtSetUp = {ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY};
    private PGConnectionPoolDataSource cp;

    private List<Map<String, Object>> table;

    protected ConnectionManager() {
        cp = new PGConnectionPoolDataSource();
        cp.setPortNumbers(portNumber);
        cp.setDatabaseName(DBNAME);
        cp.setUser(USR);
        cp.setPassword(PWD);
    }

    /**
     * Creates a connection with the database and launch the query.
     *
     * @param query the query to launch.
     * @return a linked list obtained from the function resultMapping().
     * */
    protected List<Map<String, Object>> connect(String query){
        try(Connection con = cp.getConnection(); // establishing connection.
            Statement st = con.createStatement(stmtSetUp[0], stmtSetUp[1]); // preparing the statement.
            ResultSet rs = st.executeQuery(query)){ // executes the query.
            if(!rs.first()) // checks if result set is empty.
                throw new SQLException("No result found for the query:\n\t"+query);
            return resultMapping(rs);
        } catch (SQLException e){
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return Collections.emptyList();
    }


    /**
     * Converts the result given by a query and storing it in a linked list
     * creating a table-like object.
     *
     * @param rs a ResultSet object to be converted in a table-like structure
     * @return a linked list where each record of the list contains the whole
     * information of one ResultSet cursor.
     *
     * @exception SQLException if a database access error occurs
     * or this method is called on a closed connection
     * */
    protected List<Map<String, Object>> resultMapping (ResultSet rs) throws SQLException {
        this.table = new ArrayList<>();
        ResultSetMetaData rsMeta = rs.getMetaData();
        String colName;
        do{
            int numCol = rsMeta.getColumnCount();
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= numCol; i++) {
                colName = rsMeta.getColumnName(i);
                map.put(colName, rs.getObject(i));
            }
            table.add(map);
        } while(rs.next());
        return this.table;
    }

    public List<Map<String, Object>> getTable() {
        return table;
    }

    public void setTable(List<Map<String, Object>> table) {
        this.table = table;
    }
}
