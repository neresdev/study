package entities.task.comparator;

import java.util.Comparator;

import entities.enm.Priority;
import entities.task.Task;

public class TaskComparatorByPriority implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        if(task1.getPriority() == Priority.HIGHT) return -1; // insere primeiro
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.HIGHT)) return 1; // insere depois
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.MEDIUM)) return 0;
        else if( (task1.getPriority() == Priority.LOW) &&  (task2.getPriority() == Priority.MEDIUM)) return 1; // insere no final
        else if( (task1.getPriority() == Priority.MEDIUM) &&  (task2.getPriority() == Priority.LOW)) return -1; // insere no final
        else return 1;
    }
}
