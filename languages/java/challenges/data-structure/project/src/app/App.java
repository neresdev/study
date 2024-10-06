package app;

import service.TaskService;

public class App {

    public static void main(String[] args){
        var taskService = new TaskService();
        taskService.run();
    }
    
}
