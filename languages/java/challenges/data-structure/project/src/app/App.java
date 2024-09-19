package app;

import java.util.LinkedList;
import java.util.List;

import service.TaskService;

public class App {

    public static void main(String[] args){
        var taskService = new TaskService();
        taskService.run();
    }


    
}
