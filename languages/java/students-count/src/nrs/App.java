package nrs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int studentsNumber;
        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();

        System.out.printf("How many students couse A have? ");
        studentsNumber = sc.nextInt();
        for(int i = 0; i < studentsNumber; i++){
            int studentId = sc.nextInt();
            courseA.add(studentId);
        }

        System.out.printf("How many students couse B have? ");
        studentsNumber = sc.nextInt();
        for(int i = 0; i < studentsNumber; i++){
            int studentId = sc.nextInt();
            courseB.add(studentId);
        }

        System.out.printf("How many students couse C have? ");
        studentsNumber = sc.nextInt();
        for(int i = 0; i < studentsNumber; i++){
            int studentId = sc.nextInt();
            courseC.add(studentId);
        }

        Set<Integer> total = new HashSet<>(courseA);
        total.addAll(courseB);
        total.addAll(courseC);

        System.out.println("Total students: " + total.size());
        sc.close();
    }
}
