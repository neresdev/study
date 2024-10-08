package app;

import service.TaskService;
import java.util.List;

public class App {

    public static void main(String[] args){
        var taskService = new TaskService();
        taskService.run();
    }
    
}
