package entities.enm;

import exceptions.InvalidStatusException;

public enum Status {
    PENDING,
    IN_PROGRESS,
    DONE;

    public static Status getStatus(String status){
        switch (status) {
            case "pending":
                return PENDING;

            case "in progress":
                return IN_PROGRESS;

            case "done":
                return DONE;
        
            default:
                throw new InvalidStatusException("Invalid status: " + status);
        }
    }
}
