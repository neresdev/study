package app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import entities.People;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Enter a file path and file name: ");
        String path = sc.nextLine();

        LOGGER.info("Enter salary: ");
        Double salary = sc.nextDouble();

        List<People> people = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
            String line = br.readLine();

            while(line != null){
                var lineSplit = line.split(",");
                people.add(new People(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2])));
                line = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        var emailWithBiggerSalary = people.stream()
                                        .filter(p -> p.getSalary() > salary)
                                        .map(People::getEmail)
                                        .sorted(comp);

        var sumSalary = people.stream()
                        .filter(p -> p.getName().startsWith("M"))
                        .map(People::getSalary)
                        .reduce(0.0, (x, y) -> x + y);
        LOGGER.info("Email of people whose salary is more than " + salary);
        emailWithBiggerSalary.forEach(LOGGER::info);

        LOGGER.info("Sum of salary of people whose name starts with 'M' " + sumSalary);
        sc.close();
    }
}