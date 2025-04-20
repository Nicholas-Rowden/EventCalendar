package Calendar;

import java.time.LocalDateTime;

/**
 * A deadline event that only overrides the execution logic.
 */
public class Deadline extends Event {

    public Deadline(String name, LocalDateTime dateTime) {
        super(name, dateTime);
    }

    @Override
    protected void execute() {
        System.out.println("Checking status of deadline: " + getName());
    }
}
