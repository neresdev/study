package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import db.DB;
import db.exception.DbException;

public class ExampleTransaction {
    private static Logger log = Logger.getLogger(ExampleTransaction.class.getName());

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            st = conn.createStatement();
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 where DepartmentId = 1");

            /* int x = 1;
            if (x < 2) {
                throw new SQLException("Fake error");
            } */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 where DepartmentId = 2");

            conn.commit();
            log.info("rows1 " + rows1);
            log.info("rows2 " + rows2);
        }catch(SQLException e){
            try{
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }catch(SQLException e1){
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
