package Calendar;

import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean isCompleted;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endDateTime = end;
        this.location = location;
        this.isCompleted = false;
    }

    @Override
    public void complete() {
        this.isCompleted = true;
    }

    @Override
    public boolean isComplete() {
        return isCompleted;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    public void setEndTime(LocalDateTime end) {
        if (end.isAfter(getDateTime())) {
            this.endDateTime = end;
        } else {
            throw new IllegalArgumentException("End time must be after start time.");
        }
    }

    public Duration getDuration() {
        return Duration.between(getDateTime(), endDateTime);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("Location cannot be empty.");
        }
    }
}
