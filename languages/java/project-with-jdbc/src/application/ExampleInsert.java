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

public class ExampleInsert {

    private static Logger log = Logger.getLogger(ExampleInsert.class.getName());

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            
            st = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "David Neres");
            st.setString(2, "neresdev@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("05/10/2002").getTime()));
            st.setDouble(4, 15000.0);
            st.setInt(5, 4);


            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0 ){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    log.info("Done! Id = " + id);
                }
                
            }else{
                log.info("No row affected!");
            }
            
        }catch(SQLException | ParseException e){
            e.printStackTrace();
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
        
    }
    
}
