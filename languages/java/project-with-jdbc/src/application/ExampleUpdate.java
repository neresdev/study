package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import db.DB;

public class ExampleUpdate {

    private static Logger log = Logger.getLogger(ExampleInsert.class.getName());

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                "UPDATE seller "
                + "SET BaseSalary = BaseSalary + ? "
                + "WHERE "
                + "(DepartmentId = ?)");
            
            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            log.info("Done! Rows affected: " + rowsAffected);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    
}
