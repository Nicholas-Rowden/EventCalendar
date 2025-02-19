package Calendar;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Class to test the functionality of Event-related classes.
 */
public class EventTester {

    public static void main(String[] args) {
        testMeetingCreation();
        testCompleteFunction();
        testDurationCalculation();
        testLocationUpdate();
        testEndTimeUpdate();
    }

    /**
     * Test case to validate the creation of a Meeting object.
     */
    private static void testMeetingCreation() {
        System.out.println("=== Test: Meeting Creation ===");
        LocalDateTime start = LocalDateTime.of(2025, 2, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025, 2, 10, 11, 0);
        Meeting meeting = new Meeting("Team Meeting", start, end, "Conference Room A");

        System.out.println("Meeting Name: " + meeting.getName());
        System.out.println("Start Time: " + meeting.getStartTime());
        System.out.println("End Time: " + meeting.getEndTime());
        System.out.println("Location: " + meeting.getLocation());
        System.out.println("Is Completed? " + meeting.isComplete());
        System.out.println();
    }

    /**
     * Test case to validate the completion functionality of a Meeting object.
     */
    private static void testCompleteFunction() {
        System.out.println("=== Test: Completing a Meeting ===");
        LocalDateTime start = LocalDateTime.of(2025, 2, 10, 14, 0);
        LocalDateTime end = LocalDateTime.of(2025, 2, 10, 15, 0);
        Meeting meeting = new Meeting("Project Discussion", start, end, "Zoom");

        System.out.println("Before Completion: " + meeting.isComplete());
        meeting.complete();
        System.out.println("After Completion: " + meeting.isComplete());
        System.out.println();
    }

    /**
     * Test case to validate the duration calculation of a Meeting object.
     */
    private static void testDurationCalculation() {
        System.out.println("=== Test: Meeting Duration ===");
        LocalDateTime start = LocalDateTime.of(2025, 2, 10, 9, 30);
        LocalDateTime end = LocalDateTime.of(2025, 2, 10, 11, 0);
        Meeting meeting = new Meeting("Stand-up Meeting", start, end, "Room 102");

        Duration duration = meeting.getDuration();
        System.out.println("Expected Duration: 1 hour 30 minutes");
        System.out.println("Actual Duration: " + duration.toHours() + " hours and " +
                (duration.toMinutes() % 60) + " minutes");
        System.out.println();
    }

    /**
     * Test case to validate the location update functionality of a Meeting object.
     */
    private static void testLocationUpdate() {
        System.out.println("=== Test: Updating Meeting Location ===");
        LocalDateTime start = LocalDateTime.of(2025, 2, 10, 16, 0);
        LocalDateTime end = LocalDateTime.of(2025, 2, 10, 17, 0);
        Meeting meeting = new Meeting("Client Call", start, end, "Office");

        System.out.println("Before Update: " + meeting.getLocation());
        meeting.setLocation("Online - Google Meet");
        System.out.println("After Update: " + meeting.getLocation());
        System.out.println();
    }

    /**
     * Test case to validate the end time update functionality of a Meeting object.
     */
    private static void testEndTimeUpdate() {
        System.out.println("=== Test: Updating Meeting End Time ===");
        LocalDateTime start = LocalDateTime.of(2025, 2, 10, 13, 0);
        LocalDateTime end = LocalDateTime.of(2025, 2, 10, 14, 0);
        Meeting meeting = new Meeting("Training Session", start, end, "Training Room");

        System.out.println("Before Update: " + meeting.getEndTime());

        LocalDateTime newEndTime = LocalDateTime.of(2025, 2, 10, 14, 30);
        meeting.setEndTime(newEndTime);

        System.out.println("After Update: " + meeting.getEndTime());
        System.out.println();
    }
}
