package Calendar;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 * A meeting event with a start time, end time, and location.
 * Overrides preparation and cleanup steps.
 */
public class Meeting extends Event {
    private LocalDateTime endTime;
    private String location;

    public Meeting(String name, LocalDateTime startTime, LocalDateTime endTime, String location) {
        super(name, startTime);
        this.endTime = endTime;
        this.location = location;
    }

    public LocalDateTime getEndTime() { return endTime; }
    public String getLocation() { return location; }

    public Duration getDuration() {
        return Duration.between(getDateTime(), endTime);
    }

    @Override
    protected void prepare() {
        System.out.println("Preparing agenda and inviting attendees for meeting: " + getName());
    }

    @Override
    protected void cleanup() {
        System.out.println("Sending meeting notes for: " + getName());
    }
}
