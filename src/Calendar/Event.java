package Calendar;

import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public abstract String getName(); // Must be implemented in subclasses

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }

    protected String getEventName() { // Provide a protected getter for subclasses
        return this.name;
    }
}
