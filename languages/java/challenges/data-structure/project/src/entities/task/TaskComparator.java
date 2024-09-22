package entities.task;

import java.util.Comparator;

import entities.enm.Priority;

public class TaskComparator implements Comparator<Task>{
    
    // @Override
    // public int compare(Task task1, Task task2){
    //     return task1.getPriority().compareTo(task2.getPriority());
    // }

    @Override
    public int compare(Task task1, Task task2){
        if(task1.getPriority() == Priority.HIGHT) return -1; // insere primeiro
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.HIGHT)) return 1; // insere depois
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.MEDIUM)) return 1; // insere depois
        else if( (task1.getPriority() == Priority.LOW) &&  (task2.getPriority() == Priority.MEDIUM)) return 1; // insere no final
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.LOW)) return 0; // insere no final
        else return 0;
    }
}
