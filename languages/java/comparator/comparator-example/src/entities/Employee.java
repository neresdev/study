package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee implements Comparable<Employee> {

    private String name;
    private Double salary;
    private LocalDateTime admissionDate;

    public Employee(String name, Double salary, LocalDateTime admissionDate) {
        this.name = name;
        this.salary = salary;
        this.admissionDate = admissionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public int compareTo(Employee o) {
//        return this.getAdmissionDate().compareTo(o.getAdmissionDate()); // antiga para a mais recente (crescente)
        return o.getAdmissionDate().compareTo(this.getAdmissionDate()); // mais recente para a mais antiga (decrescente)
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", admissionDate=" + admissionDate +
                '}';
    }
}

