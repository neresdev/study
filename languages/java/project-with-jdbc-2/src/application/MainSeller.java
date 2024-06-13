package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import db.DB;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class MainSeller {
    private static Logger log = Logger.getLogger(MainSeller.class.getName());
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        var sellerDao = DaoFactory.createSellerDao(); // dependency ingestion example

        log.info("=== TEST 1: seller findById");
        var seller = sellerDao.findById(3);
        log.info(seller.toString());

        log.info("=== TEST 2: seller findByDepartment");
        var department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(s -> log.info(s.toString()));

        log.info("\n=== TEST 3: seller findAll");
        sellerDao.findAll().forEach(s -> log.info(s.toString()));

        log.info("\n=== TEST 4: seller insert");
        var sellerToBeInserted = new Seller(null, "Deivao", "deivao@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(sellerToBeInserted);

        log.info("\n=== TEST 5: seller update");
        var sellerToBeUpdated = sellerDao.findById(8);
        sellerToBeUpdated.setName("David Neres");
        sellerToBeUpdated.setEmail("neresteste@gmail.com");
        sellerToBeUpdated.setBaseSalary(30000.0);
        sellerDao.update(sellerToBeUpdated);
        log.info("Update completed!");

        log.info("\n=== TEST 6: seller update");
        log.info("Enter id for delete test: ");
        var id = sc.nextInt();
        sellerDao.deleteById(id);
        log.info("Delete completed!");

        DB.closeConnection();
    }
}
