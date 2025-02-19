package Calendar;

import java.time.LocalDateTime;

/**
 * Class representing a Deadline event.
 * This class extends the Event class and implements the Completable interface.
 */
public class Deadline extends Event implements Completable {
    private boolean complete; // Status indicating whether the deadline is complete.

    /**
     * Constructor to initialize the deadline with its name and deadline date-time.
     *
     * @param name The name of the deadline.
     * @param deadline The date and time of the deadline.
     */
    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.complete = false;
    }

    /**
     * Marks the deadline as complete.
     */
    @Override
    public void complete() {
        this.complete = true;
    }

    /**
     * Checks whether the deadline is complete.
     *
     * @return true if the deadline is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return complete;
    }
}
