package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import db.DB;


public class ExampleSelectAll {

    private static Logger LOGGER = Logger.getLogger(ExampleSelectAll.class.getName());

    
    public static void main(String[] args) throws Exception {
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while(rs.next()){
                LOGGER.info(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
        
    }
}
