package app;

import java.util.Scanner;
import java.util.logging.Logger;

import entities.Task;

public class App {
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args){
        var scanner = new Scanner(System.in);

        log.info("Enter the description of the new task: ");
        var description = scanner.nextLine();

        log.info("Enter the priority (low/medium/hight) of the new task: ");
        var priority = scanner.nextLine();

        log.info("Enter the status (pending/in progress/done) of the new thask: ");
        var status = scanner.nextLine();

        var task = new Task(description, priority, status);

        System.out.println(task);
    }
}
