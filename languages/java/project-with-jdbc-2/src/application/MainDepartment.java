package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class MainDepartment {
    private static Logger log = Logger.getLogger(MainDepartment.class.getName());
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var departmentDao = DaoFactory.createDepartMentDao();

        log.info("Test 1: Insert");
        var departmentToBeInserted = new Department(null, "New Department");
        departmentDao.insert(departmentToBeInserted);

        log.info("Test 2: Update");
        var departmentToBeUpdated = departmentDao.findById(2);
        departmentToBeUpdated.setName("Name updated at: " + new Date());
        departmentDao.update(departmentToBeUpdated);

        log.info("Test 4: deleteById");
        log.info("Enter the id of department to be deleted");
        var departmentId = sc.nextInt();
        departmentDao.deleteById(departmentId);

        log.info("Test 4: findById");
        var result = departmentDao.findById(2);
        log.info(result.toString());

        log.info("Test 4: findAll");
        var resultFindAll = departmentDao.findAll();
        resultFindAll.forEach(d -> log.info(d.toString()));
    }
}
