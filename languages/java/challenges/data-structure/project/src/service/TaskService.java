package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;
import java.util.logging.Logger;

import entities.enm.Priority;
import entities.enm.Status;
import entities.task.Task;
import entities.task.TaskComparator;
import utils.QuestionsUtils;

public class TaskService { 
    private static final Logger log = Logger.getLogger(TaskService.class.getName());

    private List<Task> tasks;
    private Map<UUID, Task> mapTasks;
    private PriorityQueue<Task> taskQueue;
    private Stack<Task> historico;

    public TaskService() {
        tasks = new ArrayList<>();
        mapTasks = new HashMap<>();
        taskQueue = new PriorityQueue<>(new TaskComparator());
        historico = new Stack<>();
    }

    public void run(){
        var scanner = new Scanner(System.in);
        var choice = "";
        
        while(!choice.equals("7")){
            QuestionsUtils.printQuestions(); 

            choice = scanner.nextLine();

            if(choice.equals("1")) printAllTasks();

            else if(choice.equals("2")){
                System.out.println("Enter the ID of the task you want to see the details of");
                var taskId = scanner.nextLine();
                printSpecificTask(taskId);

            }
            else if(choice.equals("3")){
                System.out.println("Enter the priority (low/medium/right)");
                var priority = scanner.nextLine();
                printTasksByPriority(priority);
            }
            else if(choice.equals("4")) addTask(scanner);
            else if(choice.equals("5")) {
                updateTask(scanner);
            }
            else if(choice.equals("6")) {
                System.out.println("Enter the ID of the task you want to delete");
                var taskId = scanner.nextLine();
                deleteTaskById(taskId);
            }
        }
        scanner.close();
    }

    private void updateTask(Scanner sc){
        System.out.println("Type the id of the task you want to update the status: \n");
        tasks.forEach(task -> System.out.println(task.getId()));
        var taskId = sc.nextLine();

        System.out.println("Type the status of the task " + taskId);
        var newStatus = Status.fromString(sc.nextLine().toLowerCase());

        tasks.forEach(t -> {
            if(t.getId().equals(UUID.fromString(taskId))){
                t.setStatus(newStatus);
            }
        });

        var modifiedTask = mapTasks.get(UUID.fromString(taskId));
        modifiedTask.setStatus(newStatus);

        taskQueue.removeIf(task -> task.getId().equals(UUID.fromString(taskId)));
        taskQueue.offer(new Task(UUID.fromString(taskId), modifiedTask.getDescription(), modifiedTask.getPriority(), newStatus));

        
    }

    private void printTasksByPriority(String priorityString){ // TODO refactor
        var priority = Priority.getPriority(priorityString);
        var priorityTasks = taskQueue.stream().filter(task -> task.getPriority() == priority).toList();
        priorityTasks.forEach(System.out::println);
    }

    private void deleteTaskById(String taskId){
        tasks.removeIf(t -> t.getId().equals(UUID.fromString(taskId)));
        mapTasks.remove(UUID.fromString(taskId));
    }

    private void printAllTasks() {
        tasks.forEach(t -> System.out.println(t.toString()));
    }

    private void printSpecificTask(String taskId){
        Task taskFound;
        
        try{
            taskFound  = mapTasks.get(UUID.fromString(taskId));
        }catch (IllegalArgumentException e){
            taskFound = null;
        }

        if(Objects.isNull(taskFound)){
            System.out.printf("Task with ID %s not found %n %n", taskId);
            return;
        }

        System.out.println("task found: " + taskFound);
        
    }


    private void addTask(Scanner scanner){
        log.info("Enter the description of the new task: ");
        var description = scanner.nextLine();

        log.info("Enter the priority (low/medium/hight) of the new task: ");
        var priority = scanner.nextLine();

        log.info("Enter the status (pending/in progress/done) of the new thask: ");
        var status = scanner.nextLine();

        var task = new Task(description, priority, status);

        tasks.add(task);
        mapTasks.put(task.getId(), task);
        taskQueue.offer(task);

    }

    private void findByPriority(String priority){
        
    }
}

