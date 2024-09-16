package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

import entities.Task;
import utils.QuestionsUtils;

public class App {
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var choice = "";
        List<Task> tasks = new LinkedList<>();
        
        while(!choice.equals("5")){
            QuestionsUtils.printQuestions(); 

            choice = scanner.nextLine();

            if(choice.equals("1")) printAllTasks(tasks);

            else if(choice.equals("2")){
                System.out.println("Enter the ID of the task you want to see the details of");
                var taskId = scanner.nextLine();
                printSpecificTask(tasks, taskId);

            }else if(choice.equals("3")) addTask(scanner, tasks);
            else if(choice.equals("4")) {
                System.out.println("Enter the ID of the task you want to delete");
                var taskId = scanner.nextLine();
                deleteTaskById(tasks, taskId);
            }

        }
       
        scanner.close();
    }


    private static void deleteTaskById(List<Task> tasks, String taskId){
        tasks.removeIf(t -> t.getId().equals(UUID.fromString(taskId)));
    }

    private static void printAllTasks(List<Task> tasks) {
        tasks.forEach(t -> System.out.println(t.toString()));
    }

    private static void printSpecificTask(List<Task> tasks, String taskId){
        var message = "Task found: \n";
        System.out.println(message + tasks
            .stream()
            .filter(t -> t.getId().equals(UUID.fromString(taskId)))
            .toList()
            .get(0));
    }


    private static void addTask(Scanner scanner, List<Task> tasks){
        log.info("Enter the description of the new task: ");
        var description = scanner.nextLine();

        log.info("Enter the priority (low/medium/hight) of the new task: ");
        var priority = scanner.nextLine();

        log.info("Enter the status (pending/in progress/done) of the new thask: ");
        var status = scanner.nextLine();

        tasks.add(new Task(description, priority, status));
        
    }
}
