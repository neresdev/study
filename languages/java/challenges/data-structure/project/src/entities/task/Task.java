package entities.task;

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

    private LocalDate conclusionDate;
    
    public Task(String description, String stringPriority, String stringStatus){        
        this.id = UUID.randomUUID();
        this.description = description;
        this.createdAt = LocalDate.now();
        this.priority = Priority.getPriority(stringPriority);
        this.status = Status.fromString(stringStatus);
    }

    public Task(UUID id, String description, Priority priority, Status status){        
        this.id = id;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.priority = priority;
        this.status = status;
    }

    public Task(UUID id, String description, LocalDate createdAt, Priority priority, Status status){        
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
    }
    

    public Task(UUID id, String description, Priority priority, Status status, LocalDate conclusionDate){        
        this.id = id;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.priority = priority;
        this.status = status;
        this.conclusionDate = conclusionDate;
    }

    @Override
    public String toString() {
        return "task id =" + id + ", description=" + description + ", createdAt=" + createdAt + ", priority=" + priority
                + ", status=" + status + ", conclusionDate=" + conclusionDate;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public UUID getId(){
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    


    


    
}
