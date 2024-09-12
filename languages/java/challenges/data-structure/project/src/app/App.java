package app;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

import entities.Task;

public class App {
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var choice = "";
        
        while(!choice.equals("5")){
            System.out.println("Choose one of the options below: ");
            System.out.println("1 - View all tasks");
            System.out.println("2 - View a specific task");
            System.out.println("3 - Create a new task");
            System.out.println("4 - Delete a task");
            System.out.println("5 - Exit");
            
            choice = scanner.nextLine();
        }
        

       
        scanner.close();
    }

    private static void clearConsole(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    private static void addTask(Scanner scanner, LinkedList<Task> tasks){
        log.info("Enter the description of the new task: ");
        var description = scanner.nextLine();

        log.info("Enter the priority (low/medium/hight) of the new task: ");
        var priority = scanner.nextLine();

        log.info("Enter the status (pending/in progress/done) of the new thask: ");
        var status = scanner.nextLine();

        tasks.add(new Task(description, priority, status));
        
    }
}
