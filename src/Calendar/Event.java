package Calendar;

import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime dateTime;

    protected DisplayStrategy displayStrategy;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDisplayStrategy(DisplayStrategy strategy) {
        this.displayStrategy = strategy;
    }

    public void show() {
        if (displayStrategy != null) {
            displayStrategy.display(this);
        } else {
            System.out.println("No display strategy set for " + name);
        }
    }

    // Template method
    public final void handle() {
        prepare();
        execute();
        cleanup();
    }

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
