package application;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {
    private final List<People> events = new ArrayList<>();

    public void applyEvent(People event) {
        events.add(event);
    }
    public String getCurrentState() {
        return events.get(events.size() - 1).getData();
    }

    public List<String> getAllStates() {
        List<String> currentState = new ArrayList<>();
        for (People event : events) {
            currentState.add(event.getData());
        }
        return  currentState;
    }
}
