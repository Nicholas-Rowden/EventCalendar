package Calendar;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Class representing a Meeting event.
 * This class extends the Event class and implements the Completable interface.
 */
public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime; // The end date and time of the meeting
    private String location; // The location of the meeting
    private boolean isCompleted; // Status indicating whether the meeting is completed

    /**
     * Constructor to initialize the meeting with its name, start time, end time, and location.
     *
     * @param name     The name of the meeting.
     * @param start    The start date and time of the meeting.
     * @param end      The end date and time of the meeting.
     * @param location The location of the meeting.
     */
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endDateTime = end;
        this.location = location;
        this.isCompleted = false;
    }

    /**
     * Marks the meeting as complete.
     */
    @Override
    public void complete() {
        this.isCompleted = true;
    }

    /**
     * Checks whether the meeting is complete.
     *
     * @return true if the meeting is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return isCompleted;
    }

    /**
     * Returns the end date and time of the meeting.
     *
     * @return The end date and time of the meeting.
     */
    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    /**
     * Sets the end date and time of the meeting.
     * Ensures that the end time is after the start time.
     *
     * @param end The end date and time to be set.
     */
    public void setEndTime(LocalDateTime end) {
        if (end.isAfter(getDateTime())) {
            this.endDateTime = end;
        } else {
            throw new IllegalArgumentException("End time must be after start time.");
        }
    }

    /**
     * Returns the duration of the meeting.
     *
     * @return The duration of the meeting.
     */
    public Duration getDuration() {
        return Duration.between(getDateTime(), endDateTime);
    }

    /**
     * Returns the location of the meeting.
     *
     * @return The location of the meeting.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the meeting.
     * Ensures that the location is not null or empty.
     *
     * @param location The location to be set.
     */
    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("Location cannot be empty.");
        }
    }
}
