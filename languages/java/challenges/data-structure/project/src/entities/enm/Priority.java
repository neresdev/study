package entities.enm;

import exceptions.InvalidPriorityException;

public enum Priority {
    LOW,
    MEDIUM,
    HIGHT;

    public static Priority getPriority(String priority){
        switch (priority) {
            
            case "low":
                return LOW;

            case "medium":
                return MEDIUM;

            case "hight":
                return HIGHT;

            default:
                throw new InvalidPriorityException("Invalid priority: " + priority);
        }
    }
}
