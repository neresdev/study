package app;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import entities.enm.Priority;
import entities.task.Task;
import entities.task.TaskComparator;
import service.TaskService;

public class App {

    /* public static void main(String[] args){
        var taskService = new TaskService();
        taskService.run();
    } */

    public static void main(String[] args){
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(2, new TaskComparator());
        var lowTask = new Task("low task", "low", "pending");
        var mediumTask = new Task("medium task", "medium", "pending");
        var hightTask = new Task("hight task", "hight", "pending");
        
        priorityQueue.offer(lowTask);
        priorityQueue.offer(mediumTask);
        priorityQueue.offer(hightTask);

        var comparator = new TaskComparator();

        int a = 0;
    }
    
}
