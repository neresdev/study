package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import db.DB;
import db.DbIntegratyException;

public class ExampleDelete {
    private static Logger log = Logger.getLogger(ExampleDelete.class.getName());

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
            "DELETE FROM department "
            + "WHERE "
            + "Id = ?");
            
            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();
            log.info("Done! Rows affected: " + rowsAffected);
        }catch(SQLException e){
            throw new DbIntegratyException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
