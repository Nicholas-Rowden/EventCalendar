package Calendar;  // Declares the package name (Calendar) to organize related classes

import java.time.LocalDateTime;  // Imports the LocalDateTime class to store date and time

/**
 * Abstract class Event that represents a general event with a name and date/time.
 * Implements Comparable<Event> to allow sorting events based on date/time.
 */
public abstract class Event implements Comparable<Event> {

    private String name;  // Stores the name of the event
    private LocalDateTime dateTime;  // Stores the date and time of the event

    /**
     * Gets the name of the event.
     * @return the event name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event.
     * @param name The new name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date and time of the event.
     * @return the event date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the event.
     * @param dateTime The new date and time of the event
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Compares this event's date/time with another event's date/time.
     * This allows sorting events in chronological order.
     *
     * @param e The event to compare to
     * @return a positive integer if this event occurs later,
     *         a negative integer if it occurs earlier,
     *         or 0 if they are at the same time.
     */
    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }
}
