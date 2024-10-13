package app;

import service.TaskService;

public class App {

    public static void main(String[] args){
        new TaskService().run();
    }   
}
