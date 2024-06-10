package application;

import java.util.Date;
import java.util.logging.Logger;

import model.entities.Department;
import model.entities.Seller;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws Exception {
        Department obj = new Department(1, "Books");
        
        Seller seller = new Seller(21, "Neres", "neresdev@gmail.com", new Date(), 7000.0, obj);

        System.out.println(seller);
    }
}
