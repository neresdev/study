package entities;

import java.time.LocalDate;
import java.util.UUID;

import entities.enm.Priority;
import entities.enm.Status;

public class Task {
    private UUID id;
    
    private String description;
    
    private LocalDate createdAt;
    
    private Priority priority;
    
    private Status status;
    
    public Task(String description, String stringPriority, String stringStatus){        
        this.id = UUID.randomUUID();
        this.description = description;
        this.createdAt = LocalDate.now();
        this.priority = Priority.getPriority(stringPriority);
        this.status = Status.getStatus(stringStatus);
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", createdAt=" + createdAt + ", priority=" + priority
                + ", status=" + status + "]";
    }

    



    
}
