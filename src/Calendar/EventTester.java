package Calendar;

import java.time.LocalDateTime;

public class EventTester {
    public static void main(String[] args) {
        Event teamMeeting = new Meeting(
                "Team Sync",
                LocalDateTime.of(2025, 4, 18, 10, 0),
                LocalDateTime.of(2025, 4, 18, 12, 0),
                "Zoom"
        );

        Event projectDeadline = new Deadline(
                "Project Phase 2",
                LocalDateTime.of(2025, 4, 20, 23, 59)
        );

        teamMeeting.setDisplayStrategy(new SimpleDisplay());
        projectDeadline.setDisplayStrategy(new FancyDisplay());

        teamMeeting.show();
        projectDeadline.show();

        teamMeeting.handle();
        System.out.println("-----");
        projectDeadline.handle();
    }
}
