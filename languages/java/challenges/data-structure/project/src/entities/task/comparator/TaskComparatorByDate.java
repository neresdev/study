package entities.task.comparator;

import entities.task.Task;
import java.util.Comparator;

public class TaskComparatorByDate implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        if(task1.getCreatedAt().isAfter(task2.getCreatedAt())) return -1; // insere antes de todo mundo
        if(task1.getCreatedAt().isBefore(task2.getCreatedAt())) return 1; // insere depois de todo mundo
        return 0;
        
    }
}
