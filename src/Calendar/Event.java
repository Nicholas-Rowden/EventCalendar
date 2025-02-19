package Calendar;

import java.time.LocalDateTime;

/**
 * Abstract class representing an Event.
 * This class implements the Comparable interface for sorting events based on date and time.
 */
public abstract class Event implements Comparable<Event> {
    private String name; // The name of the event.
    private LocalDateTime dateTime; // The date and time of the event.

    /**
     * Constructor to initialize the event's name and date-time.
     *
     * @param name The name of the event.
     * @param dateTime The date and time of the event.
     */
    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    /**
     * Returns the name of the event.
     *
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event.
     *
     * @param name The name of the event.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date and time of the event.
     *
     * @return The date and time of the event.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the event.
     *
     * @param dateTime The date and time to be set for the event.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Returns the start time of the event.
     * Alias method for getDateTime().
     *
     * @return The start time of the event.
     */
    public LocalDateTime getStartTime() {
        return dateTime;
    }

    /**
     * Compares this event with the specified event for order based on date and time.
     *
     * @param e The event to be compared.
     * @return A negative integer, zero, or a positive integer as this event is less than, equal to, or greater than the specified event.
     */
    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }
}
