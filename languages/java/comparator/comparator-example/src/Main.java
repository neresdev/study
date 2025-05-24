import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        var path = "resources/employees.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeCsv = br.readLine();

            while(employeeCsv != null) {
                final String[] fields = employeeCsv.split(",");
                final String name = fields[0];
                final Double salary = Double.parseDouble(fields[1]);
//                final LocalDateTime admissionDate = LocalDateTime.parse(fields[2], DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); sem o T
                final LocalDateTime admissionDate = LocalDateTime.parse(fields[2], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                list.add(new Employee(name, salary, admissionDate));
                employeeCsv = br.readLine();
            }

            System.out.println("Lista da data de admissão da mais recente para a mais antiga:");
            Collections.sort(list);
            list.forEach(System.out::println);
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}