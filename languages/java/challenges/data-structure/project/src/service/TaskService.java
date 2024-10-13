package service;

import entities.enm.Priority;
import entities.enm.Status;
import entities.task.Task;
import entities.task.comparator.TaskComparatorByDate;
import entities.task.comparator.TaskComparatorByPriority;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
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
        taskQueue = new PriorityQueue<>(new TaskComparatorByPriority());
        historico = new Stack<>();
    }

    public void run(){
        var scanner = new Scanner(System.in);
        var choice = "";
        
        while(!choice.equals("8")){
            QuestionsUtils.printQuestions(); 

            choice = scanner.nextLine();

            if(choice.equals("1")) printAllTasks(scanner);
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
            }else if(choice.equals("7")) {
                printHistoric();
            }else if(choice.equals("9")) {
                System.out.println("[developer option] - incrementing tasks...");
                incrementTasks();
                System.out.println("[developer option] - done!");
            }
        }
        scanner.close();
    }

    private void printHistoric(){
        historico.forEach(System.out::println);
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
        
        Task newTask;

        if(newStatus == Status.DONE){
            newTask = new Task(UUID.fromString(taskId), modifiedTask.getDescription(), modifiedTask.getPriority(), newStatus, LocalDate.now());
            historico.push(newTask);
        }else{
            newTask = new Task(UUID.fromString(taskId), modifiedTask.getDescription(), modifiedTask.getPriority(), newStatus);
        }
        
        modifiedTask.setStatus(newStatus);

        taskQueue.removeIf(task -> task.getId().equals(UUID.fromString(taskId)));
        taskQueue.offer(newTask);
        
    }

    private void printTasksByPriority(String priorityString){
        var priority = Priority.getPriority(priorityString);
        var priorityTasks = taskQueue.stream().filter(task -> task.getPriority() == priority).toList();
        priorityTasks.forEach(System.out::println);
    }

    private void deleteTaskById(String taskId){
        tasks.removeIf(t -> t.getId().equals(UUID.fromString(taskId)));
        mapTasks.remove(UUID.fromString(taskId));
    }

    private void printAllTasks(Scanner scanner) {
        System.out.println("Type the ordenation method (priority (default) / date)");
        var ordenationMethod = scanner.nextLine();

        if(ordenationMethod.equalsIgnoreCase("date")){
            var taskQueueByDate = new PriorityQueue<>(new TaskComparatorByDate());
            tasks.forEach(taskQueueByDate::offer);
            while(!taskQueueByDate.isEmpty()){
                System.out.println(taskQueueByDate.poll());
            }
            
            return;
        }

        taskQueue.forEach(t -> System.out.println(t.toString()));
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

    private void incrementTasks(){
        var task1 = new Task(UUID.randomUUID(), "task1", genereteRandomDate(),Priority.LOW, Status.IN_PROGRESS);
        var task2 = new Task(UUID.randomUUID(), "task2", genereteRandomDate(),Priority.MEDIUM, Status.DONE);
        var task3 = new Task(UUID.randomUUID(), "task3", genereteRandomDate(),Priority.HIGHT, Status.PENDING);
        var task4 = new Task(UUID.randomUUID(), "task4", genereteRandomDate(),Priority.LOW, Status.PENDING);
        var task5 = new Task(UUID.randomUUID(), "task3", genereteRandomDate(),Priority.MEDIUM, Status.IN_PROGRESS);

        List.of(task1, task2, task3, task4, task5).forEach(t -> {
            tasks.add(t);
            mapTasks.put(t.getId(), t);
            taskQueue.offer(t);
        });
    }

     public LocalDate genereteRandomDate() {
        LocalDate dataMinima = LocalDate.of(1900, 1, 1);
        LocalDate dataMaxima = LocalDate.now();
        long diasEntre = dataMinima.toEpochDay() + 
                         ThreadLocalRandom.current().nextLong(0, dataMaxima.toEpochDay() - dataMinima.toEpochDay() + 1);
        return LocalDate.ofEpochDay(diasEntre);
    }

}

