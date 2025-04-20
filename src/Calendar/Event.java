package Calendar;

import java.time.LocalDateTime;

/**
 * Abstract base class for all events.
 * Implements Comparable to allow sorting by date.
 * Uses Template Method Pattern for the handle() method.
 * Supports Strategy Pattern via displayStrategy.
 */
public abstract class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime dateTime;

    protected DisplayStrategy displayStrategy;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() { return name; }
    public LocalDateTime getDateTime() { return dateTime; }

    // Strategy Pattern method
    public void setDisplayStrategy(DisplayStrategy strategy) {
        this.displayStrategy = strategy;
    }

    // Calls the current display strategy
    public void show() {
        if (displayStrategy != null) {
            displayStrategy.display(this);
        } else {
            System.out.println("No display strategy set for " + name);
        }
    }

    // Template Method Pattern: defines the overall workflow
    public final void handle() {
        prepare();  // Step 1: preparation
        execute();  // Step 2: actual work
        cleanup();  // Step 3: cleanup
    }

    // Default steps (can be overridden)
    protected void prepare() {
        System.out.println("Default preparation for event: " + name);
    }

    protected void execute() {
        System.out.println("Default execution for event: " + name);
    }

    protected void cleanup() {
        System.out.println("Default cleanup for event: " + name);
    }

    @Override
    public int compareTo(Event other) {
        return this.dateTime.compareTo(other.dateTime);
    }
}
