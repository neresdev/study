package entities.enm;

import exceptions.InvalidPriorityException;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGHT(3);

    private int code;

    private Priority(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

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
